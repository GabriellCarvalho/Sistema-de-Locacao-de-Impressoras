/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package lps.sistemalocacaoimpressora.view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import lps.sistemalocacaoimpressora.controller.ClienteController;
import lps.sistemalocacaoimpressora.controller.ImpressoraController;
import lps.sistemalocacaoimpressora.controller.LocacaoController;
import lps.sistemalocacaoimpressora.model.Cliente;
import lps.sistemalocacaoimpressora.model.Impressora;
import lps.sistemalocacaoimpressora.model.Locacao;

public class FrAlugar extends javax.swing.JFrame {

    JFrame telaAnterior;
    LocacaoController locacaoController;
    ImpressoraController impressoraController;
    ClienteController clienteController;
    Impressora impressora;
    Cliente cliente;

    /**
     * Creates new form FrAlugar
     */
    public FrAlugar(JFrame telaQueChamou) {
        this.telaAnterior = telaQueChamou;
        locacaoController = new LocacaoController();
        impressoraController = new ImpressoraController();
        clienteController = new ClienteController();
        initComponents();

        locacaoController.atualizarTabelaLocacao(grdAlugar);
        impressoraController.atualizarTabela(grdImpressora);
        clienteController.atualizarTabela(grdCliente);
    }

    private Object getObjetoSelecionadoNaGrid() {
        int rowCliked = grdAlugar.getSelectedRow();
        Object obj = null;
        if (rowCliked >= 0) {
            obj = grdAlugar.getModel().getValueAt(rowCliked, -1);
        }
        return obj;
    }

    private Object getObjetoSelecionadoNaGrid1() {
        int rowCliked = grdImpressora.getSelectedRow();
        Object obj = null;
        if (rowCliked >= 0) {
            obj = grdImpressora.getModel().getValueAt(rowCliked, -1);
        }
        return obj;
    }

    private Object getObjetoSelecionadoNaGrid3() {
        int rowCliked = grdCliente.getSelectedRow();
        Object obj = null;
        if (rowCliked >= 0) {
            obj = grdCliente.getModel().getValueAt(rowCliked, -1);
        }
        return obj;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        btnAlugar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        grdAlugar = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        grdImpressora = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        grdCliente = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Alugar Impressora");

        btnAlugar.setText("Alugar");
        btnAlugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlugarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        grdAlugar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(grdAlugar);

        grdImpressora.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(grdImpressora);

        grdCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(grdCliente);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(btnAlugar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 146, Short.MAX_VALUE)
                        .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAlugar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAlugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlugarActionPerformed
        // TODO add your handling code here:
        impressora = (Impressora) this.getObjetoSelecionadoNaGrid1();
        cliente = (Cliente) this.getObjetoSelecionadoNaGrid3();
        try {
            locacaoController.alugarImpressora(cliente, impressora);
            locacaoController.atualizarTabelaLocacao(grdAlugar);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnAlugarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:
        Locacao locacaoExcluido = (Locacao) this.getObjetoSelecionadoNaGrid();
        if (locacaoExcluido == null) {
            JOptionPane.showMessageDialog(this, "Primeiro selecione um registro na tabela.");
        } else {
            int response = JOptionPane.showConfirmDialog(null,
                    "Deseja exlcuir a locacao do cliente \n("
                    + locacaoExcluido.getCliente().getNome() + ", "
                    + locacaoExcluido.getCliente().getCPF() + ") ?",
                    "Confirmar exclusão",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.OK_OPTION) {
                try {
                    locacaoController.excluirLocacao(locacaoExcluido);
                    locacaoController.atualizarTabelaLocacao(grdAlugar);
                    JOptionPane.showMessageDialog(this, "Exclusão feita com sucesso!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage());
                }
            }
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        // TODO add your handling code here:
        this.telaAnterior.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnVoltarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlugar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JTable grdAlugar;
    private javax.swing.JTable grdCliente;
    private javax.swing.JTable grdImpressora;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables
}
