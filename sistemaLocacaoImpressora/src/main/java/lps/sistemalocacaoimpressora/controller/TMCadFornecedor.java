/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lps.sistemalocacaoimpressora.controller;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import lps.sistemalocacaoimpressora.model.Fornecedor;

public class TMCadFornecedor extends AbstractTableModel {

    private List<Fornecedor> lista;
    private final int COL_NOME = 0;
    private final int COL_CNPJ = 1;
    private final int COL_PECAS = 2;
    private final int COL_CARTUCHO = 3;

    public TMCadFornecedor(List<Fornecedor> lstFornecedor) {
        lista = lstFornecedor;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Fornecedor fornecedor = new Fornecedor();
        if (lista.isEmpty()) {
            return fornecedor;
        } else {
            fornecedor = (Fornecedor) lista.get(rowIndex);

            switch (columnIndex) {
                case -1:
                    return fornecedor;
                case COL_NOME:
                    return fornecedor.getNome();
                case COL_CNPJ:
                    return fornecedor.getCnpj();
                case COL_PECAS:
                    return fornecedor.getPecas();
                case COL_CARTUCHO:
                    return fornecedor.getCartucho();
                default:
                    break;
            }
        }
        return fornecedor;
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
            case COL_CNPJ:
                return "CNPJ";
            case COL_PECAS:
                return "Peças";
            case COL_CARTUCHO:
                return "Cartucho";
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
