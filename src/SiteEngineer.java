 
import java.sql.Date;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jhooster
 */
public class SiteEngineer extends Employee {
    private ArrayList<ConstructionSite> site;
    
    public SiteEngineer(int employeeID, String emailAdress, String phoneNumber, ArrayList<ConstructionSite> site) {
        super(employeeID, Function.SiteEngineer, emailAdress, phoneNumber);
        this.site = site;
    }

    public ArrayList<ConstructionSite> getSite() {
        return site;
    }

    public void setSite(ArrayList<ConstructionSite> site) {
        this.site = site;
    }   
}
