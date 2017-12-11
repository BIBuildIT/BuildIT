
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lynn
 */
public class SiteCancelChoose extends javax.swing.JFrame {
    private static ArrayList<RentalRequest> cancelRequestAndRefuse = new ArrayList<>();
// in sql tabel zetten moet pas bij clerk daarom arraylist meegeven
    public static ArrayList<RentalRequest> getCancelRequestAndRefuse() {
        return cancelRequestAndRefuse;
    }

    public static void setCancelRequestAndRefuse(ArrayList<RentalRequest> cancelRequestAndRefuse) {
        SiteCancelChoose.cancelRequestAndRefuse = cancelRequestAndRefuse;
    }
    public String getReasonForCancellationTextField(){
        
        String reason =ReasonForCancellationTextField.getText();
        return reason;
    }
    
    private ArrayList<RentalRequest> requests;
 
    public SiteCancelChoose() throws DBException {
        initComponents();
        
        
        requests = Getters.getRentalRequests();
        
        DefaultListModel<String> model = new DefaultListModel<>();
        
        for(RentalRequest request : requests){
            
            model.addElement(Integer.toString(request.getRequestNumber()));//diegene die al op cancelled staan mogen hier niet in weergegeven worden!
            
        }
        
        requestList.setModel(model);
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cancel = new javax.swing.JButton();
        submit = new javax.swing.JButton();
        RentalRequestsToCancel = new javax.swing.JScrollPane();
        requestList = new javax.swing.JList<>();
        ReasonForCancellationTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        jLabel1.setText("Which rental request do you want to cancel?");

        jLabel2.setText("Rentalrequests to cancel:");

        cancel.setText("Cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        submit.setText("Submit");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });

        requestList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        RentalRequestsToCancel.setViewportView(requestList);

        ReasonForCancellationTextField.setText("Verfaillie ");
        ReasonForCancellationTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReasonForCancellationTextFieldActionPerformed(evt);
            }
        });

        jLabel3.setText("Reason for Cancellation:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cancel)
                        .addGap(120, 120, 120)
                        .addComponent(submit, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(RentalRequestsToCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(ReasonForCancellationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(127, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(RentalRequestsToCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)))
                .addComponent(ReasonForCancellationTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submit)
                    .addComponent(cancel))
                .addGap(30, 30, 30))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        this.setVisible(false);
        StartschermSiteEngineer.getStartSiteEngineer().setVisible(true);
    }//GEN-LAST:event_cancelActionPerformed

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        try {
            String selectedRequest= requestList.getSelectedValue();
            int selectedRequestNumber = Integer.valueOf(selectedRequest);
            RentalRequest req = RentalRequest.getRentalRequest(selectedRequestNumber);
            req.setRequestNumber(selectedRequestNumber);
            System.out.println("request number: "+req.getRequestNumber());
            //req.setCurrentStatus(RentalStatus.cancelled);
            String reason =ReasonForCancellationTextField.getText();
            req.setReasonForCancelationOrRefusal(reason);
            
            
            //System.out.println("de reden voor annulatie is: "+req.getReasonForCancelationOrRefusal());
            cancelRequestAndRefuse.add(req);
                    } catch (DBException ex) {
            Logger.getLogger(ClerkCancelRR.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        this.setVisible(false);
        new SiteCancelOK().setVisible(true);
    }//GEN-LAST:event_submitActionPerformed

    private void ReasonForCancellationTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReasonForCancellationTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ReasonForCancellationTextFieldActionPerformed

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
            java.util.logging.Logger.getLogger(SiteCancelChoose.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SiteCancelChoose.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SiteCancelChoose.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SiteCancelChoose.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new SiteCancelChoose().setVisible(true);
                } catch (DBException ex) {
                    Logger.getLogger(SiteCancelChoose.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ReasonForCancellationTextField;
    private javax.swing.JScrollPane RentalRequestsToCancel;
    private javax.swing.JButton cancel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> requestList;
    private javax.swing.JButton submit;
    // End of variables declaration//GEN-END:variables
}
