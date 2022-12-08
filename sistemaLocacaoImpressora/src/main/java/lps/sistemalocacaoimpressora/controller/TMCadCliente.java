/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lps.sistemalocacaoimpressora.controller;

import javax.swing.table.AbstractTableModel;

import java.util.List;
import lps.sistemalocacaoimpressora.model.Cliente;

public class TMCadCliente extends AbstractTableModel {

    private List<Cliente> lista;
    private final int COL_NOME = 0;
    private final int COL_IDADE = 1;
    private final int COL_SEXO = 2;
    private final int COL_CPF = 3;
    private final int COL_EMAIL = 4;

    public TMCadCliente(List<Cliente> lstCliente) {
        lista = lstCliente;
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
        Cliente cliente = new Cliente();
        if (lista.isEmpty()) {
            return cliente;
        } else {
            cliente = (Cliente) lista.get(rowIndex);

            switch (columnIndex) {
                case -1:
                    return cliente;
                case COL_NOME:
                    return cliente.getNome();
                case COL_IDADE:
                    return cliente.getIdade();
                case COL_SEXO:
                    return cliente.getSexo();
                case COL_CPF:
                    return cliente.getCPF();
                case COL_EMAIL:
                    return cliente.getEmail();
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
            case COL_IDADE:
                return "Idade";
            case COL_SEXO:
                return "Sexo";
            case COL_CPF:
                return "CPF";
            case COL_EMAIL:
                return "Email";
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
