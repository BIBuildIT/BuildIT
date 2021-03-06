
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import static java.util.concurrent.TimeUnit.DAYS;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;



public class ClerkPOMake extends javax.swing.JFrame {
     
    ArrayList<ConstructionSite> sites;
    ArrayList<Supplier> suppliers;
    double totPrice;
    private static double totalePrijs;
    private int teller;
    
    private static String endDatum;
    

    public static double getTotalePrijs() {
        return totalePrijs;
    }

    public static String getEndDatum() {
        return endDatum;
    }

    
    
    
    
    public ClerkPOMake() throws DBException {
        initComponents();
        Employee e= Employee.getEmployee(ClerkPOGiveNumber.getRentalPO().getEmployeeID());
        telefoonSiteEngineer.setText(e.getPhoneNumber());
        
        String employee = Integer.toString(ClerkPOGiveNumber.getRentalPO().getEmployeeID());
        requestor.setText(employee);
        emailAddress.setText(e.getEmailaddress());
        ListSupplier.setText(ClerkPOSuppliers.getSelectedSupplier());
        String ordernr = Integer.toString(ClerkPOGiveNumber.getRentalPO().getRequestNumber());
        orderNr.setText(ordernr);
        datum.setText(LocalDate.now().toString());
        rentalStart.setText(ClerkPOGiveNumber.getRentalPO().getRentalPeriodStart().toString());
        rentalEnd.setText(ClerkPOGiveNumber.getRentalPO().getRentalPeriodEnd().toString());
        
        endDatum = rentalEnd.getText();
        
        construction.setText(ClerkPOGiveNumber.getRentalPO().getConstructionSite());
        
        
        
        String[] code = ClerkPOGiveNumber.getRentalPO().getSelectedEquipment().split(",");
        String a= code[0];
        for(int i=1; i<code.length; i++){
            if(Equipment.getEquipment(Integer.parseInt(code[i])).getSupplier().equals(ClerkPOSuppliers.getSelectedSupplier())){
            a=equipmentCodes.getText();
            a+=", "+code[i];
            equipmentCodes.setText(a);
        }
        }
        String[] price = ClerkPOGiveNumber.getRentalPO().getDailyRentalPrice().split(",");
        String z = price[0];
        for(int i=1; i<price.length; i++){
             if(Equipment.getEquipment(Integer.parseInt(code[i])).getSupplier().equals(ClerkPOSuppliers.getSelectedSupplier())){
            z=rentalPrice.getText();
            z+=", "+price[i];
            rentalPrice.setText(z + "\n");
        }
        }
        /*
        Period diff=  ClerkPOGiveNumber.getRentalPO().getRentalPeriodStart().until(ClerkPOGiveNumber.getRentalPO().getRentalPeriodEnd());
        int days = diff.getDays();
        String y = Integer.toString(days);
        daysRented.setText(y);
        */
        
        /*SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-mm-dd");
        String inputString1 = ClerkPOGiveNumber.getRentalPO().getRentalPeriodStart().toString();
        String inputString2 = ClerkPOGiveNumber.getRentalPO().getRentalPeriodEnd().toString();

        
        
        
        
        try {
            java.util.Date date1 = myFormat.parse(inputString1);
            Date date2 = (Date) myFormat.parse(inputString2);
            
            long diff = date2.getTime() - date1.getTime();
            String y = Integer.toString((int) diff);
            daysRented.setText(y);
            
            
            double totalDailyPrice=0.00;
        for(int i=0; i<price.length;i++){
        totalDailyPrice+=Double.parseDouble(price[i]);
    }
        double daysdouble = (double) diff;
         totPrice= totalDailyPrice*daysdouble;
        
        totalePrijs = totPrice; 
        totalPrice.setText(Double.toString(totPrice));
            
        } catch (ParseException ex) {
            Logger.getLogger(ClerkPOMake.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
        
        //System.out.println ("Days: " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));

        LocalDate end = ClerkPOGiveNumber.getRentalPO().getRentalPeriodEnd();
        LocalDate start = ClerkPOGiveNumber.getRentalPO().getRentalPeriodStart();
        Period period = Period.between ( start , end );
        
        Integer monthsElapsed = period.getMonths();
        Integer yearsElapsed = period.getYears();
        Integer daysElapsed = period.getDays();
        
        int totalDays = 0;
        
        for(int i = 0; i<13; i++){
            if (i == monthsElapsed)
                totalDays += i*30;
            
        }
        
        for(int i = 0; i<100; i++){
            if (i == yearsElapsed)
                totalDays += i*365;
            
        } totalDays += daysElapsed;
        
        String y = Integer.toString(totalDays);
            daysRented.setText(y);
        
        double totalDailyPrice=0.00;
        for(int i=0; i<price.length;i++){
        totalDailyPrice+=Double.parseDouble(price[i]);
    }
        double daysdouble = (double) totalDays;
         totPrice= totalDailyPrice*daysdouble;
        
        totalePrijs = totPrice; 
        totalPrice.setText(Double.toString(totPrice));
        
        
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
        totalPrice = new javax.swing.JLabel();
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
        jLabel12 = new javax.swing.JLabel();
        emailAddress = new javax.swing.JLabel();

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
        jLabel8.setText("Start rental period");

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

        totalPrice.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        totalPrice.setText("total price");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Employee ID of clerk:");

        idClerk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idClerkActionPerformed(evt);
            }
        });

        requestor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        requestor.setText("jLabel19");

        orderNr.setText("jLabel19");

        construction.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        construction.setText("construction site");

        telefoonSiteEngineer.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        telefoonSiteEngineer.setText("phone");

        rentalPrice.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        rentalStart.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rentalStart.setText("jLabel3");

        rentalEnd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rentalEnd.setText("jLabel3");

        equipmentCodes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        equipmentCodes.setText(" ");

        ListSupplier.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ListSupplier.setText("supplier");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Code(s) of equipment:");

        jLabel11.setText("Total amount of days:");

        daysRented.setText("jLabel12");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("EmployeeID:");

        emailAddress.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        emailAddress.setText("email");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3))
                        .addGap(109, 109, 109)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(construction, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(14, 14, 14))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(emailAddress)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addComponent(requestor))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(idClerk, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(totalPrice)
                                    .addComponent(ListSupplier)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rentalEnd)
                                        .addGap(175, 175, 175)
                                        .addComponent(daysRented))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(equipmentCodes, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(rentalPrice, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(telefoonSiteEngineer)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rentalStart)
                                        .addGap(175, 175, 175)
                                        .addComponent(jLabel11)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(cancel)
                    .addComponent(jLabel16)
                    .addComponent(jLabel14)
                    .addComponent(jLabel13)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel5)
                    .addComponent(jLabel10))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(223, 223, 223)
                        .addComponent(submit)
                        .addGap(0, 62, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(orderNr)
                            .addComponent(datum))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(idClerk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(requestor)
                            .addComponent(jLabel7)
                            .addComponent(jLabel12)
                            .addComponent(emailAddress))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(telefoonSiteEngineer))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(ListSupplier)))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(rentalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(totalPrice))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(rentalStart, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(rentalEnd)
                    .addComponent(daysRented))
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancel)
                    .addComponent(submit))
                .addGap(35, 35, 35))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelActionPerformed

    private void cancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseClicked
        this.dispose();
        Startscherm.getB().setVisible(true);
    }//GEN-LAST:event_cancelMouseClicked

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        // RENTAL STATUS "ORDERED"
        this.dispose();
        int clerkID = Integer.parseInt(idClerk.getText().trim());
        
        try {
            RentalRequest reRe= ClerkPOGiveNumber.getRentalPO();
            teller+=1;
            if(ClerkPOSuppliers.getNumberOfSuppliers() == teller){
                reRe.setCurrentStatus(RentalStatus.ordered);
                //Event e = new Event(reRe.getRequestNumber(),reRe.getCurrentStatus(), reRe.getEmployeeID(), "SUBMIT PO");
            // Event.saveEvent(e);
            }
            
            Employee e= Employee.getEmployee(ClerkPOGiveNumber.getRentalPO().getEmployeeID());
            ConstructionSite adres = new ConstructionSite(ClerkPOGiveNumber.getRentalPO().getConstructionSite());
            String telNR = e.getPhoneNumber();
            RentalRequest.saveRR(reRe);
            PurchaseOrder purOrd = new PurchaseOrder( getHandlingClerk(), ClerkPOGiveNumber.getRentalPO().getSelectedEquipment(), ClerkPOGiveNumber.getRentalPO().getDailyRentalPrice(), ClerkPOGiveNumber.getRentalPO().getRentalPeriodStart(), ClerkPOGiveNumber.getRentalPO().getRentalPeriodEnd(), getTotPrice(), ClerkPOGiveNumber.getRentalPO().getConstructionSite(), e.getPhoneNumber(), ClerkPOSuppliers.getSelectedSupplier(), ClerkPOGiveNumber.getRentalPO().getEmployeeID(), ClerkPOGiveNumber.getRentalPO().getRequestNumber());
            System.out.println(purOrd.getDate());
            PurchaseOrder.savePO(purOrd);
            
            Event f = new Event(reRe.getRequestNumber(),"made PO", Integer.parseInt(idClerk.getText().trim()),"");
            Event.saveEvent(f);
            //probleem met local date en gewone date
            //PurchaseOrder p = new PurchaseOrder(ClerkPOGiveNumber.getRentalPO().getRequestNumber(), Date.valueOf(LocalDate.now()), clerkID,ClerkPOGiveNumber.getRentalPO().getSelectedSupplier(), ERROR, 0, ClerkPOGiveNumber.getRentalPO().getRentalPeriodStart(), ClerkPOGiveNumber.getRentalPO().getRentalPeriodEnd(), 0, adres, telNR, 0,ClerkPOGiveNumber.getRentalPO().getSelectedSupplier() , ClerkPOGiveNumber.getRentalPO().getEmployeeID());
        
            
        JOptionPane.showMessageDialog(null, "Purchase order "+purOrd.getOrderNr()+" is made.");
        Startscherm.getB().setVisible(true);
        
        } catch (DBException ex) {
            System.out.println("Error in ClerkPOMake");
            Startscherm.getB().setVisible(true);
        }
         
    }//GEN-LAST:event_submitActionPerformed

    private void idClerkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idClerkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idClerkActionPerformed

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
                System.out.println("Error in ClerkPOMake");
                Startscherm.getB().setVisible(true);
                }
            }
        });
    }
    public int getInvoiceNumber(){
        return Integer.parseInt(orderNr.getText().trim());
    }
    public int getHandlingClerk(){
        return Integer.parseInt(idClerk.getText().trim());
    }
    public double getTotPrice(){
        return totPrice;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ListSupplier;
    private javax.swing.JButton cancel;
    private javax.swing.JLabel construction;
    private javax.swing.JLabel datum;
    private javax.swing.JLabel daysRented;
    private javax.swing.JLabel emailAddress;
    private javax.swing.JLabel equipmentCodes;
    private javax.swing.JTextField idClerk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel orderNr;
    private javax.swing.JLabel rentalEnd;
    private javax.swing.JLabel rentalPrice;
    private javax.swing.JLabel rentalStart;
    private javax.swing.JLabel requestor;
    private javax.swing.JButton submit;
    private javax.swing.JLabel telefoonSiteEngineer;
    private javax.swing.JLabel totalPrice;
    // End of variables declaration//GEN-END:variables
 
}
