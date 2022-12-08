/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lps.sistemalocacaoimpressora.controller;

import java.util.List;
import javax.swing.JTable;
import lps.sistemalocacaoimpressora.model.Funcionario;
import lps.sistemalocacaoimpressora.model.dao.FuncionarioDAO;

public class FuncionarioController {

    private FuncionarioDAO repositorio;

    public FuncionarioController() {
        repositorio = new FuncionarioDAO();
    }

    public void cadastrarFuncionario(String nome, String idade, String sexo, String cpf, String cargo, String salario, String senha) throws Exception {
        int i = Integer.parseInt(idade);
        Funcionario novoFuncionario = new Funcionario(nome, i, sexo.charAt(0), cpf, cargo, Double.parseDouble(salario), senha);
        if (repositorio.findByCpf(cpf) == null) {
            repositorio.save(novoFuncionario);
        } else {
            throw new Exception("Error - Já existe um funcionario com este 'CPF'.");
        }
    }
    
    public void atualizarTabela(JTable grd) {
        List<Funcionario> lst = repositorio.findAll();
        
        TMCadFuncionario tmFuncionario = new TMCadFuncionario(lst);
        grd.setModel(tmFuncionario);    
    }
    
    public void excluirFuncionario(Funcionario Funcionario) throws Exception {
        if (Funcionario != null) {
            repositorio.delete(Funcionario);
        } else {
            throw new Exception("Error - Funcionario inexistente.");
        }
    }
    
    public void atualizarFuncionario(long idFuncionario, String nome, String idade, String sexo, String cpf, String cargo, double salario, String senha){
        Funcionario novoFuncionario;
        novoFuncionario = new Funcionario(nome,Integer.parseInt(idade), sexo.charAt(0), cpf, cargo, salario, senha);
        repositorio.update(novoFuncionario);
    }
    
    public Funcionario buscarFuncionario(String cpf){
        return (Funcionario) this.repositorio.findByCpf(cpf);
    }
}
