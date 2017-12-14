
import java.util.ArrayList;
import java.util.List;
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
 * @author lmoentje
 */
public class WorkAcceptAdjustRR extends javax.swing.JFrame {

    RentalRequest req = WorkAcceptGiveNumber.getRentalWork();
    
    private ArrayList<Equipment> types;
    private static String codesEq;

    public static String getCodesEq() {
        return codesEq;
    }
    
    
    
    /**
     * Creates new form WorkAcceptAdjustRR
     */
    public WorkAcceptAdjustRR() throws DBException {
        initComponents();
        
        address.setText(req.getConstructionSite());
        Employee e= Employee.getEmployee(req.getEmployeeID());
        Requestor.setText(" e-mail: " + e.getEmailAdress() + " phonenumber: " + e.getPhoneNumber());
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        EquipmentList = new javax.swing.JList<>();
        jLabel5 = new javax.swing.JLabel();
        descriptionRentalRequest = new javax.swing.JLabel();
        address = new javax.swing.JLabel();
        Requestor = new javax.swing.JLabel();
        submit = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        equipmentTypes = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Please choose alternative equipment");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Need equipment type(s):");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Requestor:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Constructionsite:");

        EquipmentList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(EquipmentList);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Description of the equipment");

        descriptionRentalRequest.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        descriptionRentalRequest.setText("jLabel6");

        address.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        address.setText("jLabel7");

        Requestor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Requestor.setText("jLabel7");

        submit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        submit.setText("Submit");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });

        cancel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cancel.setText("Cancel");

        equipmentTypes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        equipmentTypes.setText("jLabel6");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(descriptionRentalRequest)
                    .addComponent(jLabel5)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(41, 41, 41)
                        .addComponent(equipmentTypes))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Requestor)
                            .addComponent(address)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(cancel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(submit))
                        .addComponent(jLabel1)))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(equipmentTypes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(Requestor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(address))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(descriptionRentalRequest)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancel)
                    .addComponent(submit))
                .addGap(22, 22, 22))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
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
                    System.out.println("Error in WorkAcceptAdjustRR");
                    Startscherm.getB().setVisible(true);
                
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
            WorkAdjustApprovedSupplier sup = new WorkAdjustApprovedSupplier();
            sup.setVisible(true);
        } catch (DBException ex) {
            System.out.println("Error in WorkAcceptAdjustRR");
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
            java.util.logging.Logger.getLogger(WorkAcceptAdjustRR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WorkAcceptAdjustRR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WorkAcceptAdjustRR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WorkAcceptAdjustRR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new WorkAcceptAdjustRR().setVisible(true);
                } catch (DBException ex) {
                System.out.println("Error in WorkAcceptAdjustRR");
                Startscherm.getB().setVisible(true);}
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> EquipmentList;
    private javax.swing.JLabel Requestor;
    private javax.swing.JLabel address;
    private javax.swing.JButton cancel;
    private javax.swing.JLabel descriptionRentalRequest;
    private javax.swing.JLabel equipmentTypes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton submit;
    // End of variables declaration//GEN-END:variables
}
