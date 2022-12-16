/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lps.sistemalocacaoimpressora.model.valid;

import lps.sistemalocacaoimpressora.model.Funcionario;
import lps.sistemalocacaoimpressora.model.exceptions.FuncionarioException;

public class ValidateLogin {
    
    public void validEntrada(String cpf, String senha){
        if (cpf.isEmpty()) {
            throw new FuncionarioException("Error - Campo vazio 'cpf'.");
        } 
        
        if (senha.isEmpty()) {
            throw new FuncionarioException("Error - Campo vazio 'senha'.");
        }
    }
    public void validLogin(Funcionario funcionario, String senha) {
        
        if (funcionario == null) {
            throw new FuncionarioException("Erro - Funcionario nao cadastrado.");
        }
        
        if (!funcionario.getSenha().equals(senha)) {
            throw new FuncionarioException("Erro - Senha incorreta.");
        }
    }
    
    public void validAcesso(Funcionario funcionario, String permicao){
        if (!funcionario.getCargo().equals(permicao)) {
            throw new FuncionarioException("Erro - Acesso negado.");
        }
    }
}
