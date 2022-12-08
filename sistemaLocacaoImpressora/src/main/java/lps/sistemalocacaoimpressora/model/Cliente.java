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
public class Cliente extends Pessoa implements Serializable {
    
    private String email;
    private String senha;
    
    public Cliente(){
        super();
        this.email = "";
        this.senha = "";
    }
    
    public Cliente(String nome, int idade, char sexo, String cpf, String email, String senha) {
        super(nome, idade, sexo, cpf);
        this.email = email;
        this.senha = senha;
    }
}
