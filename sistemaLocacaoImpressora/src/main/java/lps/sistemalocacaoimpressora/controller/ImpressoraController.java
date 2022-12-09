/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lps.sistemalocacaoimpressora.controller;

import java.util.List;
import javax.swing.JTable;
import lps.sistemalocacaoimpressora.model.Impressora;
import lps.sistemalocacaoimpressora.model.dao.ImpressoraDAO;
import lps.sistemalocacaoimpressora.model.exceptions.ImpressoraException;
import lps.sistemalocacaoimpressora.model.valid.ValidateImpressora;

public class ImpressoraController {

    private final ImpressoraDAO repositorio;

    public ImpressoraController() {
        repositorio = new ImpressoraDAO();
    }

    public void cadastrarImpressora(String nome, String marca, String modelo, String tipo, String colorida) {
        ValidateImpressora valid = new ValidateImpressora();
        Impressora novaImpressora;
        novaImpressora = valid.validacao(nome, marca, modelo, tipo, colorida);
        if (repositorio.findByNome(nome) == null) {
            repositorio.save(novaImpressora);
        } else {
            throw new ImpressoraException("Error - Já existe uma impressora com este 'nome'.");
        }
    }

    public void atualizarImpressora(long idImpressora, String nome, String marca, String modelo, String tipo, String colorida) {
        ValidateImpressora valid = new ValidateImpressora();
        Impressora novaImpressora;
        novaImpressora = valid.validacao(nome, marca, modelo, tipo, colorida);
        novaImpressora.setId(idImpressora);
        repositorio.save(novaImpressora);
    }

    public void atualizarTabela(JTable grd) {
        List<Impressora> lst = repositorio.findAll();

        TMCadImpressora tmImpressora = new TMCadImpressora(lst);
        grd.setModel(tmImpressora);
    }

    public void excluirImpressora(Impressora impressora) {
        if (impressora != null) {
            repositorio.delete(impressora);
        } else {
            throw new ImpressoraException("Error - impressora inexistente.");
        }
    }

    public Impressora buscarImpressora(String nome) {
        return (Impressora) this.repositorio.findByNome(nome);
    }
}
