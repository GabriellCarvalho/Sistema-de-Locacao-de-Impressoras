/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lps.sistemalocacaoimpressora.model.valid;

import lps.sistemalocacaoimpressora.model.Funcionario;
import lps.sistemalocacaoimpressora.model.exceptions.FuncionarioException;

public class ValidateFuncionario {

    public Funcionario validacao(String nome, String idade, String sexo, String cpf, String cargo, String salario, String senha) {
        Funcionario f = new Funcionario();
        if (nome.isEmpty()) {
            throw new FuncionarioException("Error - Campo vazio: 'nome'.");
        }
        f.setNome(nome);

        int idadeInt = 0;
        if (idade.isEmpty()) {
            throw new FuncionarioException("Error - Campo vazio: 'idade'.");
        }
        if (!idade.matches("[0-9]*")) {
            throw new FuncionarioException("Error - Valor inválido no campo 'idade'.");
        }
        idadeInt = Integer.parseInt(idade);
        f.setIdade(idadeInt);
        
        if (sexo.isEmpty()) {
            throw new FuncionarioException("Error - Campo vazio: 'sexo'.");
        }
        f.setSexo(sexo.charAt(0));

        if (cpf.isEmpty()) {
            throw new FuncionarioException("Error - Campo vazio: 'cpf'.");
        }

        ValidatePessoaFisica validCPF = new ValidatePessoaFisica();
        if (!validCPF.validaCPF(cpf)) {
            throw new FuncionarioException("Error - CPF invalido");
        }
        f.setCPF(cpf);

        if (cargo.isEmpty()) {
            throw new FuncionarioException("Error - Campo vazio: 'cargo'.");
        }
        f.setCargo(cargo);

        double salarioDouble = 0.0;
        if (salario.isEmpty()) {
            throw new FuncionarioException("Error - Campo vazio: 'salrio'.");
        }
        salarioDouble = Double.parseDouble(salario);
        f.setSalario(salarioDouble);

        if (senha.isEmpty()) {
            throw new FuncionarioException("Error - Campo vazio: 'senha'.");
        }
        f.setSenha(senha);
        return (Funcionario) f;
    }
}
