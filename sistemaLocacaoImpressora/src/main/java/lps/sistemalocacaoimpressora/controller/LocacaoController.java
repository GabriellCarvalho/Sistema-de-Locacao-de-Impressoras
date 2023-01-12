/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lps.sistemalocacaoimpressora.controller;

import java.util.List;
import javax.swing.JTable;
import lps.sistemalocacaoimpressora.model.Cliente;
import lps.sistemalocacaoimpressora.model.Impressora;
import lps.sistemalocacaoimpressora.model.Locacao;
import lps.sistemalocacaoimpressora.model.dao.ImpressoraDAO;
import lps.sistemalocacaoimpressora.model.dao.LocacaoDAO;
import lps.sistemalocacaoimpressora.model.exceptions.ImpressoraException;
import lps.sistemalocacaoimpressora.model.valid.ValidateLocacao;

public class LocacaoController {

    private final LocacaoDAO repositorio;
    private final ImpressoraDAO impressora;

    public LocacaoController() {
        repositorio = new LocacaoDAO();
        impressora = new ImpressoraDAO();
    }

    public void alugarImpressora(Cliente cliente, Impressora impressora) {
        ValidateLocacao valid = new ValidateLocacao();
        Locacao aluga = new Locacao();
        aluga = valid.alugar(cliente, impressora);
    }
    
    
    public void atualizarTabelaLocacao(JTable grd) {
        List<Locacao> lst = repositorio.findAll();
        
        TMCadLocacao tmLocacao = new TMCadLocacao(lst);
        grd.setModel(tmLocacao);
    }
    
    public void excluirLocacao(Locacao locacao) {
        if(locacao != null) {
            repositorio.delete(locacao);
        } else {
            throw new ImpressoraException("Error - registro de aluguel nao encontrado.");
        }  
    }
    
    public Locacao buscarLocacao(int id) {
        return (Locacao) this.repositorio.find(id);
    }
}