/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lps.sistemalocacaoimpressora.controller;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import lps.sistemalocacaoimpressora.model.LocacaoPJ;

public class TMCadLocacaoPJ extends AbstractTableModel {
    private List<LocacaoPJ> lista;
    private final int COL_CLIENTE_N = 0;
    private final int COL_CLIENTE_C = 1;
    private final int COL_IMPRESSORAS = 2;
    private final int COL_TEMPO = 3;
    private final int COL_VALOR = 4;

    public TMCadLocacaoPJ(List<LocacaoPJ> lstLocacao) {
        lista = lstLocacao;
    }
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        LocacaoPJ locacao = new LocacaoPJ();
        if (lista.isEmpty()) {
            return locacao;
        } else {
            locacao = (LocacaoPJ) lista.get(rowIndex);

            switch (columnIndex) {
                case -1:
                    return locacao;
                case COL_CLIENTE_N:
                    return locacao.getCliente().getNome();
                case COL_CLIENTE_C:
                    return locacao.getCliente().getCNPJ();
                case COL_IMPRESSORAS:
                    return locacao.getImpressora();
                case COL_TEMPO:
                    return locacao.getTempo();
                case COL_VALOR:
                    return locacao.getValor();
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
            case COL_CLIENTE_N:
                return "Nome do cliente";
            case COL_CLIENTE_C:
                    return "CNPJ";
            case COL_IMPRESSORAS:
                return "Impressora";
            case COL_TEMPO:
                return "Tempo(em horas)";
            case COL_VALOR:
                return "Valor(R$)";
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
