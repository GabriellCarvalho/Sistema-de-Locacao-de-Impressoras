/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lps.sistemalocacaoimpressora.model.valid;

import lps.sistemalocacaoimpressora.model.PessoaJuridica;
import lps.sistemalocacaoimpressora.model.exceptions.ClienteException;

public class ValidatePJuridica {
    
    public PessoaJuridica validacao(String nome, String email, String cnpj, String senha){
        PessoaJuridica pj = new PessoaJuridica();
        if (nome.isEmpty()) {
            throw new ClienteException("Error - Campo vazio: 'nome'.");
        }
        pj.setNome(nome);
        
        if (email.isEmpty()) {
            throw new ClienteException("Error - Campo vazio: 'email'.");
        }
        pj.setEmail(email);
        
        ValidateCNPJ validCNPJ = new ValidateCNPJ();
        if(!validCNPJ.validaCNPJ(cnpj)){
           throw new ClienteException("Error - CNPJ invalido"); 
        }
        pj.setCNPJ(cnpj);
        
        if (senha.isEmpty()) {
            throw new ClienteException("Error - Campo vazio: 'senha'.");
        }
        pj.setSenha(senha);
        
        return (PessoaJuridica) pj; 
    }
}
