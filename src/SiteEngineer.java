
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
    
    public SiteEngineer(int employeeID, String function, String emailAdress, String phoneNumber, ArrayList<ConstructionSite> site) {
        super(employeeID, function, emailAdress, phoneNumber);
        this.site = site;
    }
    public void makeRequest(int requestNumber,  Date rentalPeriodStart, Date rentalPeriodEnd, ConstructionSite constructionSite, String equipmentType){
        if (site.contains(constructionSite)){
        RentalRequest reRe= new RentalRequest(requestNumber, rentalPeriodStart, rentalPeriodEnd, this, constructionSite, equipmentType);
        //toevoegen aan uw arraylistRequest
        }
        else {
            System.exit(0);
        }
    }
        


    
}
