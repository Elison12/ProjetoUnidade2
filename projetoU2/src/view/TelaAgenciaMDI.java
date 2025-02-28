/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author marcio
 */
public class TelaAgenciaMDI extends javax.swing.JFrame {

    /**
     * Creates new form TelaAgenciaMDI
     */
    public TelaAgenciaMDI() {
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

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        btnCriarBanco = new javax.swing.JButton();
        txtNomeBanco = new javax.swing.JTextField();
        txtCodBanco = new javax.swing.JTextField();
        lblNomeBanco = new javax.swing.JLabel();
        lblCodBanco = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuBanco = new javax.swing.JMenu();
        menuSair = new javax.swing.JMenuItem();
        menuAgencia = new javax.swing.JMenu();
        menuCriarAgencia = new javax.swing.JMenuItem();
        menuCliente = new javax.swing.JMenu();
        menuAddCliente = new javax.swing.JMenuItem();
        menuAddConta = new javax.swing.JMenuItem();
        menuSaque = new javax.swing.JMenuItem();
        menuDeposito = new javax.swing.JMenuItem();
        menuTransferencia = new javax.swing.JMenuItem();
        menuPIX = new javax.swing.JMenu();
        menuChavesPIX = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Banco Central");

        lblTitulo.setFont(new java.awt.Font("Open Sans ExtraBold", 0, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 0, 0));
        lblTitulo.setText("BANCO CENTRAL");

        btnCriarBanco.setText("CRIAR BANCO");
        btnCriarBanco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCriarBancoActionPerformed(evt);
            }
        });

        txtNomeBanco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeBancoActionPerformed(evt);
            }
        });

        lblNomeBanco.setText("Nome do Banco");

        lblCodBanco.setText("Código do Banco");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNomeBanco)
                    .addComponent(txtNomeBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCodBanco)
                    .addComponent(txtCodBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(lblTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCriarBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(lblTitulo)
                .addGap(91, 91, 91)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNomeBanco)
                    .addComponent(lblCodBanco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNomeBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(95, 95, 95)
                .addComponent(btnCriarBanco)
                .addGap(69, 69, 69))
        );

        jDesktopPane1.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        menuBanco.setText("Banco");

        menuSair.setText("Adicionar Banco");
        menuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSairActionPerformed(evt);
            }
        });
        menuBanco.add(menuSair);

        jMenuBar1.add(menuBanco);

        menuAgencia.setText("Agencias");

        menuCriarAgencia.setText("Adicionar Agencia");
        menuCriarAgencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCriarAgenciaActionPerformed(evt);
            }
        });
        menuAgencia.add(menuCriarAgencia);

        jMenuBar1.add(menuAgencia);

        menuCliente.setText("Area do Cliente");

        menuAddCliente.setText("Adicionar Cliente");
        menuAddCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAddClienteActionPerformed(evt);
            }
        });
        menuCliente.add(menuAddCliente);

        menuAddConta.setText("Adicionar Conta");
        menuAddConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAddContaActionPerformed(evt);
            }
        });
        menuCliente.add(menuAddConta);

        menuSaque.setText("Saque");
        menuSaque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSaqueActionPerformed(evt);
            }
        });
        menuCliente.add(menuSaque);

        menuDeposito.setText("Deposito");
        menuDeposito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDepositoActionPerformed(evt);
            }
        });
        menuCliente.add(menuDeposito);

        menuTransferencia.setText("Transferencia");
        menuTransferencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuTransferenciaActionPerformed(evt);
            }
        });
        menuCliente.add(menuTransferencia);

        jMenuBar1.add(menuCliente);

        menuPIX.setText("PIX");

        menuChavesPIX.setText("Chaves PIX");
        menuChavesPIX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuChavesPIXActionPerformed(evt);
            }
        });
        menuPIX.add(menuChavesPIX);

        jMenuBar1.add(menuPIX);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSairActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuSairActionPerformed

    private void menuAddClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAddClienteActionPerformed
        // TODO add your handling code here:
        TelaCadastroCliente telaCadClt = new TelaCadastroCliente();
        jDesktopPane1.add(telaCadClt);
        telaCadClt.setVisible(true);
    }//GEN-LAST:event_menuAddClienteActionPerformed

    private void menuSaqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSaqueActionPerformed
        // TODO add your handling code here:
        TelaSaque telaSaque = new TelaSaque();
        jDesktopPane1.add(telaSaque);
        telaSaque.setVisible(true);
    }//GEN-LAST:event_menuSaqueActionPerformed

    private void menuDepositoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDepositoActionPerformed
        // TODO add your handling code here:
        TelaDeposito telaDeposito = new TelaDeposito();
        jDesktopPane1.add(telaDeposito);
        telaDeposito.setVisible(true);
    }//GEN-LAST:event_menuDepositoActionPerformed

    private void menuTransferenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuTransferenciaActionPerformed
        // TODO add your handling code here:
        TelaTransferencia telaTransferencia = new TelaTransferencia();
        jDesktopPane1.add(telaTransferencia);
        telaTransferencia.setVisible(true);
    }//GEN-LAST:event_menuTransferenciaActionPerformed

    private void menuCriarAgenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCriarAgenciaActionPerformed
        // TODO add your handling code here:
        TelaCadastroAgencia telaCadAg = new TelaCadastroAgencia();
        jDesktopPane1.add(telaCadAg);
        telaCadAg.setVisible(true);
    }//GEN-LAST:event_menuCriarAgenciaActionPerformed

    private void menuAddContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAddContaActionPerformed
        // TODO add your handling code here:
        TelaCriarConta telaCriaConta = new TelaCriarConta();
        jDesktopPane1.add(telaCriaConta);
        telaCriaConta.setVisible(true);
    }//GEN-LAST:event_menuAddContaActionPerformed

    private void btnCriarBancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCriarBancoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCriarBancoActionPerformed

    private void txtNomeBancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeBancoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeBancoActionPerformed

    private void menuChavesPIXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuChavesPIXActionPerformed
        // TODO add your handling code here:
        TelaPIX telaPIX = new TelaPIX();
        jDesktopPane1.add(telaPIX);
        telaPIX.setVisible(true);
    }//GEN-LAST:event_menuChavesPIXActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaAgenciaMDI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaAgenciaMDI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaAgenciaMDI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaAgenciaMDI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaAgenciaMDI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCriarBanco;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCodBanco;
    private javax.swing.JLabel lblNomeBanco;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JMenuItem menuAddCliente;
    private javax.swing.JMenuItem menuAddConta;
    private javax.swing.JMenu menuAgencia;
    private javax.swing.JMenu menuBanco;
    private javax.swing.JMenuItem menuChavesPIX;
    private javax.swing.JMenu menuCliente;
    private javax.swing.JMenuItem menuCriarAgencia;
    private javax.swing.JMenuItem menuDeposito;
    private javax.swing.JMenu menuPIX;
    private javax.swing.JMenuItem menuSair;
    private javax.swing.JMenuItem menuSaque;
    private javax.swing.JMenuItem menuTransferencia;
    private javax.swing.JTextField txtCodBanco;
    private javax.swing.JTextField txtNomeBanco;
    // End of variables declaration//GEN-END:variables
}
