/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lps.sistemalocacaoimpressora.controller;

import java.util.List;
import javax.swing.JTable;
import lps.sistemalocacaoimpressora.model.Fornecedor;
import lps.sistemalocacaoimpressora.model.dao.FornecedorDAO;
import lps.sistemalocacaoimpressora.model.exceptions.FuncionarioException;
import lps.sistemalocacaoimpressora.model.valid.ValidateFornecedor;

public class FornecedorController {

    private final FornecedorDAO repositorio;

    public FornecedorController() {
        repositorio = new FornecedorDAO();
    }

    public void cadastrarFornecedor(String nome, String cnpj, String pecas, String cartucho) {
        ValidateFornecedor valid = new ValidateFornecedor();
        Fornecedor novoFornecedor = valid.validacao(nome, cnpj, pecas, cartucho);
        if (repositorio.findByCnpj(cnpj) == null) {
            repositorio.save(novoFornecedor);
        } else {
            throw new FuncionarioException("Error - Já existe um Fornecedor com este 'cnpj'.");
        }
    }
     
    public void atualizarTabela(JTable grd) {
        List<Fornecedor> lst = repositorio.findAll();

        TMCadFornecedor tmFornecedor = new TMCadFornecedor(lst);
        grd.setModel(tmFornecedor);
    }
    
    public void excluirFornecedor(Fornecedor fornecedor) {
        if (fornecedor != null) {
            repositorio.delete(fornecedor);
        } else {
            throw new FuncionarioException("Error - Fornecedor inexistente.");
        }
    }
    
    public void atualizarFornecedor(long idFuncionario, String nome, String cnpj, String pecas, String cartucho) {
        ValidateFornecedor valid = new ValidateFornecedor();
        Fornecedor novoFornecedor;
        novoFornecedor = valid.validacao(nome, cnpj, pecas, cartucho);
        novoFornecedor.setId(idFuncionario);
        repositorio.save(novoFornecedor);
    }

    public Fornecedor buscarFuncionario(String cnpj) {
        return (Fornecedor) this.repositorio.findByCnpj(cnpj);
    }

}
