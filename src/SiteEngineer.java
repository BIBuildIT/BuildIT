
import java.sql.Date;

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
    
    public SiteEngineer(int employeeID, String function, String emailAdress, String phoneNumber, String group, String adressConstructionSite) {
        super(employeeID, function, emailAdress, phoneNumber, group, adressConstructionSite);
    }
    
    public void makeRequest(int requestNumber, Date requestDate, Date rentalPeriodStart, Date rentalPeriodEnd, RentalStatus currentStatus, String reasonForCancelationOrRefusal, Employee requestor, ConstructionSite constructionSite, String equipmentType){
        RentalRequest req = new RentalRequest(requestNumber, requestDate, rentalPeriodStart, rentalPeriodEnd, currentStatus, reasonForCancelationOrRefusal, requestor, constructionSite, equipmentType, this.getEmployeeID());
        
    }

    
}
