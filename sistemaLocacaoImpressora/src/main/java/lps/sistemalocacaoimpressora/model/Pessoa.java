/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lps.sistemalocacaoimpressora.model;

import lombok.Data;

@Data
public class Pessoa {
    protected String nome;
    protected int idade;
    protected char sexo;
    protected String CPF;

    public Pessoa(String nome, int idade, char sexo, String CPF) {
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.CPF = CPF;
    }
    
    
}
