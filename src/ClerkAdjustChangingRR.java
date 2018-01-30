
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jhooster
 */
public class ClerkAdjustChangingRR extends javax.swing.JFrame implements ListSelectionListener {
//wat doet deze gui?
    private RentalRequest req = ClerkAdjustGiveNumber.getRentalAdjust();
    private ArrayList<Equipment> types;
    private static String codesEq;

    public static String getCodesEq() {
        return codesEq;
    }
    
    
    /**
     * Creates new form ChangingRentalRequestForm
     */
    public ClerkAdjustChangingRR() throws DBException {
        initComponents();
        
        address.setText(req.getConstructionSite());
        
        Employee e= Employee.getEmployee(req.getEmployeeID());
        Requestor.setText(" e-mail: " + e.getEmailaddress() + "   &    Phone number: " + e.getPhoneNumber());
        
        
        
        String[] eqType=req.getEquipmentType().split(",");
        descriptionRentalRequest.setText(eqType[eqType.length-1]);
        types = Equipment.getEquipments(); 
        
        DefaultListModel<String> model = new DefaultListModel<>();
        
        for(Equipment type : types){
            for(int i=0; i<eqType.length-1;i++){
                if(type.getType().equals(eqType[i])){
                    model.addElement(type.getCode()+","+"   Type: "+type.getType()+"   Description: "+type.getDescription()+"   Supplier: "+type.getSupplier()+"   Price: "+type.getPrice());
                }
            }
            
        }
        String equipmentType = eqType[0];
        for(int i=1; i<eqType.length-1;i++){
                equipmentType = equipmentType+", "+eqType[i];
            }
        equipmentTypes.setText(equipmentType);
        
        
        EquipmentList.setModel(model);
      
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Cancel = new javax.swing.JButton();
        Submit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        EquipmentList = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        address = new javax.swing.JLabel();
        Requestor = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        descriptionRentalRequest = new javax.swing.JLabel();
        equipmentTypes = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Choose the equipment for the rental request");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Need equipment type(s):");

        Cancel.setText("Cancel");
        Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelActionPerformed(evt);
            }
        });

        Submit.setText("Submit");
        Submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitActionPerformed(evt);
            }
        });

        EquipmentList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(EquipmentList);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Construction Site:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Requested by:");

        address.setText("site");

        Requestor.setText("site engineer");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Description of the rental request: ");

        descriptionRentalRequest.setText("discription");

        equipmentTypes.setText("types");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(Cancel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Submit))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(descriptionRentalRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(32, 32, 32)
                        .addComponent(equipmentTypes))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Requestor)
                            .addComponent(address))))
                .addContainerGap(208, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(equipmentTypes))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(address))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(Requestor))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(descriptionRentalRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cancel)
                    .addComponent(Submit))
                .addGap(24, 24, 24))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelActionPerformed
        this.dispose();
        StartschermClerk.getStartClerk().setVisible(true);
        
    }//GEN-LAST:event_CancelActionPerformed

    private void SubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitActionPerformed

       
        try {
           
            List<String> selectedEquipment = EquipmentList.getSelectedValuesList();
            
            ArrayList<String> codeEquipments= new ArrayList<>();
            for(int i=0;i<selectedEquipment.size(); i++){
                String[] selectedEquipmentSplit=selectedEquipment.get(i).split(",");
                codeEquipments.add(selectedEquipmentSplit[0].trim());
                
            }
            for(String e:codeEquipments){
                System.out.println(e);
            }
            
            String coEq=String.join(",", codeEquipments);
            codesEq = coEq;
            ArrayList<String> supplierEquipment= new ArrayList<>();
            ArrayList<String> priceEquipment= new ArrayList<>();
            for(int i=0; i <codeEquipments.size(); i++){
                try {
                    Equipment eq = Equipment.getEquipment(Integer.parseInt(codeEquipments.get(i)));
                    supplierEquipment.add(eq.getSupplier());
                    String equi = Double.toString(eq.getPrice());
                    priceEquipment.add(equi);
                } catch (DBException ex) {
                System.out.println("Error in ClerkAdjustChangingRR");
                }
                
                
                
            }
            String suEq=String.join(",", supplierEquipment);
            String prEq=String.join(",", priceEquipment);
            req.setSelectedEquipment(coEq);
            req.setSelectedSupplier(suEq);
            req.setDailyRentalPrice(prEq);
            req.setCurrentStatus(RentalStatus.processed);
            
            RentalRequest.saveRR(req);
            
            this.setVisible(false);
            
            
            ClerkAdjustApprovedSupplier sup = new ClerkAdjustApprovedSupplier();
            sup.setVisible(true);
            //Event e = new Event(ClerkAdjustGiveNumber.getRentalAdjust().getRequestNumber(), ClerkAdjustGiveNumber.getRentalAdjust().getCurrentStatus(), ClerkAdjustGiveNumber.getRentalAdjust().getEmployeeID(), "SUBMIT");
        /*try {
            Event.saveEvent(e);
        } catch (DBException ex) {
            System.out.println("Error in ClerkAdjustChangingRR");
            Startscherm.getB().setVisible(true);
        }
        */
        
        } catch (DBException ex) {
            System.out.println("Error in ClerkAdjustChangingRR");
            Startscherm.getB().setVisible(true);
        }
    }//GEN-LAST:event_SubmitActionPerformed

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
            java.util.logging.Logger.getLogger(ClerkAdjustChangingRR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClerkAdjustChangingRR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClerkAdjustChangingRR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClerkAdjustChangingRR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ClerkAdjustChangingRR().setVisible(true);
                } catch (DBException ex) {
                    System.out.println("Error in ClerkAdjustChangingRR");
                    Startscherm.getB().setVisible(true);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cancel;
    private javax.swing.JList<String> EquipmentList;
    private javax.swing.JLabel Requestor;
    private javax.swing.JButton Submit;
    private javax.swing.JLabel address;
    private javax.swing.JLabel descriptionRentalRequest;
    private javax.swing.JLabel equipmentTypes;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void valueChanged(ListSelectionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 
}
