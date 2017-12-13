
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import static java.util.concurrent.TimeUnit.DAYS;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;



public class ClerkPOMake extends javax.swing.JFrame {
     
    ArrayList<ConstructionSite> sites;
    ArrayList<Supplier> suppliers;
    public ClerkPOMake() throws DBException {
        initComponents();
        Employee e= Employee.getEmployee(ClerkPOGiveNumber.getRentalPO().getEmployeeID());
        telefoonSiteEngineer.setText(e.getPhoneNumber());
        
        // DefaultListModel<String> model = new DefaultListModel<>();
         // ConstructionSiteList.setModel((ComboBoxModel<String>) model);
        /*sites = ConstructionSite.getConstructionSites();
        
        for(ConstructionSite site : sites)
        {
            ConstructionSiteList.addItem(site.getAdress()); 
        }*/
        String employee = Integer.toString(ClerkPOGiveNumber.getRentalPO().getEmployeeID());
        requestor.setText(employee);
        System.out.println("1");
        ListSupplier.setText(suppliersPO.getSelectedSupplier());
        String ordernr = Integer.toString(ClerkPOGiveNumber.getRentalPO().getRequestNumber());
        orderNr.setText(ordernr);
        datum.setText(LocalDate.now().toString());
        rentalStart.setText(ClerkPOGiveNumber.getRentalPO().getRentalPeriodStart().toString());
        System.out.println("2");
        rentalEnd.setText(ClerkPOGiveNumber.getRentalPO().getRentalPeriodEnd().toString());
        construction.setText(ClerkPOGiveNumber.getRentalPO().getConstructionSite());
        System.out.println(ClerkPOGiveNumber.getRentalPO().getSelectedEquipment());
        
        String[] code = ClerkPOGiveNumber.getRentalPO().getSelectedEquipment().split(",");
        String a="";
        for(int i=0; i<code.length; i++){
            a=equipmentCodes.getText();
            a+=code[i];
            equipmentCodes.setText(a + ", \n");
        }
       
        String[] price = ClerkPOGiveNumber.getRentalPO().getDailyRentalPrice().split(",");
        String z;
        for(int i=0; i<code.length; i++){
            z=rentalPrice.getText();
            z+=code[i];
            rentalPrice.setText(z + ", \n");
        }
        
       
        
        
      
        
        /* KLOPT ONGEVEER --> KRIJGEN NULLPOINTEREXEPTION MAAR VOOR DE REST MOET DE CODE KLOPPEN
        int bedragDagelijks = 0;
        if(ClerkPOGiveNumber.getRentalPO().getDailyRentalPrice().indexOf(",")>=0)
        {
        String[] daily= ClerkPOGiveNumber.getRentalPO().getDailyRentalPrice().split(",");
        ArrayList<String> dailyRP = new ArrayList<>();
        
        for( int i =0; i < daily.length; i++){
            String a = daily[i];
            dailyRP.add(a);
        }
        
        for(String i : dailyRP){
            int a = Integer.parseInt(i);
            bedragDagelijks += a;
            
        }
        String bd = Integer.toString(bedragDagelijks);
        System.out.println(bedragDagelijks);
       //ClerkPOGiveNumber.getRentalPO().getSelectedEquipment()
        rentalPrice.setText(bd);
        
        }
       else
        {
            String bd = ClerkPOGiveNumber.getRentalPO().getDailyRentalPrice();
            rentalPrice.setText(bd);
        }
        */
      
      Period diff=  ClerkPOGiveNumber.getRentalPO().getRentalPeriodStart().until(ClerkPOGiveNumber.getRentalPO().getRentalPeriodEnd());
      int days = diff.getDays();
      String z = Integer.toString(days);
      daysRented.setText(z);
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
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        datum = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        submit = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        idClerk = new javax.swing.JTextField();
        requestor = new javax.swing.JLabel();
        orderNr = new javax.swing.JLabel();
        construction = new javax.swing.JLabel();
        telefoonSiteEngineer = new javax.swing.JLabel();
        rentalPrice = new javax.swing.JLabel();
        rentalStart = new javax.swing.JLabel();
        rentalEnd = new javax.swing.JLabel();
        equipmentCodes = new javax.swing.JLabel();
        ListSupplier = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        daysRented = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 255, 153));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Purchase Order");

        cancel.setText("Cancel");
        cancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelMouseClicked(evt);
            }
        });
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Order nr");

        jLabel4.setText("Date");

        datum.setText("datum");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Supplier");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Rental request requested by:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Construction site");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Strart rental period");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("End rental period");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Phone site engineer");

        submit.setText("Submit");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Daily rental price(s):");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Total price");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("(zelf uitrekenen?)");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Employee ID of clerk:");

        idClerk.setText("jTextField4");

        requestor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        requestor.setText("jLabel19");

        orderNr.setText("jLabel19");

        construction.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        construction.setText("jLabel19");

        telefoonSiteEngineer.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        telefoonSiteEngineer.setText("jLabel3");

        rentalPrice.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rentalPrice.setText("jLabel3");

        rentalStart.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rentalStart.setText("jLabel3");

        rentalEnd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rentalEnd.setText("jLabel3");

        equipmentCodes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        equipmentCodes.setText("lol");

        ListSupplier.setText("jLabel3");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Code(s) of equipment:");

        jLabel11.setText("Total amount of days:");

        daysRented.setText("jLabel12");

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel3))
                                .addGap(67, 67, 67)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(telefoonSiteEngineer)
                                    .addComponent(requestor)
                                    .addComponent(construction, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ListSupplier)
                                    .addComponent(rentalEnd)
                                    .addComponent(rentalStart)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(103, 103, 103)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(daysRented)
                                            .addComponent(jLabel11)))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(equipmentCodes, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(idClerk, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(rentalPrice)
                                        .addComponent(jLabel15))))
                            .addComponent(cancel))
                        .addGap(325, 325, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(submit)
                                .addGap(21, 21, 21))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2))
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(datum)
                                    .addComponent(orderNr))
                                .addContainerGap())))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel13)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel5)
                            .addComponent(jLabel10)
                            .addComponent(jLabel16))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(requestor))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(telefoonSiteEngineer))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel10)
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(ListSupplier)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(orderNr))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(datum)
                            .addComponent(jLabel4))))
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(construction))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(equipmentCodes, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(rentalPrice))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(rentalStart, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(rentalEnd)
                    .addComponent(daysRented))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(idClerk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancel)
                    .addComponent(submit))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelActionPerformed

    private void cancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseClicked
        this.setVisible(false);
        Startscherm.getB().setVisible(true);
    }//GEN-LAST:event_cancelMouseClicked

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        // RENTAL STATUS "ORDERED"
        this.setVisible(false);
        int clerkID = Integer.parseInt(idClerk.getText().trim());
        ClerkPOGiveNumber.getRentalPO().setCurrentStatus(RentalStatus.ordered);
        try {
            
            Employee e= Employee.getEmployee(ClerkPOGiveNumber.getRentalPO().getEmployeeID());
            ConstructionSite adres = new ConstructionSite(ClerkPOGiveNumber.getRentalPO().getConstructionSite());
            String telNR = e.getPhoneNumber();
            RentalRequest.saveRR(ClerkPOGiveNumber.getRentalPO());
            //probleem met local date en gewone date
            //PurchaseOrder p = new PurchaseOrder(ClerkPOGiveNumber.getRentalPO().getRequestNumber(), Date.valueOf(LocalDate.now()), clerkID,ClerkPOGiveNumber.getRentalPO().getSelectedSupplier(), ERROR, 0, ClerkPOGiveNumber.getRentalPO().getRentalPeriodStart(), ClerkPOGiveNumber.getRentalPO().getRentalPeriodEnd(), 0, adres, telNR, 0,ClerkPOGiveNumber.getRentalPO().getSelectedSupplier() , ClerkPOGiveNumber.getRentalPO().getEmployeeID());
        } catch (DBException ex) {
            Logger.getLogger(ClerkPOMake.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "Purchase order "+ClerkPOGiveNumber.getRentalPO().getRequestNumber()+" is made.");
        
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
            java.util.logging.Logger.getLogger(ClerkPOMake.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClerkPOMake.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClerkPOMake.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClerkPOMake.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ClerkPOMake().setVisible(true);
                } catch (DBException ex) {
                    Logger.getLogger(ClerkPOMake.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ListSupplier;
    private javax.swing.JButton cancel;
    private javax.swing.JLabel construction;
    private javax.swing.JLabel datum;
    private javax.swing.JLabel daysRented;
    private javax.swing.JLabel equipmentCodes;
    private javax.swing.JTextField idClerk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel orderNr;
    private javax.swing.JLabel rentalEnd;
    private javax.swing.JLabel rentalPrice;
    private javax.swing.JLabel rentalStart;
    private javax.swing.JLabel requestor;
    private javax.swing.JButton submit;
    private javax.swing.JLabel telefoonSiteEngineer;
    // End of variables declaration//GEN-END:variables
 
}
