
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lmoentje
 */
public class SiteExtendGiveNumber extends javax.swing.JFrame {

    private ArrayList<RentalRequest> requests;
    private ArrayList<RentalRequest> requests2;
    private static RentalRequest rentalExtend;

    public static RentalRequest getRentalExtend() {
        return rentalExtend;
    }
    
    /**
     * Creates new form SiteExtendGiveNumber
     */
    public SiteExtendGiveNumber() throws DBException {
        initComponents();
        System.out.println("1");
        
        requests = Getters.getRentalRequests();
        
        DefaultListModel<String> model = new DefaultListModel<>();
        
        System.out.println("2");
        
        for(RentalRequest request : requests){
            System.out.println("3");
            System.out.println(request.getRequestNumber());
            RentalRequest req = RentalRequest.getRentalRequest(request.getRequestNumber());
            req.setRequestNumber(request.getRequestNumber());
            System.out.println(req.getRequestNumber());
            if(req.getCurrentStatus().toString().equals(RentalStatus.accepted.toString()))
                model.addElement(Integer.toString(req.getRequestNumber()));
        
        }
        if(model.isEmpty()){
            model.addElement("No rental requests are accepted.");
            
        }
        RequestList.setModel(model);
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
        cancel = new javax.swing.JButton();
        submit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        RequestList = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Please give the number of the rental request");

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

        RequestList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(RequestList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(cancel, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE))
                        .addGap(111, 111, 111)
                        .addComponent(submit, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancel)
                    .addComponent(submit))
                .addGap(67, 67, 67))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        this.setVisible(false);
        StartschermSiteEngineer.getStartSiteEngineer().setVisible(true);
    }//GEN-LAST:event_cancelActionPerformed

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        this.setVisible(false);
        String number= RequestList.getSelectedValue();
            int selectedRequestNumber = Integer.valueOf(number);
            RentalRequest req;
        try {
            req = RentalRequest.getRentalRequest(selectedRequestNumber);
            req.setRequestNumber(selectedRequestNumber);
            System.out.println(req.getRequestNumber());
            System.out.println(req.getCurrentStatus().toString());
            rentalExtend = req;
            SiteExtendNewDate ok = new SiteExtendNewDate();
            ok.setVisible(true);
            
            
        } catch (DBException ex) {
            //JOptionPane.showMessageDialog(null, "Sorry, there has been an error.");
            System.out.println("Error in submit SiteInspectGiveNumber.");
            Startscherm.getB().setVisible(true);
        }
        
    }//GEN-LAST:event_submitActionPerformed

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
            java.util.logging.Logger.getLogger(SiteExtendGiveNumber.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SiteExtendGiveNumber.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SiteExtendGiveNumber.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SiteExtendGiveNumber.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new SiteExtendGiveNumber().setVisible(true);
                } catch (DBException ex) {
                    Logger.getLogger(SiteExtendGiveNumber.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> RequestList;
    private javax.swing.JButton cancel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton submit;
    // End of variables declaration//GEN-END:variables

    private void JOptionPane(Object object, String no_rental_requests_are_accepted) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
