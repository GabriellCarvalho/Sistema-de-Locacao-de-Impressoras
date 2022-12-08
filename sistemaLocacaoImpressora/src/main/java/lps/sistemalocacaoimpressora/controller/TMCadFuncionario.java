/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lps.sistemalocacaoimpressora.controller;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import lps.sistemalocacaoimpressora.model.Funcionario;

public class TMCadFuncionario extends AbstractTableModel {

    private List<Funcionario> lista;
    private final int COL_NOME = 0;
    private final int COL_IDADE = 1;
    private final int COL_SEXO = 2;
    private final int COL_CPF = 3;
    private final int COL_CARGO = 4;

    public TMCadFuncionario(List<Funcionario> lstFuncionario) {
        lista = lstFuncionario;
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
        Funcionario funcionario = new Funcionario();
        if (lista.isEmpty()) {
            return funcionario;
        } else {
            funcionario = (Funcionario) lista.get(rowIndex);

            switch (columnIndex) {
                case -1:
                    return funcionario;
                case COL_NOME:
                    return funcionario.getNome();
                case COL_IDADE:
                    return funcionario.getIdade();
                case COL_SEXO:
                    return funcionario.getSexo();
                case COL_CPF:
                    return funcionario.getCPF();
                case COL_CARGO:
                    return funcionario.getCargo();
                default:
                    break;
            }
        }
        return funcionario;
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
            case COL_CARGO:
                return "Cargo";
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
