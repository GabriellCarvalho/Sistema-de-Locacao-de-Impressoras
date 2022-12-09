/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lps.sistemalocacaoimpressora.model.valid;

import lps.sistemalocacaoimpressora.model.Impressora;
import lps.sistemalocacaoimpressora.model.exceptions.ImpressoraException;

public class ValidateImpressora {

    public Impressora validacao(String nome, String marca, String modelo, String tipo, String colorida) {

        Impressora i = new Impressora();
        if (nome.isEmpty()) {
            throw new ImpressoraException("Error - Campo vazio: 'nome'.");
        }
        i.setNome(nome);

        if (marca.isEmpty()) {
            throw new ImpressoraException("Error - Campo vazio: 'marca'.");
        }
        i.setMarca(marca);

        if (modelo.isEmpty()) {
            throw new ImpressoraException("Error - Campo vazio: 'modelo'.");
        }
        i.setModelo(modelo);

        if (tipo.isEmpty()) {
            throw new ImpressoraException("Error - Campo vazio: 'tipo'.");
        }
        i.setTipo(tipo);

        if (colorida.isEmpty()) {
            throw new ImpressoraException("Error - Campo vazio: 'colorida'.");
        }
        if (colorida.equals("true")) {
            i.setColorida(true);
        } else {
            i.setColorida(false);
        }

        return (Impressora) i;
    }
}
