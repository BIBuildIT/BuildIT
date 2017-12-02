
import java.sql.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lmoentje
 */
public class Employee {
    
    private int employeeID;
    private Function grp;//subklasses vervangen dit!
    private String emailAdress;
    private String phoneNumber;
    

    public Employee(int employeeID, Function grp, String emailAdress, String phoneNumber) {
        this.employeeID = employeeID;
        this.grp = grp;
        this.emailAdress = emailAdress;
        this.phoneNumber = phoneNumber;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public Function getGroup() {
        return grp;
    }

    public void setGroup(Function grp) {
        this.grp = grp;
    }
    
    public String getEmailAdress() {
        return emailAdress;
    }

    public void setEmailAdress(String emailAdress) {
        this.emailAdress = emailAdress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public void makeRequest(Date rentalPeriodStart, Date rentalPeriodEnd, ConstructionSite constructionSite, String equipmentType){
      
           
           RentalRequest req = new RentalRequest ( rentalPeriodStart,  rentalPeriodEnd, this.employeeID , constructionSite, equipmentType);
           Event ev= new Event(req,this.employeeID);
           
           
        
    }      
}
