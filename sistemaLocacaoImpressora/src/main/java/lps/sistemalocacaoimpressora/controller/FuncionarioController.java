/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lps.sistemalocacaoimpressora.controller;

import lps.sistemalocacaoimpressora.model.Funcionario;
import lps.sistemalocacaoimpressora.model.dao.FuncionarioDAO;

public class FuncionarioController {

    private FuncionarioDAO repositorio;

    public FuncionarioController() {
        repositorio = new FuncionarioDAO();
    }

    public void cadastrarFuncionario(String nome, String idade, String sexo, String cpf, String senha) throws Exception {
        int i = Integer.parseInt(idade);
        Funcionario novoFuncionario = new Funcionario(nome, i, sexo.charAt(0), cpf, senha);
        if (repositorio.findByCpf(cpf) == null) {
            repositorio.save(novoFuncionario);
        } else {
            throw new Exception("Error - Já existe um funcionario com este 'CPF'.");
        }
    }
}
