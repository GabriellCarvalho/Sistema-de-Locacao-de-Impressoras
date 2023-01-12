/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lps.sistemalocacaoimpressora.controller;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import lps.sistemalocacaoimpressora.model.PessoaJuridica;

public class TMCadPJuridica extends AbstractTableModel {

    private List<PessoaJuridica> lista;
    private final int COL_NOME = 0;
    private final int COL_EMAIL = 1;
    private final int COL_CNPJ = 2;

    public TMCadPJuridica(List<PessoaJuridica> lstCliente) {
        lista = lstCliente;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        PessoaJuridica cliente = new PessoaJuridica();
        if (lista.isEmpty()) {
            return cliente;
        } else {
            cliente = (PessoaJuridica) lista.get(rowIndex);

            switch (columnIndex) {
                case -1:
                    return cliente;
                case COL_NOME:
                    return cliente.getNome();
                case COL_EMAIL:
                    return cliente.getEmail();
                case COL_CNPJ:
                    return cliente.getCNPJ();
                default:
                    break;
            }
        }
        return cliente;
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public String getColumnName(int column) {

        switch (column) {
            case COL_NOME:
                return "Nome";
            case COL_EMAIL:
                return "Email";
            case COL_CNPJ:
                return "CNPJ";
            default:
                break;
        }
        return "";
    }

    @Override
    public Class getColumnClass(int columnIndex) {
        return String.class;
    }

}
