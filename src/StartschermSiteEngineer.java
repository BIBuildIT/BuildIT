
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lmoentje
 */
public class StartschermSiteEngineer extends javax.swing.JFrame {

    /**
     * Creates new form Startscherm
     */
    public StartschermSiteEngineer() {
        initComponents();
    }
   static int teller =0;
   public static StartschermSiteEngineer startSiteEngineer = new StartschermSiteEngineer();

    public static StartschermSiteEngineer getStartSiteEngineer() {
        return startSiteEngineer;
    }
   
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tekstchoosetask = new javax.swing.JLabel();
        makeReRe = new javax.swing.JButton();
        cancelRentalReq = new javax.swing.JButton();
        inspect = new javax.swing.JButton();
        extension = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        tekstchoosetask.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        tekstchoosetask.setText("Choose your task as a site engineer");

        makeReRe.setText("Make rental request");
        makeReRe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                makeReReMouseClicked(evt);
            }
        });
        makeReRe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                makeReReActionPerformed(evt);
            }
        });

        cancelRentalReq.setText("Cancel rental request");
        cancelRentalReq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelRentalReqActionPerformed(evt);
            }
        });

        inspect.setText("Inspect material");
        inspect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inspectActionPerformed(evt);
            }
        });

        extension.setText("Ask for extension or end rental request");
        extension.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                extensionActionPerformed(evt);
            }
        });

        cancel.setText("Cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("BuildIt");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(cancel)
                    .addComponent(tekstchoosetask, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(extension, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(inspect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cancelRentalReq, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(makeReRe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(129, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(tekstchoosetask)
                .addGap(18, 18, 18)
                .addComponent(makeReRe)
                .addGap(18, 18, 18)
                .addComponent(cancelRentalReq)
                .addGap(18, 18, 18)
                .addComponent(inspect)
                .addGap(18, 18, 18)
                .addComponent(extension)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addComponent(cancel)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void makeReReActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makeReReActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_makeReReActionPerformed

    private void makeReReMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_makeReReMouseClicked
        // TODO add your h
        this.setVisible(false);
        RentalRequestForm njf;
               try {
                   njf = new RentalRequestForm(); 
                   njf.setVisible(true);
                   teller++;
               } catch (DBException ex) {
                   Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
               }
               
    }//GEN-LAST:event_makeReReMouseClicked

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        this.setVisible(false);
        Startscherm.getB().setVisible(true);
    }//GEN-LAST:event_cancelActionPerformed

    private void cancelRentalReqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelRentalReqActionPerformed
        this.setVisible(false);
        GiveNumberToCancelSite can = new GiveNumberToCancelSite();
        can.setVisible(true);
        
        
    }//GEN-LAST:event_cancelRentalReqActionPerformed

    private void inspectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inspectActionPerformed
        
        
        JFrame f = new JFrame("Enter rental request number");
    f.setVisible(true);
    f.setSize(500, 100);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setLayout(new FlowLayout());
                JButton cancel = new JButton("Cancel");
                JButton submit = new JButton("Submit");
                JTextField numberRR = new JTextField("            ");
                JLabel giveNr = new JLabel("Please give the number of the rental request.");
                
    f.add(cancel);
    f.add(submit);
    f.add(numberRR);
    f.add(giveNr);
    cancel.setBounds(10,10,20,20);
    submit.setBounds(10,50,20,20);
    giveNr.setBounds(50,500, 100,30);
    numberRR.setBounds(50,150, 100,30);  
    
    cancel.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
                StartschermSiteEngineer.getStartSiteEngineer().setVisible(false);
                f.setVisible(false);
                Startscherm.getB().setVisible(true);
           }
       });
       
    submit.addActionListener(new ActionListener() {
            @Override
            
            public void actionPerformed(ActionEvent e) {
                
                
                String numberReRe = numberRR.toString();
                int numberRR = Integer.parseInt(numberReRe); // hier nog problemen met wat er gebeurt als we een nummer ingeven
                RentalRequest a;
                try {
                    a = RentalRequest.getRentalRequest(numberRR);
                    if(a.getCurrentStatus().equals("approved")){
                    f.setVisible(false);

                    //IS MATERIAL OK?
                    //NO: RENT STAT "REFUSED"
                    //a.setCurrentStatus(RentalStatus.refused);
                    //-> optie geven om nieuwe request aan te maken?
                    
                    //YES: RENT STAT "ACCEPTED"
                    //a.setCurrentStatus(RentalStatus.accepted);
                    
                    Startscherm.getB().setVisible(true);
                        // -> VERVOLGENS TERUG NAAR STARTSCHERM
                }
                else{
                    f.setVisible(false);
                    JFrame g = new JFrame("No approval");
                    g.setVisible(true);
                    g.setSize(500, 500);
                    g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    g.setLayout(new FlowLayout());
                    JLabel text = new JLabel("Sorry, the rental request hasn't been approved.");
                    JButton ok = new JButton("OK");
                    
                }
                } catch (DBException ex) {
                    Logger.getLogger(StartschermSiteEngineer.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                }
        });
    
    }//GEN-LAST:event_inspectActionPerformed

    private void extensionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_extensionActionPerformed
        
        JFrame f = new JFrame("Enter rental request number");
    f.setVisible(true);
    f.setSize(500, 100);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setLayout(new FlowLayout());
                JLabel giveNr = new JLabel("Please enter the number of the rental request you want to extend or end");
                JButton cancel = new JButton("Cancel");
                JButton submit = new JButton("Submit");
                JTextField numberRR = new JTextField("            ");
                
                
    f.add(cancel);
    f.add(submit);
    f.add(numberRR);
    f.add(giveNr);
    cancel.setBounds(10,10,20,20);
    submit.setBounds(10,50,20,20);
    giveNr.setBounds(50,500, 100,30);
    numberRR.setBounds(50,150, 100,30);  
    
    cancel.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
                StartschermSiteEngineer.getStartSiteEngineer().setVisible(false);
                f.setVisible(false);
                Startscherm.getB().setVisible(true);
           }
       });
       
    submit.addActionListener(new ActionListener() {
            @Override
            
            public void actionPerformed(ActionEvent e) {
                
                
                String numberReRe = numberRR.toString();
                int numberRR = Integer.parseInt(numberReRe); // hier nog problemen met wat er gebeurt als we een nummer ingeven
                RentalRequest a;
                try {
                    a = RentalRequest.getRentalRequest(numberRR);
                    
                } catch (DBException ex) {
                    Logger.getLogger(StartschermSiteEngineer.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                }
        });
    }//GEN-LAST:event_extensionActionPerformed

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
            java.util.logging.Logger.getLogger(StartschermSiteEngineer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StartschermSiteEngineer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StartschermSiteEngineer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StartschermSiteEngineer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StartschermSiteEngineer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancel;
    private javax.swing.JButton cancelRentalReq;
    private javax.swing.JButton extension;
    private javax.swing.JButton inspect;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton makeReRe;
    private javax.swing.JLabel tekstchoosetask;
    // End of variables declaration//GEN-END:variables
}
