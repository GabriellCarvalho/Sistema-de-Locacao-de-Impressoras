/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lps.sistemalocacaoimpressora.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class Funcionario extends Pessoa {
    private int id;
    private String senha;
    private String cargo;
    private double salario;

    public Funcionario(String nome, int idade, char sexo, String cpf, String senha) {
        super(nome, idade, sexo, cpf);
        this.senha = senha;
    }
    
}
