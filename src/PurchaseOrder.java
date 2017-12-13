

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
    private Date date;
    private int handlingClerk;
    //identificatieCode
    private String supplier;
    private int seqCode;
    //--> wat is dat?
    private double dailyRentalPrice;
    private Date rentStartDate;
    private Date endDate;
    private double totalPrice;
    private ConstructionSite constructionSite;
    private String phoneSiteEngineer;
    private int numberInvoice;
    private String nameSupplier;
    private int employeeID;

    public PurchaseOrder(int orderNr, Date date, int handlingClerk, String supplier, int seqCode, double dailyRentalPrice, Date rentStartDate, Date endDate, double totalPrice, ConstructionSite constructionSite, String phoneSiteEngineer, int numberInvoice, String nameSupplier, int employeeID) {
        this.orderNr = orderNr;
        this.date = date;
        this.handlingClerk = handlingClerk;
        this.supplier = supplier;
        this.seqCode = seqCode;
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

    public int getOrderNr() {
        return orderNr;
    }

    public void setOrderNr(int orderNr) {
        this.orderNr = orderNr;
    }

    public Date getDate() {
        return date;
    }

    

    public void setDate(Date date) {
        this.date = date;
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

    public int getSeqCode() {
        return seqCode;
    }

    public void setSeqCode(int seqCode) {
        this.seqCode = seqCode;
    }

    public double getDailyRentalPrice() {
        return dailyRentalPrice;
    }

    public void setDailyRentalPrice(double dailyRentalPrice) {
        this.dailyRentalPrice = dailyRentalPrice;
    }

    public Date getRentStartDate() {
        return rentStartDate;
    }

    public void setRentStartDate(Date rentStartDate) {
        this.rentStartDate = rentStartDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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

			PurchaseOrder purchaseorder = new PurchaseOrder(orderNr, date, handlingClerk, supplier, seqCode, dailyRentalPrice, rentStartDate, endDate, totalPrice, constructionsite, phoneSiteEngineer, numberInvoice, nameSupplier, employeeID);
			

			DBConnector.closeConnection(con);
			return purchaseorder;
		} catch (Exception ex) {
			ex.printStackTrace();
			DBConnector.closeConnection(con);
			throw new DBException(ex);
		}
	}
    
    
}
