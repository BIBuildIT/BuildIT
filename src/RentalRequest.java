//import java.sql.Date;
import java.util.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class RentalRequest {
    
    private int requestNumber;
    private LocalDate requestDate;
    private Date rentalPeriodStart;
    private Date rentalPeriodEnd;
    private RentalStatus currentStatus;
    private String reasonForCancelationOrRefusal;
    private int employeeID;//MOET altijd siteEngineer zijn
    private String constructionSite;
    //private String equipmentType;
   // private ArrayList<Equipment> equipmentNeeded;
    private Equipment selectedEquipment;//moet dit ook geen ArrayList zijn? of volgende 3 pas bij PO doorvoeren??
    private Supplier selectedSupplier;
    private double dailyRentalPrice;
    private String equipmentType;
    
    


    public RentalRequest(Date rentalPeriodStart, Date rentalPeriodEnd, int employeeID, String constructionSite, String equipmentType) {
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        this.requestDate = LocalDate.now();
        
        
        this.equipmentType = equipmentType;
        this.requestNumber = requestNumber;
        this.rentalPeriodStart = rentalPeriodStart;
        this.rentalPeriodEnd = rentalPeriodEnd;

        this.currentStatus= RentalStatus.requested;
        this.reasonForCancelationOrRefusal = null;

        this.employeeID = employeeID;
        this.constructionSite = constructionSite;
        //this.equipmentNeeded= equipmentNeeded;


        this.selectedEquipment = null;//vanaf rentalstatus processed
        this.selectedSupplier = null;//vanaf rentalstatus processed
        this.dailyRentalPrice = 0.0;//vanaf rentalstatus processed
        
    }
    
    public int getRequestNumber() {
        return requestNumber;
    }

    public void setRequestNumber(int requestNumber) {
        this.requestNumber = requestNumber;
    }

    public LocalDate getRequestDate() {
        return requestDate;
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

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getConstructionSite() {
        return constructionSite;
    }

    public void setConstructionSite(String constructionSite) {
        this.constructionSite = constructionSite;
    }

    


    /*  public String getEquipmentType() {
    return equipmentType;
    }
    public void setEquipmentType(String equipmentType) {
    this.equipmentType = equipmentType;
    }
     */
   

    public Supplier getSelectedSupplier() {
        return selectedSupplier;
    }

    public void setSelectedSupplier(Supplier selectedSupplier) {
        this.selectedSupplier = selectedSupplier;
    }

    public double getDailyRentalPrice() {
        return dailyRentalPrice;
    }

    public void setDailyRentalPrice(double dailyRentalPrice) {
        this.dailyRentalPrice = dailyRentalPrice;
    }

    public String getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(String equipmentType) {
        this.equipmentType = equipmentType;
    }

    public Equipment getSelectedEquipment() {
        return selectedEquipment;
    }

    public void setSelectedEquipment(Equipment selectedEquipment) {
        this.selectedEquipment = selectedEquipment;
    }

   
    
}
