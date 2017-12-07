//import java.sql.Date;
import java.time.Instant;
import java.util.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class RentalRequest {
    
    private int requestNumber;
    private LocalDate requestDate;
    
    private LocalDate rentalPeriodStart;
    private LocalDate rentalPeriodEnd;
    private RentalStatus currentStatus;
    private String reasonForCancelationOrRefusal;
    private int employeeID;//MOET altijd siteEngineer zijn
    private String constructionSite;
    
   // private ArrayList<Equipment> equipmentNeeded;
    private Equipment selectedEquipment;//dit String?
    private Supplier selectedSupplier;
    private double dailyRentalPrice;
    private String equipmentType;
    
    


    public RentalRequest(LocalDate rentalPeriodStart, LocalDate rentalPeriodEnd, int employeeID, String constructionSite, String equipmentType) {
        
       
       this.requestDate = LocalDate.now();

        
        this.equipmentType = equipmentType;
        this.requestNumber = requestNumber;//hoe moet dit??
        this.rentalPeriodStart = rentalPeriodStart;
        this.rentalPeriodEnd = rentalPeriodEnd;

        this.currentStatus= RentalStatus.requested;
        this.reasonForCancelationOrRefusal = null;

        this.employeeID = employeeID;
        this.constructionSite = constructionSite;
        


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

    public LocalDate getRentalPeriodStart() {
        return rentalPeriodStart;
    }

    public void setRentalPeriodStart(LocalDate rentalPeriodStart) {
        this.rentalPeriodStart = rentalPeriodStart;
    }

    public LocalDate getRentalPeriodEnd() {
        return rentalPeriodEnd;
    }

    public void setRentalPeriodEnd(LocalDate rentalPeriodEnd) {
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
