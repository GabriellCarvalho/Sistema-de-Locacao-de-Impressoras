/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lps.sistemalocacaoimpressora.controller;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import lps.sistemalocacaoimpressora.model.Locacao;

public class TMCadLocacao extends AbstractTableModel {

    private List<Locacao> lista;
    private final int COL_CLIENTE = 0;
    private final int COL_IMPRESSORAS = 1;

    public TMCadLocacao(List<Locacao> lstLocacao) {
        lista = lstLocacao;
    }
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Locacao locacao = new Locacao();
        if (lista.isEmpty()) {
            return locacao;
        } else {
            locacao = (Locacao) lista.get(rowIndex);

            switch (columnIndex) {
                case -1:
                    return locacao;
                case COL_CLIENTE:
                    return locacao.getCliente();
                case COL_IMPRESSORAS:
                    return locacao.getImpressoras();
                default:
                    break;
            }
        }
        return locacao;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public String getColumnName(int column) {

        switch (column) {
            case COL_CLIENTE:
                return "Cliente";
            case COL_IMPRESSORAS:
                return "Impressoras";
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
