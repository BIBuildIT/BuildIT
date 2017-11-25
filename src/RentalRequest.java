
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
public class RentalRequest {
    
    private int requestNumber;
    private Date requestDate;
    private Date rentalPeriodStart;
    private Date rentalPeriodEnd;
    private RentalStatus currentStatus;
    //nog ergens fout in ENUM, maar weet niet hoe die eruit te halen is
    private String reasonForCancelationOrRefusal;
    private Employee requestor;
    //WANT REQUESTOR IS ALTIJD EEN EMPLOYEE
    private ConstructionSite constructionSite;
    private String equipmentType;
    private int employeeID;

    public RentalRequest(int requestNumber, Date requestDate, Date rentalPeriodStart, Date rentalPeriodEnd, RentalStatus currentStatus, String reasonForCancelationOrRefusal, Employee requestor, ConstructionSite constructionSite, String equipmentType, int employeeID) {
        
        if(!(requestor.getEmployeeID() == employeeID))
            System.out.println("Error: employeeID does not comply to requestor.");
        else{
        this.requestNumber = requestNumber;
        this.requestDate = requestDate;
        this.rentalPeriodStart = rentalPeriodStart;
        this.rentalPeriodEnd = rentalPeriodEnd;
        this.currentStatus = currentStatus;
        this.reasonForCancelationOrRefusal = reasonForCancelationOrRefusal;
        this.requestor = requestor;
        this.constructionSite = constructionSite;
        this.equipmentType = equipmentType;
        this.employeeID = employeeID;
        }
    }

    public int getRequestNumber() {
        return requestNumber;
    }

    public void setRequestNumber(int requestNumber) {
        this.requestNumber = requestNumber;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getRentalPeriodStart() {
        return rentalPeriodStart;
    }

    public void setRentalPeriodStart(Date rentalPeriodStart) {
        this.rentalPeriodStart = rentalPeriodStart;
    }

    public Date getRentalPeriodEnd() {
        return rentalPeriodEnd;
    }

    public void setRentalPeriodEnd(Date rentalPeriodEnd) {
        this.rentalPeriodEnd = rentalPeriodEnd;
    }

    public RentalStatus getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(RentalStatus currentStatus) {
        this.currentStatus = currentStatus;
    }

    

    public String getReasonForCancelationOrRefusal() {
        return reasonForCancelationOrRefusal;
    }

    public void setReasonForCancelationOrRefusal(String reasonForCancelationOrRefusal) {
        this.reasonForCancelationOrRefusal = reasonForCancelationOrRefusal;
    }

    public Employee getRequestor() {
        return requestor;
    }

    public void setRequestor(Employee requestor) {
        this.requestor = requestor;
    }

    public ConstructionSite getConstructionSite() {
        return constructionSite;
    }

    public void setConstructionSite(ConstructionSite constructionSite) {
        this.constructionSite = constructionSite;
    }

    public String getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(String equipmentType) {
        this.equipmentType = equipmentType;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }
    
    
    
    
    
    
    
    
    
}
