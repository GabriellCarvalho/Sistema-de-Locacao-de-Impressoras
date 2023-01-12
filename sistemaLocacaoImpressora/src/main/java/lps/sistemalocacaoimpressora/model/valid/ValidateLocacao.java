/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lps.sistemalocacaoimpressora.model.valid;

import lps.sistemalocacaoimpressora.model.Cliente;
import lps.sistemalocacaoimpressora.model.Impressora;
import lps.sistemalocacaoimpressora.model.Locacao;
import lps.sistemalocacaoimpressora.model.LocacaoPJ;
import lps.sistemalocacaoimpressora.model.PessoaJuridica;
import lps.sistemalocacaoimpressora.model.exceptions.ClienteException;
import lps.sistemalocacaoimpressora.model.exceptions.ImpressoraException;

public class ValidateLocacao {

    public Locacao alugar(Cliente cliente, Impressora impressora, String tempo, String valor) {

        Locacao l = new Locacao();
        if (cliente == null) {
            throw new ClienteException("Error - Cliente nao informado");
        }
        l.setCliente(cliente);

        if (impressora == null) {
            throw new ImpressoraException("Error - Impressora nao informada");
        }
        l.setImpressora(impressora);
        
        if(tempo.isEmpty()){
            throw new ImpressoraException("Error - Campo vazio: 'tempo'.");
        }
        l.setTempo(Integer.parseInt(tempo));
        
        if(valor.isEmpty()){
            throw new ImpressoraException("Error - Campo vazio: 'valor'.");
        }
        l.setValor(Float.parseFloat(valor));
        
        return (Locacao) l;
    }
    
    public LocacaoPJ alugarPJ(PessoaJuridica cliente, Impressora impressora, String tempo, String valor) {

        LocacaoPJ l = new LocacaoPJ();
        if (cliente == null) {
            throw new ClienteException("Error - Cliente nao informado");
        }
        l.setCliente(cliente);

        if (impressora == null) {
            throw new ImpressoraException("Error - Impressora nao informada");
        }
        l.setImpressora(impressora);
        
        if(tempo.isEmpty()){
            throw new ImpressoraException("Error - Campo vazio: 'tempo'.");
        }
        l.setTempo(Integer.parseInt(tempo));
        
        if(valor.isEmpty()){
            throw new ImpressoraException("Error - Campo vazio: 'valor'.");
        }
        l.setValor(Float.parseFloat(valor));
        
        return (LocacaoPJ) l;
    }
}
