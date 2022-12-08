/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lps.sistemalocacaoimpressora.model;

import java.io.Serializable;
import javax.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class Funcionario extends Pessoa implements Serializable {

    private String senha;
    private String cargo;
    private double salario;

    public Funcionario() {
        super();
        this.senha = "";
        this.cargo = "";
        this.salario = -1;
    }

    public Funcionario(String nome, int idade, char sexo, String cpf, String cargo, double salario ,String senha) {
        super(nome, idade, sexo, cpf);
        this.cargo = cargo;
        this.salario = salario;
        this.senha = senha;
    }

}
