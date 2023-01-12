/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lps.sistemalocacaoimpressora.model.valid;

import lps.sistemalocacaoimpressora.model.Cliente;
import lps.sistemalocacaoimpressora.model.Impressora;
import lps.sistemalocacaoimpressora.model.Locacao;
import lps.sistemalocacaoimpressora.model.exceptions.ClienteException;
import lps.sistemalocacaoimpressora.model.exceptions.ImpressoraException;

public class ValidateLocacao {

    public Locacao alugar(Cliente cliente, Impressora impressora) {

        Locacao l = new Locacao();
        if (cliente == null) {
            throw new ClienteException("Error - Cliente nao informado");
        }
        l.setCliente(cliente);

        if (impressora == null) {
            throw new ImpressoraException("Error - Impressora nao informada");
        }
        l.addImpressora(impressora);
        
        return l;
    }
}
