

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lmoentje
 */
public class PurchaseOrder {
    
    private int orderNr;
    private LocalDate date;
    private int handlingClerk;
    //identificatieCode
    private String supplier;
    private String equipmentCode;
    //--> wat is dat?
    private double dailyRentalPrice;
    private LocalDate rentStartDate;
    private LocalDate endDate;
    private double totalPrice;
    private ConstructionSite constructionSite;
    private String phoneSiteEngineer;
    private int numberInvoice;
    private String nameSupplier;
    private int employeeID;

    public PurchaseOrder(int orderNr, int handlingClerk, String supplier, String equipmentCode, double dailyRentalPrice, LocalDate rentStartDate, LocalDate endDate, double totalPrice, ConstructionSite constructionSite, String phoneSiteEngineer, int numberInvoice, String nameSupplier, int employeeID) {
        this.orderNr = orderNr;
        this.date = LocalDate.now();
        this.handlingClerk = handlingClerk;
        this.supplier = supplier;
        this.equipmentCode =equipmentCode;
        this.dailyRentalPrice = dailyRentalPrice;
        this.rentStartDate = rentStartDate;
        this.endDate = endDate;
        this.totalPrice = totalPrice;
        this.constructionSite = constructionSite;
        this.phoneSiteEngineer = phoneSiteEngineer;
        this.numberInvoice = numberInvoice;
        this.nameSupplier = nameSupplier;
        this.employeeID = employeeID;
    }

    public PurchaseOrder(int orderNr) {
        this.orderNr = orderNr;
    }

    
    public int getOrderNr() {
        return orderNr;
    }

    public void setOrderNr(int orderNr) {
        this.orderNr = orderNr;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getEquipmentCode() {
        return equipmentCode;
    }

    public void setEquipmentCode(String equipmentCode) {
        this.equipmentCode = equipmentCode;
    }

    public LocalDate getRentStartDate() {
        return rentStartDate;
    }

    public void setRentStartDate(LocalDate rentStartDate) {
        this.rentStartDate = rentStartDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

   

    public int getHandlingClerk() {
        return handlingClerk;
    }

    public void setHandlingClerk(int handlingClerk) {
        this.handlingClerk = handlingClerk;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

  

    public double getDailyRentalPrice() {
        return dailyRentalPrice;
    }

    public void setDailyRentalPrice(double dailyRentalPrice) {
        this.dailyRentalPrice = dailyRentalPrice;
    }

   
    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public ConstructionSite getConstructionSite() {
        return constructionSite;
    }

    public void setConstructionSite(ConstructionSite constructionSite) {
        this.constructionSite = constructionSite;
    }

    public String getPhoneSiteEngineer() {
        return phoneSiteEngineer;
    }

    public void setPhoneSiteEngineer(String phoneSiteEngineer) {
        this.phoneSiteEngineer = phoneSiteEngineer;
    }

    public int getNumberInvoice() {
        return numberInvoice;
    }

    public void setNumberInvoice(int numberInvoice) {
        this.numberInvoice = numberInvoice;
    }

    public String getNameSupplier() {
        return nameSupplier;
    }

    public void setNameSupplier(String nameSupplier) {
        this.nameSupplier = nameSupplier;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }
    
    public static PurchaseOrder getPurchaseOrder(int nr) throws DBException {
		Connection con = null;
		try {
			con = DBConnector.getConnection();
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

			String sql = "SELECT  orderNr, date, handlingClerk, supplier, seqCode, dailyRentalPrice, rentStartDate, endDate, totalPrice, constructionSite, phoneSiteEngineer, numberInvoice, nameSupplier, employeeID "
					+ "FROM PurchaseOrder "
                                        + "WHERE orderNr = " + nr;
					
			
			ResultSet srs = stmt.executeQuery(sql);
			
                        String supplier, phoneSiteEngineer, nameSupplier;
                        int orderNr, handlingClerk, seqCode, numberInvoice, employeeID;
                        Date date, rentStartDate, endDate;  
                        double dailyRentalPrice, totalPrice ;  
                        ConstructionSite constructionsite;
                        
			

			if (srs.next()) {
				orderNr = srs.getInt("orderNr");
				handlingClerk = srs.getInt("handlingClerk");
				seqCode = srs.getInt("seqCode");
                                numberInvoice = srs.getInt("numberInvoice");
                                employeeID = srs.getInt("employeeID");
                                supplier = srs.getString("supplier");
                                phoneSiteEngineer = srs.getString("phoneSiteEngineer");
                                nameSupplier = srs.getString("nameSupplier");
                                date = srs.getDate("Date");
                                rentStartDate = srs.getDate("rentStartDate");
                                endDate = srs.getDate("endDate");
                                dailyRentalPrice = srs.getDouble("dailyRentalPrice");
                                totalPrice = srs.getDouble("price");
                                constructionsite = new ConstructionSite(srs.getString("constructionSite"));
				
			} else {
				DBConnector.closeConnection(con);
				return null;
			}

			PurchaseOrder purchaseOrder = new PurchaseOrder(srs.getInt("orderNr"));
                        
                        
			DBConnector.closeConnection(con);
			return purchaseOrder;
		} catch (Exception ex) {
			ex.printStackTrace();
			DBConnector.closeConnection(con);
			throw new DBException(ex);
		}
	}
    
    
}
