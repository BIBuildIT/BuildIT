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
    private String function;
    private String emailAdress;
    private String phoneNumber;
    private String group;
    //IS DAT OF HET BIJ SITE, WORK ENGINEER OF CLERK HOORT?
    private String adressConstructionSite;

    public Employee(int employeeID, String function, String emailAdress, String phoneNumber, String group, String adressConstructionSite) {
        this.employeeID = employeeID;
        this.function = function;
        this.emailAdress = emailAdress;
        this.phoneNumber = phoneNumber;
        this.group = group;
        this.adressConstructionSite = adressConstructionSite;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
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

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getAdressConstructionSite() {
        return adressConstructionSite;
    }

    public void setAdressConstructionSite(String adressConstructionSite) {
        this.adressConstructionSite = adressConstructionSite;
    }
    
    
    
    
}
