/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lps.sistemalocacaoimpressora.controller;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import lps.sistemalocacaoimpressora.model.Impressora;

public class TMCadImpressora extends AbstractTableModel {

    private List<Object> lista;
    private final int COL_NOME = 0;
    private final int COL_MARCA = 1;
    private final int COL_MODELO = 2;
    private final int COL_TIPO = 3;
    private final int COL_COLORIDA = 4;

    public TMCadImpressora(List<Object> lstImpressora) {
        lista = lstImpressora;
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
        Impressora impressora = new Impressora();
        if (lista.isEmpty()) {
            return impressora;
        } else {
            impressora = (Impressora) lista.get(rowIndex);

            //verifica qual valor deve ser retornado
            switch (columnIndex) {
                case -1:
                    return impressora;
                case COL_NOME:
                    return impressora.getNome();
                case COL_MARCA:
                    return impressora.getMarca();
                case COL_MODELO:
                    return impressora.getModelo();
                case COL_TIPO:
                    return impressora.getTipo();
                case COL_COLORIDA:
                    return impressora.isColorida();
                default:
                    break;
            }
        }
        return impressora;
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
            case COL_MARCA:
                return "Marca";
            case COL_MODELO:
                return "Modelo";
            case COL_TIPO:
                return "Tipo";
            case COL_COLORIDA:
                return "Colorida";
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
