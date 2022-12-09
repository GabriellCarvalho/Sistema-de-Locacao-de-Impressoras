/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lps.sistemalocacaoimpressora.model.valid;

import lps.sistemalocacaoimpressora.model.Cliente;
import lps.sistemalocacaoimpressora.model.exceptions.ClienteException;

public class ValidateCliente {

    public Cliente validacao(String nome, String idade, String sexo, String cpf, String email, String senha) {
        Cliente c = new Cliente();
        if (nome.isEmpty()) {
            throw new ClienteException("Error - Campo vazio: 'nome'.");
        }
        c.setNome(nome);

        int idadeInt = 0;
        if (idade.isEmpty()) {
            throw new ClienteException("Error - Campo vazio: 'idade'.");
        }
        if (!idade.matches("[0-9]*")) {
            throw new ClienteException("Error - Valor inválido no campo 'idade'.");
        }
        idadeInt = Integer.parseInt(idade);
        c.setIdade(idadeInt);
        
        if (sexo.isEmpty()) {
            throw new ClienteException("Error - Campo vazio: 'sexo'.");
        }
        c.setSexo(sexo.charAt(0));

        if (cpf.isEmpty()) {
            throw new ClienteException("Error - Campo vazio: 'cpf'.");
        }

        ValidatePessoaFisica validCPF = new ValidatePessoaFisica();
        if (!validCPF.validaCPF(cpf)) {
            throw new ClienteException("Error - CPF invalido");
        }
        c.setCPF(cpf);

        if (email.isEmpty()) {
            throw new ClienteException("Error - Campo vazio: 'email'.");
        }
        c.setEmail(email);

        if (senha.isEmpty()) {
            throw new ClienteException("Error - Campo vazio: 'senha'.");
        }
        c.setSenha(senha);

        return (Cliente) c;
    }
}
