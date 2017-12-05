
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
    
    ArrayList<ConstructionSite> sites;
    ArrayList<Equipment> types;
    
    /**public RentalRequestForm(ArrayList<ConstructionSite> sites) {
        initComponents();
        this.sites = sites;
        DefaultListModel listModel = new DefaultListModel();
        for (int i = 0; i < sites.size(); i++)
        {
            listModel.addElement(sites.get(i).getAdress());
        }
        ConstructionSiteList.setModel(listModel);
    }*/

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
        ConstructionSiteList = new javax.swing.JList<>();
        EquipmentTypeList = new java.awt.Choice();
        SubmitButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Titel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Titel.setText("Rentalrequest");

        giveEmployeeID.setText("EmployeeID:");

        employeeID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeIDActionPerformed(evt);
            }
        });

        giveConstructionSite.setText("ConstructionSite:");

        giveStartRentalPeriod.setText("Start of rental period:");

        startRentalPeriod.setText("YYYYMMDD");

        giveEndofRentalPeriod.setText("End of rental period:");

        ConstructionSiteList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(ConstructionSiteList);

        SubmitButton.setText("Submit");
        SubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Type Equipment");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(SubmitButton)
                .addGap(18, 18, 18))
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Titel)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(giveStartRentalPeriod)
                                    .addComponent(giveEndofRentalPeriod))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(endRentalPeriod, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                                    .addComponent(startRentalPeriod, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(giveEmployeeID)
                                    .addComponent(giveConstructionSite))
                                .addGap(50, 50, 50)
                                .addComponent(employeeID, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(66, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EquipmentTypeList, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Titel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(giveEmployeeID)
                    .addComponent(employeeID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(giveConstructionSite)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EquipmentTypeList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(giveStartRentalPeriod)
                    .addComponent(startRentalPeriod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(giveEndofRentalPeriod)
                    .addComponent(endRentalPeriod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addComponent(SubmitButton))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void employeeIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_employeeIDActionPerformed

    private void SubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitButtonActionPerformed
       // String selectedConstructionSite = ConstructionSiteListMouseClicked(ConstructionSiteList);
       String selectedConstructionSite = ConstructionSiteList.getSelectedValue();
        JOptionPane.showMessageDialog(null, "U chose " + selectedConstructionSite);
    }//GEN-LAST:event_SubmitButtonActionPerformed

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
    
    public void sendRequestForm() {
        Date d = null;
        Date b = null;

        SiteEngineer site = null;
        ConstructionSite  constr = null;      
        //NIET ALLES STAAT IN DE CONSTRUCTOR, WAAROM?
        double a = 0.05;

        //RentalRequest r = new RentalRequest(i, d, b, site, constr, "equipmentType"+i);
        //Save.saveRR(r);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> ConstructionSiteList;
    private java.awt.Choice EquipmentTypeList;
    private javax.swing.JButton SubmitButton;
    private javax.swing.JLabel Titel;
    private javax.swing.JTextField employeeID;
    private javax.swing.JTextField endRentalPeriod;
    private javax.swing.JLabel giveConstructionSite;
    private javax.swing.JLabel giveEmployeeID;
    private javax.swing.JLabel giveEndofRentalPeriod;
    private javax.swing.JLabel giveStartRentalPeriod;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField startRentalPeriod;
    // End of variables declaration//GEN-END:variables

    public RentalRequestForm() throws DBException{
        initComponents();
        
        sites = Getters.getConstructionSites();
        
        DefaultListModel<String> model = new DefaultListModel<>();
        
        for(ConstructionSite site : sites){
            model.addElement(site.getAdress());
        }
        
        ConstructionSiteList.setModel(model);
        
        types = Getters.getEquipments();
       
        for(Equipment type : types){
            EquipmentTypeList.add(type.getType());
        }
    }
    
 public int getEmployeeID()
    {
        return (Integer.parseInt(employeeID.getText().trim()));
    }

 public Date getStartRentalRequest() throws ParseException
    {
     SimpleDateFormat originalFormat = new SimpleDateFormat("yyyyMMdd");
     Date datum = (Date) originalFormat.parse(startRentalPeriod.getText().trim());
     return datum;
    }
 public Date getEndRentalRequest() throws ParseException
    {
     SimpleDateFormat originalFormat = new SimpleDateFormat("yyyyMMdd");
     Date datum = (Date) originalFormat.parse(endRentalPeriod.getText().trim());
     return datum;
    }
}