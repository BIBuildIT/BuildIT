
//import java.sql.Date;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger; 
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;



/**
 *we nemen gewone buttons ipv een buttongroup 
 * omdat een equipment voor meerdere constructionsites kan gebruikt worden
 * zie ER schema
 */
public class RentalRequestForm extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    
    private ArrayList<ConstructionSite> sites;
    private ArrayList<Equipment> types;
   
      public RentalRequestForm() throws DBException{
        initComponents();
        
        types = Equipment.getEquipments(); 
        
        DefaultListModel<String> model = new DefaultListModel<>();
        
        for(Equipment type : types){
            if(!model.contains(type.getType())){
             model.addElement(type.getType());
            }
        }
        
        EquipmentList.setModel(model);
        
        sites = ConstructionSite.getConstructionSites();
       
        for(ConstructionSite site : sites){
            ConstructionSiteList.add(site.getaddress());
        }
    }
    
    
 
  
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
            java.util.logging.Logger.getLogger(RentalRequestForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RentalRequestForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RentalRequestForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RentalRequestForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
    }
  
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Titel = new javax.swing.JLabel();
        giveEmployeeID = new javax.swing.JLabel();
        employeeID = new javax.swing.JTextField();
        giveConstructionSite = new javax.swing.JLabel();
        giveStartRentalPeriod = new javax.swing.JLabel();
        startRentalPeriod = new javax.swing.JTextField();
        giveEndofRentalPeriod = new javax.swing.JLabel();
        endRentalPeriod = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        EquipmentList = new javax.swing.JList<>();
        ConstructionSiteList = new java.awt.Choice();
        SubmitButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cancel = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        DescriptionEquipment = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Titel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Titel.setText("Rentalrequest");

        giveEmployeeID.setText("EmployeeID:");

        employeeID.setText(" ");
        employeeID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeIDActionPerformed(evt);
            }
        });

        giveConstructionSite.setText("ConstructionSite:");

        giveStartRentalPeriod.setText("Start of rental period:");

        startRentalPeriod.setText("yyyy-mm-dd");
        startRentalPeriod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startRentalPeriodActionPerformed(evt);
            }
        });

        giveEndofRentalPeriod.setText("End of rental period:");

        endRentalPeriod.setText("yyy-mm-dd");
        endRentalPeriod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endRentalPeriodActionPerformed(evt);
            }
        });

        EquipmentList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(EquipmentList);

        SubmitButton.setText("Submit");
        SubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Type Equipment ");

        cancel.setText("Cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        jLabel2.setText("More information about equipment (don't use any comma's please):");

        DescriptionEquipment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DescriptionEquipmentActionPerformed(evt);
            }
        });

        jLabel3.setText("For multiple items hold control while selecting.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(employeeID, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ConstructionSiteList, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1)
                                .addComponent(jLabel3)))
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(SubmitButton)
                                .addComponent(DescriptionEquipment, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cancel)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(giveStartRentalPeriod)
                                    .addComponent(giveEndofRentalPeriod))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(startRentalPeriod, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                                    .addComponent(endRentalPeriod)))
                            .addComponent(Titel)
                            .addComponent(giveEmployeeID)
                            .addComponent(giveConstructionSite))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Titel)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(giveEmployeeID)
                    .addComponent(employeeID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(giveConstructionSite)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ConstructionSiteList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jLabel1)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(DescriptionEquipment)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(giveStartRentalPeriod)
                    .addComponent(startRentalPeriod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(giveEndofRentalPeriod)
                    .addComponent(endRentalPeriod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SubmitButton)
                    .addComponent(cancel))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void employeeIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_employeeIDActionPerformed

    private void SubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitButtonActionPerformed
        try {
            
            List<String> selectedEquipment = EquipmentList.getSelectedValuesList();
            String selectedEquipmentString =  String.join(",",selectedEquipment);
            String description =DescriptionEquipment.getText();
            selectedEquipmentString +="," +description;
            String selectedCS = ConstructionSiteList.getSelectedItem();
            
            RentalRequest req = new RentalRequest(getStartRentalRequest(), getEndRentalRequest(), getEmployeeID(), selectedCS, selectedEquipmentString); 
            JOptionPane.showMessageDialog(null, "U chose " + selectedEquipmentString + " for constructionsite "+ selectedCS + ". \n"
            + "On this date you made a request (number "+ req.getRequestNumber()+" ) : "+(req.getRequestDate().toString())+".");
           RentalRequest.saveRR(req);
           RentalRequest reRe=RentalRequest.getRentalRequest(req.getRequestNumber());
           
           
           //Event e = new Event(reRe.getRequestNumber(), reRe.getCurrentStatus(), reRe.getEmployeeID(), "CHOOSE: SUBMIT");
            //System.out.println(e.getTime().toString());
           //Event.saveEvent(e);
        } 
        catch (ParseException ex) 
        {
            System.out.println("Error in RentalRequestForm");
            Startscherm.getB().setVisible(true);
        } 
        catch (DBException ex) 
        {
            System.out.println("Error in RentalRequestForm");
            Startscherm.getB().setVisible(true);
        }
           this.dispose();
           Startscherm.getB().setVisible(true);
        
    }//GEN-LAST:event_SubmitButtonActionPerformed

    private void startRentalPeriodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startRentalPeriodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_startRentalPeriodActionPerformed

    private void endRentalPeriodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endRentalPeriodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_endRentalPeriodActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        this.dispose();
        StartschermSiteEngineer.getStartSiteEngineer().setVisible(true);
    }//GEN-LAST:event_cancelActionPerformed

    private void DescriptionEquipmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DescriptionEquipmentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DescriptionEquipmentActionPerformed
 
    
   
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Choice ConstructionSiteList;
    private javax.swing.JTextField DescriptionEquipment;
    private javax.swing.JList<String> EquipmentList;
    private javax.swing.JButton SubmitButton;
    private javax.swing.JLabel Titel;
    private javax.swing.JButton cancel;
    private javax.swing.JTextField employeeID;
    private javax.swing.JTextField endRentalPeriod;
    private javax.swing.JLabel giveConstructionSite;
    private javax.swing.JLabel giveEmployeeID;
    private javax.swing.JLabel giveEndofRentalPeriod;
    private javax.swing.JLabel giveStartRentalPeriod;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField startRentalPeriod;
    // End of variables declaration//GEN-END:variables

    
   

 public int getEmployeeID()
    {
        return (Integer.parseInt(employeeID.getText().trim()));
    }

 public LocalDate getStartRentalRequest() throws ParseException
    {
     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
   LocalDate date = LocalDate.parse(startRentalPeriod.getText(), formatter);
    return date;
    }
 public LocalDate getEndRentalRequest() throws ParseException
    {
     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDate date = LocalDate.parse(endRentalPeriod.getText(), formatter);

    return date;
    }

}