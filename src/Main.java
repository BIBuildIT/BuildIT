
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.YES_NO_CANCEL_OPTION;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lmoentje
 */
public class Main {
    
    private HashMap<Integer, Equipment> equipments;

	public Main() {
		equipments = new HashMap<Integer, Equipment>();
	}
    
    public static void main(String[] args) throws Exception {
        Startscherm begin = new Startscherm();
        begin.setVisible(true);
       // DBBuildIt.createTables();
    /*   JFrame f = new JFrame("Wat wil u doen?");
    f.setVisible(true);
    f.setSize(500, 500);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setLayout(new FlowLayout());
                JButton aanmakenRR = new JButton("Aanmaken Rentalrequest");
                JButton aanpassenRR = new JButton("Aanpassen RentalRequest");
                JButton aanmakenPO = new JButton("Aanmaken PO");   
    
    f.add(aanmakenPO);
    f.add(aanpassenRR);
    f.add(aanmakenRR);
    aanmakenRR.setBounds(10,10,20,20);
    aanpassenRR.setBounds(10,50,20,20);
    aanmakenPO.setBounds(10,90,20,20);
    
    aanmakenRR.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
                RentalRequestForm njf;
               try {
                   njf = new RentalRequestForm(); 
                   njf.setVisible(true);
               } catch (DBException ex) {
                   Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
       });
    aanpassenRR.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
           JFrame geefnummer = new JFrame();
           geefnummer.setVisible(true);
           String nummer = JOptionPane.showInputDialog("Geef het nummer van de RentalRequest.");
           int nummerRR = Integer.parseInt(nummer.trim());
           JOptionPane.showMessageDialog(null,"De rentalRequest met nummer "+nummerRR+" wordt opgevraagd.");
           //die specifieke RR opvragen adhv nummer
           }
        
    });
    aanmakenPO.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
           //PO oproepen
           }
        
    });
    
    */
                
		
		/*for(int i=0; i<3; i++){
                    Equipment e= new Equipment(i, "materiaal "+ i, "beschrijving" +i);
                    Save.saveE(e);
                }
                for(int i=0; i<3; i++){
                    Supplier s= new Supplier("naam"+i, "email"+i, "phoneNumber"+i);
                    Save.saveS(s);
                }
                
                for(int i=0; i<3; i++){
                    Employee t = new Employee(i, Function.SiteEngineer, "emailAdress"+i, "phoneNumber"+i);
                    Save.saveE(t);
                }
                
                for(int i=0; i<3; i++){
                    ConstructionSite c = new ConstructionSite("adress"+i);
                    Save.saveC(c);
                            
                }
                
                for(int i=0; i<3; i++){
                    Date d = null;
                    Date b = null;
                    Date h = null;
                    double a = 0.05;
                    
                    Invoice invoi = new Invoice(6, 7, d, "supplier"+i, "purchaseOrder"+i, i, b, h, a, "nameSupplier"+i);
                    Save.saveI(invoi);
                }
                
                
                for(int i=0; i<3; i++){
                    Date d = null;
                    Date b = null;
                    
                    
                    int employeeID = 5; // moet aangepast worden
                    ConstructionSite  constr = null;      
                    //NIET ALLES STAAT IN DE CONSTRUCTOR, WAAROM?
                    double a = 0.05;
                    
                    RentalRequest r = new RentalRequest(d, b, employeeID, constr, "equipmentType"+i);
                    Save.saveRR(r);
                }
                
                for(int i=0; i<3; i++){
                    Date d = null;
                    Date b = null;
                    Date h = null;
                    double a = 0.05;
                    ConstructionSite  constr = null;      
                    
                    PurchaseOrder po = new PurchaseOrder(i, d, i, "supplier"+i, i, a, b, h, a, constr, "phoneSiteEngineer"+i, i, "nameSupplier"+i, i);
                    
                }*/
                //ArrayList<ConstructionSite> sites = Getters.getConstructionSites();
               
                   
	
        
        
	}
    
}
