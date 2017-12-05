
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;

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
		
		//DBBuildIt.createTables();
		
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
                RentalRequestForm njf = new RentalRequestForm();
                njf.setVisible(true);
                   
		
	}
    
}
