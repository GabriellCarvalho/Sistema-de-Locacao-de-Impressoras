/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package lps.sistemalocacaoimpressora.view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import lps.sistemalocacaoimpressora.controller.FuncionarioController;
import lps.sistemalocacaoimpressora.model.Funcionario;

public class FrMenu extends javax.swing.JFrame {

    JFrame telaAnterior;
    String cpf;
    String permicao;
    FuncionarioController funcionarioController;

    /**
     * Creates new form FrMenu
     */
    public FrMenu(JFrame telaQueChamou, String cpf) {
        funcionarioController = new FuncionarioController();
        this.cpf = cpf;
        this.permicao = "";
        this.telaAnterior = telaQueChamou;
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCadastroImpressora = new javax.swing.JButton();
        btnCadFuncionario = new javax.swing.JButton();
        btnCadUsuario = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnCadastroImpressora.setText("Cadastro de impressora");
        btnCadastroImpressora.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCadastroImpressora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastroImpressoraActionPerformed(evt);
            }
        });

        btnCadFuncionario.setText("Cadastro de Funcionario");
        btnCadFuncionario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCadFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadFuncionarioActionPerformed(evt);
            }
        });

        btnCadUsuario.setText("Cadastro de Cliente");
        btnCadUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCadUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadUsuarioActionPerformed(evt);
            }
        });

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnCadFuncionario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
            .addComponent(btnCadastroImpressora, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCadUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(189, 189, 189)
                .addComponent(btnSair)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCadastroImpressora, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCadFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCadUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(btnSair)
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastroImpressoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastroImpressoraActionPerformed
        // TODO add your handling code here:
        if (this.funcionarioController.buscarFuncionario(cpf).getCargo().equals("Administrador")) {
            FrCadastroImpressora telaCadastroImpressora = new FrCadastroImpressora(this);
            telaCadastroImpressora.setVisible(true);
            this.setVisible(false);
        } else {
            this.permicao = "Gerente";
            try {
                this.funcionarioController.checkAcesso(this.cpf, permicao);
                FrCadastroImpressora telaCadastroImpressora = new FrCadastroImpressora(this);
                telaCadastroImpressora.setVisible(true);
                this.setVisible(false);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnCadastroImpressoraActionPerformed

    private void btnCadFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadFuncionarioActionPerformed
        // TODO add your handling code here:
        if (this.funcionarioController.buscarFuncionario(cpf).getCargo().equals("Administrador")) {
            FrCadastroFuncionario telaCadFuncionario = new FrCadastroFuncionario(this);
            telaCadFuncionario.setVisible(true);
            this.setVisible(false);
        } else {
            this.permicao = "Gerente";
            try {
                this.funcionarioController.checkAcesso(this.cpf, permicao);
                FrCadastroFuncionario telaCadFuncionario = new FrCadastroFuncionario(this);
                telaCadFuncionario.setVisible(true);
                this.setVisible(false);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnCadFuncionarioActionPerformed

    private void btnCadUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadUsuarioActionPerformed
        // TODO add your handling code here:
        if (this.funcionarioController.buscarFuncionario(cpf).getCargo().equals("Administrador")) {
            FrCadastroCliente telaCadCliente = new FrCadastroCliente(this);
            telaCadCliente.setVisible(true);
            this.setVisible(false);
        } else {
            this.permicao = "Gerente";
            try {
                this.funcionarioController.checkAcesso(this.cpf, permicao);
                FrCadastroCliente telaCadCliente = new FrCadastroCliente(this);
                telaCadCliente.setVisible(true);
                this.setVisible(false);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnCadUsuarioActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        // TODO add your handling code here:
        this.telaAnterior.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnSairActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadFuncionario;
    private javax.swing.JButton btnCadUsuario;
    private javax.swing.JButton btnCadastroImpressora;
    private javax.swing.JButton btnSair;
    // End of variables declaration//GEN-END:variables
}
