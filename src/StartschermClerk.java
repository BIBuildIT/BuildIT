/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lmoentje
 */
public class StartschermClerk extends javax.swing.JFrame {

    /**
     * Creates new form StartschermClerk
     */
    public StartschermClerk() {
        initComponents();
    }
    
    public static StartschermClerk startClerk = new StartschermClerk();

    public static StartschermClerk getStartClerk() {
        return startClerk;
    }

    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Cancel = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        showInvoice = new javax.swing.JButton();
        adjustReRe = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 255));
        jLabel1.setText("BuildIt");

        jLabel2.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        jLabel2.setText("Choose your task as clerk");

        Cancel.setText("Cancel");
        Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelActionPerformed(evt);
            }
        });

        jButton1.setText("Make Purchase Order");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        cancel.setText("Cancel rental request");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        showInvoice.setText("Show invoice");
        showInvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showInvoiceActionPerformed(evt);
            }
        });

        adjustReRe.setText("Adjust rental request");
        adjustReRe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adjustReReActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Cancel)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(showInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cancel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(adjustReRe)))
                .addContainerGap(181, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(26, 26, 26)
                .addComponent(cancel)
                .addGap(18, 18, 18)
                .addComponent(adjustReRe)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(showInvoice)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(Cancel)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelActionPerformed
        this.setVisible(false);
        Startscherm.getB().setVisible(true);
    }//GEN-LAST:event_CancelActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
        //EERST SCHERM ZETTEN MET "GIVE NUMBER RENTAL REQUEST:" 
        //DAARDOOR KAN HET NUMMER VAN DE PO VANZELF GEMAAKT WORDEN ZODAT HET HETZELFDE IS ALS DE RR
        //NA PURCHASE ORDER RENTAL STATUS "ORDERED" (de uitrusting en leverancier zijn geselecteerd)
        MakePurchaseOrder PO;
               //try {
                   PO = new MakePurchaseOrder(); 
                   PO.setVisible(true);
               //} 
               /*catch (DBException ex) {
                   Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
               }
               */
    }//GEN-LAST:event_jButton1ActionPerformed

    private void adjustReReActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adjustReReActionPerformed
        // GAAT NU DIRECT NAAR GUI "GIVENUMBERTOADJUSTRERE"
        //TOON AAN TE PASSEN RENTAL REQUEST
        // DRUK OP SUBMIT: RENTAL STATUS = "PROCESSED"
        //VERVOLGENS EEN SCHERM MET "APPROVED BY SUPPLIER?"
        //MET OPTIES NO(TERUG NAAR RENTAL REQUEST) EN YES(RENTAL STATUS = "READY FOR APPROVAL")
        
        this.setVisible(false);
        GiveNumberToAdjustReRe adj;
               //try {
                   adj = new GiveNumberToAdjustReRe(); 
                   adj.setVisible(true);
               //} 
               /*catch (DBException ex) {
                   Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
               }
               */
    }//GEN-LAST:event_adjustReReActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        this.setVisible(false);
        CancelRequest.getCancelReq().setVisible(true);
    }//GEN-LAST:event_cancelActionPerformed

    private void showInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showInvoiceActionPerformed
        // EERST VRAGEN NAAR NUMMER RR
        //INDIEN RENTAL STATUS submittedForPayment IS KAN MEN DOORGAAN NAAR DE INVOICE (IS AL AANGEMAAKT --> SHOWINVOICE)
        // INDIEN NIET: MELDING "NO INVOICE IS READY FOR THIS RENTAL REQUEST" (of iets in die aard)
        
        
        
        
        
    }//GEN-LAST:event_showInvoiceActionPerformed

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
            java.util.logging.Logger.getLogger(StartschermClerk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StartschermClerk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StartschermClerk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StartschermClerk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StartschermClerk().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cancel;
    private javax.swing.JButton adjustReRe;
    private javax.swing.JButton cancel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton showInvoice;
    // End of variables declaration//GEN-END:variables
}
