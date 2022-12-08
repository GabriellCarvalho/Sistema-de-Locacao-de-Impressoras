/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lps.sistemalocacaoimpressora.controller;

import java.util.List;
import javax.swing.JTable;
import lps.sistemalocacaoimpressora.model.Impressora;
import lps.sistemalocacaoimpressora.model.dao.ImpressoraDAO;

public class ImpressoraController {
    private ImpressoraDAO repositorio;
   
    public ImpressoraController() {
        repositorio = new ImpressoraDAO();
    }
    
    public void cadastrarImpressora(String nome, String marca, String modelo, String tipo, String colorida) throws Exception{
        Impressora novaImpressora;
        if(colorida == "sim")
            novaImpressora = new Impressora(nome, marca, modelo, tipo, true);
        else
            novaImpressora = new Impressora(nome, marca, modelo, tipo, false);
        if (repositorio.findByNome(nome) == null) {
            repositorio.save(novaImpressora);
        } else {
            throw new Exception("Error - Já existe uma impressora com este 'nome'.");
        }
    }

    public void atualizarImpressora(long idImpressora, String nome, String marca, String modelo, String tipo, String colorida) {
        Impressora novaImpressora;
        if(colorida == "sim")
            novaImpressora = new Impressora(nome, marca, modelo, tipo, true);
        else
            novaImpressora = new Impressora(nome, marca, modelo, tipo, false);
        novaImpressora.setId(idImpressora);
        
        repositorio.update(novaImpressora);
    }

    public void atualizarTabela(JTable grd) {
        List<Impressora> lst = repositorio.findAll();
        
        TMCadImpressora tmImpressora = new TMCadImpressora(lst);
        grd.setModel(tmImpressora);    
    }
    
    public void excluirImpressora(Impressora impressora) throws Exception{
        if (impressora != null) {
            repositorio.delete(impressora);
        } else {
            throw new Exception("Error - impressora inexistente.");
        }
    } 
  
    public Impressora buscarImpressora(String nome) {
        return (Impressora) this.repositorio.findByNome(nome);
    }
}
