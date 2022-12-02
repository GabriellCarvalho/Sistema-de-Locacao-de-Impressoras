/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lps.sistemalocacaoimpressora.model;

import lombok.Data;

@Data
public class Impressora {

    private int id;
    private String nome;
    private String marca;
    private String modelo;
    private String tipo;
    private boolean colorida;

    public Impressora() {
        this.nome = "";
        this.marca = "";
        this.modelo = "";
        this.tipo = "";
        this.colorida = false;
    }

    public Impressora(String nome, String marca, String modelo, String tipo, boolean colorida) {
        this.nome = nome;
        this.marca = marca;
        this.modelo = modelo;
        this.tipo = tipo;
        this.colorida = colorida;
    }
    
}