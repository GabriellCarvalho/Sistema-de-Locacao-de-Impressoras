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
import lps.sistemalocacaoimpressora.model.LocacaoPJ;
import lps.sistemalocacaoimpressora.model.PessoaJuridica;
import lps.sistemalocacaoimpressora.model.dao.LocacaoDAO;
import lps.sistemalocacaoimpressora.model.exceptions.ImpressoraException;
import lps.sistemalocacaoimpressora.model.valid.ValidateLocacao;

public class LocacaoController {

    private final LocacaoDAO repositorio;

    public LocacaoController() {
        repositorio = new LocacaoDAO();
    }

    public void alugarImpressora(Cliente cliente, Impressora impressora, String tempo, String valor) {
        ValidateLocacao valid = new ValidateLocacao();
        Locacao aluga;
        aluga = valid.alugar(cliente, impressora, tempo, valor);
        repositorio.save(aluga);
    }
    
    public void alugarImpressoraPJ(PessoaJuridica cliente, Impressora impressora, String tempo, String valor) {
        ValidateLocacao valid = new ValidateLocacao();
        LocacaoPJ aluga;
        aluga = valid.alugarPJ(cliente, impressora, tempo, valor);
        repositorio.savePJ(aluga);
    }
    
    
    public void atualizarTabelaLocacao(JTable grd) {
        List<Locacao> lst = repositorio.findAll();
        
        TMCadLocacao tmLocacao = new TMCadLocacao(lst);
        grd.setModel(tmLocacao);
    }
    
    public void atualizarTabelaLocacaoPJ(JTable grd) {
        List<LocacaoPJ> lst = repositorio.findAllPJ();
        
        TMCadLocacaoPJ tmLocacao = new TMCadLocacaoPJ(lst);
        grd.setModel(tmLocacao);
    }
    
    public void excluirLocacao(Locacao locacao) {
        if(locacao != null) {
            repositorio.delete(locacao);
            locacao.devolver();
        } else {
            throw new ImpressoraException("Error - registro de aluguel nao encontrado.");
        }  
    }
    
    public void excluirLocacaoPJ(LocacaoPJ locacao) {
        if(locacao != null) {
            repositorio.deletePJ(locacao);
            locacao.devolver();
        } else {
            throw new ImpressoraException("Error - registro de aluguel nao encontrado.");
        }  
    }
    
    public Locacao buscarLocacao(int id) {
        return (Locacao) this.repositorio.find(id);
    }
}