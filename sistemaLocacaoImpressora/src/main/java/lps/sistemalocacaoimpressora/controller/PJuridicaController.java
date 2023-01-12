/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lps.sistemalocacaoimpressora.controller;

import java.util.List;
import javax.swing.JTable;
import lps.sistemalocacaoimpressora.model.PessoaJuridica;
import lps.sistemalocacaoimpressora.model.dao.PJuridicaDAO;
import lps.sistemalocacaoimpressora.model.exceptions.ClienteException;
import lps.sistemalocacaoimpressora.model.valid.ValidatePJuridica;

public class PJuridicaController {
    
    private final PJuridicaDAO repositorio;
    
    public PJuridicaController(){
        repositorio = new PJuridicaDAO();
    }
    
    public void cadastrarPJuridica(String nome,String email,String cnpj, String senha) {
        ValidatePJuridica valid = new ValidatePJuridica();
        PessoaJuridica novoCliente = valid.validacao(nome, email, cnpj, senha);
        if (repositorio.findByCnpj(cnpj) == null) {
            repositorio.save(novoCliente);
        } else {
            throw new ClienteException("Error - Já existe um cliente com este 'CNPJ'.");
        }
    }
    
    public void atualizarTabela(JTable grd) {
        List<PessoaJuridica> lst = repositorio.findAll();

        TMCadPJuridica tmClienteJ = new TMCadPJuridica(lst);
        grd.setModel(tmClienteJ);
    }
    
    public void excluirCliente(PessoaJuridica cliente){
        if (cliente != null) {
            repositorio.delete(cliente);
        } else {
            throw new ClienteException("Error - cliente inexistente.");
        }
    }
    
    public void atualizarCliente(long idCliente, String nome, String email,String cnpj, String senha) {
        ValidatePJuridica valid = new ValidatePJuridica();
        PessoaJuridica novoCliente = valid.validacao(nome, email, cnpj , senha);
        novoCliente.setId(idCliente);
        repositorio.save(novoCliente);
    }

    public PessoaJuridica buscarCliente(String cnpj) {
        return (PessoaJuridica) this.repositorio.findByCnpj(cnpj);
    }

}
