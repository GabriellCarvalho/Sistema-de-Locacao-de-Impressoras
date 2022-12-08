/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lps.sistemalocacaoimpressora.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass
public class Pessoa {
    
    @Id
    protected long id;
    @Column
    protected String nome;
    @Column
    protected int idade;
    @Column
    protected char sexo;
    @Column
    protected String CPF;

    public Pessoa() {
        this.id = -1;
        this.nome = "";
        this.idade = -1;
        this.sexo = ' ';
        this.CPF = "";
    }
    
    public Pessoa(String nome, int idade, char sexo, String CPF) {
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.CPF = CPF;
    }
    
    
}
