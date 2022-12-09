/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lps.sistemalocacaoimpressora.controller;

import java.util.List;
import javax.swing.JTable;
import lps.sistemalocacaoimpressora.model.Cliente;
import lps.sistemalocacaoimpressora.model.dao.ClienteDAO;
import lps.sistemalocacaoimpressora.model.exceptions.ClienteException;
import lps.sistemalocacaoimpressora.model.valid.ValidateCliente;

public class ClienteController {

    private final ClienteDAO repositorio;

    public ClienteController() {
        repositorio = new ClienteDAO();
    }

    public void cadastrarCliente(String nome, String idade, String sexo, String cpf, String email, String senha) {
        ValidateCliente valid = new ValidateCliente();
        Cliente novoCliente = valid.validacao(nome, idade, sexo, cpf, email, senha);
        if (repositorio.findByCpf(cpf) == null) {
            repositorio.save(novoCliente);
        } else {
            throw new ClienteException("Error - Já existe um cliente com este 'CPF'.");
        }
    }

    public void atualizarTabela(JTable grd) {
        List<Cliente> lst = repositorio.findAll();

        TMCadCliente tmCliente = new TMCadCliente(lst);
        grd.setModel(tmCliente);
    }

    public void excluirCliente(Cliente cliente){
        if (cliente != null) {
            repositorio.delete(cliente);
        } else {
            throw new ClienteException("Error - cliente inexistente.");
        }
    }

    public void atualizarCliente(long idCliente, String nome, String idade, String sexo, String cpf, String email, String senha) {
        ValidateCliente valid = new ValidateCliente();
        Cliente novoCliente = valid.validacao(nome, idade, sexo, cpf, email, senha);
        novoCliente.setId(idCliente);
        repositorio.save(novoCliente);
    }

    public Cliente buscarCliente(String cpf) {
        return (Cliente) this.repositorio.findByCpf(cpf);
    }

}
