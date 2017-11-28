import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

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
    private LocalDate requestDate;
    private Date rentalPeriodStart;
    private Date rentalPeriodEnd;
    private RentalStatus currentStatus;
    private String reasonForCancelationOrRefusal;
    private SiteEngineer requestor;//MOET altijd siteEngineer zijn
    private ConstructionSite constructionSite;
    private String equipmentType;
    private Equipment selectedEquipment;
    private Supplier selectedSupplier;
    private double dailyRentalPrice;
    
    //arraylist voor de requests bij te houden??

    public RentalRequest(int requestNumber, Date rentalPeriodStart, Date rentalPeriodEnd, SiteEngineer requestor, ConstructionSite constructionSite, String equipmentType) {
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate localDate = LocalDate.now();
        
        this.requestNumber = requestNumber;
        this.requestDate = localDate;
        this.rentalPeriodStart = rentalPeriodStart;
        this.rentalPeriodEnd = rentalPeriodEnd;
        this.currentStatus= RentalStatus.requested;
        this.reasonForCancelationOrRefusal = null;
        this.requestor = requestor;
        this.constructionSite = constructionSite;
        this.equipmentType = equipmentType;
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

    public void setRequestDate(LocalDate requestDate) {
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

    public SiteEngineer getRequestor() {
        return requestor;
    }

    public void setRequestor(SiteEngineer requestor) {
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
    
    public Equipment getSelectedEquipment() {
        return selectedEquipment;
    }

    public void setSelectedEquipment(Equipment selectedEquipment) {
        this.selectedEquipment = selectedEquipment;
    }

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


    
}
