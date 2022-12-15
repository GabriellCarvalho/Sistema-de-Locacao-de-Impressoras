/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lps.sistemalocacaoimpressora.controller;

import java.util.List;
import javax.swing.JTable;
import lps.sistemalocacaoimpressora.model.Funcionario;
import lps.sistemalocacaoimpressora.model.dao.FuncionarioDAO;
import lps.sistemalocacaoimpressora.model.exceptions.FuncionarioException;
import lps.sistemalocacaoimpressora.model.valid.ValidateFuncionario;
import lps.sistemalocacaoimpressora.model.valid.ValidateLogin;

public class FuncionarioController {

    private final FuncionarioDAO repositorio;

    public FuncionarioController() {
        repositorio = new FuncionarioDAO();
    }

    public void cadastrarFuncionario(String nome, String idade, String sexo, String cpf, String cargo, String salario, String senha) {
        ValidateFuncionario valid = new ValidateFuncionario();
        Funcionario novoFuncionario = valid.validacao(nome, idade, sexo, cpf, cargo, salario, senha);
        if (repositorio.findByCpf(cpf) == null) {
            repositorio.save(novoFuncionario);
        } else {
            throw new FuncionarioException("Error - Já existe um funcionario com este 'CPF'.");
        }
    }

    public void atualizarTabela(JTable grd) {
        List<Funcionario> lst = repositorio.findAll();

        TMCadFuncionario tmFuncionario = new TMCadFuncionario(lst);
        grd.setModel(tmFuncionario);
    }

    public void excluirFuncionario(Funcionario Funcionario) {
        if (Funcionario != null) {
            repositorio.delete(Funcionario);
        } else {
            throw new FuncionarioException("Error - Funcionario inexistente.");
        }
    }

    public void atualizarFuncionario(long idFuncionario, String nome, String idade, String sexo, String cpf, String cargo, String salario, String senha) {
        ValidateFuncionario valid = new ValidateFuncionario();
        Funcionario novoFuncionario;
        novoFuncionario = valid.validacao(nome, idade, sexo, cpf, cargo, salario, senha);
        novoFuncionario.setId(idFuncionario);
        repositorio.save(novoFuncionario);
    }

    public Funcionario buscarFuncionario(String cpf) {
        return (Funcionario) this.repositorio.findByCpf(cpf);
    }

    public void checkLogin(String cpf, String senha) {
            ValidateLogin valid = new ValidateLogin();
            valid.validEntrada(cpf, senha);
            valid.validLogin(this.buscarFuncionario(cpf), senha);
    }
}
