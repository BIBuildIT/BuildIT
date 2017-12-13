

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
public class Invoice {
    private int number;//uniek nummer voor invoice
    private int supplierInvoiceNumber;//code voor leverancier
    private Date date;
    private String supplier;
    private String purchaseOrder;
    private int equipmentCode;
    //WAAROM NIET GEWOON 'CODE' ZETTEN?
    private Date rentalPeriodStart;
    //DATUM?
    private Date rentalPeriodEnd;
    private double price;
    private String nameSupplier;
    //WAAROM NIET GEWOON 'NAME'

    public Invoice(int number, int supplierInvoiceNumber, Date date, String supplier, String purchaseOrder, int equipmentCode, Date rentalPeriodStart, Date rentalPeriodEnd, double price, String nameSupplier) {
        this.number = number;
        this.supplierInvoiceNumber = supplierInvoiceNumber;
        this.date = date;
        this.supplier = supplier;
        this.purchaseOrder = purchaseOrder;
        this.equipmentCode = equipmentCode;
        this.rentalPeriodStart = rentalPeriodStart;
        this.rentalPeriodEnd = rentalPeriodEnd;
        this.price = price;
        this.nameSupplier = nameSupplier;
        //OOK MET IF EN ELSE WERKEN?!
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getSupplierInvoiceNumber() {
        return supplierInvoiceNumber;
    }

    public void setSupplierInvoiceNumber(int supplierInvoiceNumber) {
        this.supplierInvoiceNumber = supplierInvoiceNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getPurchaseOrder() {
        return purchaseOrder;
    }

    public void setPurchaseOrder(String purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }

    public int getEquipmentCode() {
        return equipmentCode;
    }

    public void setEquipmentCode(int equipmentCode) {
        this.equipmentCode = equipmentCode;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getNameSupplier() {
        return nameSupplier;
    }

    public void setNameSupplier(String nameSupplier) {
        this.nameSupplier = nameSupplier;
    }
    
        public static void saveI(Invoice e) throws DBException {
		Connection con = null;
		try {
                    
                        
			con = DBConnector.getConnection();
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

			String sql = "SELECT number "
					+ "FROM Invoice "
                                        +"WHERE name = " 
                                        +e.getNumber();
					
			ResultSet srs = stmt.executeQuery(sql);
			if (srs.next()) {
				// UPDATE
				sql = "UPDATE Invoice "
						+ "SET supplierInvoiceNumber = "+ e.getSupplierInvoiceNumber()
                                                +", date = '"+e.getDate()+"'"
                                                +", supplier = '"+ e.getSupplier()+"'"
                                                +", purchaseOrder = '"+e.getPurchaseOrder()+"'"
                                                +", equipmentCode = "+e.getEquipmentCode()
                                                +", rentalPeriodStart = '"+e.getRentalPeriodStart()+"'"
                                                +", rentalPeriodEnd = '"+e.getRentalPeriodEnd()+"'"
                                                +", price = "+e.getPrice()
                                                +", nameSupplier = '"+e.getNameSupplier()+"'"
                                                
                                               
                                                +" WHERE number = "+ e.getNumber();
				stmt.executeUpdate(sql);
			} else {
				// INSERT
				sql = "INSERT into Invoice "
						+ "(number , supplierInvoiceNumber, date, supplier, purchaseOrder, equipmentCode, rentalPeriodStart, rentalPeriodEnd, price, nameSupplier) "
						+ "VALUES (" + e.getNumber()
                                                +", '"+e.getDate()+ "'"
                                                +", '"+e.getSupplier()+"'"
                                                +", '"+e.getPurchaseOrder()+"'"
                                                +", "+e.getEquipmentCode()
                                                +", '"+e.getRentalPeriodStart()+"'"
                                                +", '"+e.getRentalPeriodEnd()+"'"
                                                +", "+e.getPrice()
                                                +", '"+e.getNameSupplier()+"'"
                                        + ")";
						
				stmt.executeUpdate(sql);
			}
			
			
			DBConnector.closeConnection(con);
		} catch (Exception ex) {
			ex.printStackTrace();
			DBConnector.closeConnection(con);
			throw new DBException(ex);
		}
	}
    
     public static Invoice getInvoice(int nr) throws DBException {
		Connection con = null;
		try {
			con = DBConnector.getConnection();
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

			String sql = "SELECT number, supplierInvoiceNumber, date, supplier, purchaseOrder, equipmentCode, rentalPeriodStart, rentalPeriodEnd, price, nameSupplier "
					+ "FROM Invoice "
                                        + "WHERE number = " + nr;
					
			
			ResultSet srs = stmt.executeQuery(sql);
			String supplier, purchaseOrder, nameSupplier;
                        int number, supplierInvoiceNumber, equipmentCode;
                        Date date, rentalPeriodStart, rentalPeriodEnd;
                        double price;  
                        
			

			if (srs.next()) {
				number = srs.getInt("number");
				supplierInvoiceNumber = srs.getInt("supplierInvoiceNumber");
				equipmentCode = srs.getInt("equipmentCode");
                                supplier = srs.getString("supplier");
                                purchaseOrder = srs.getString("purchaseOrder");
                                nameSupplier = srs.getString("nameSupplier");
                                date = srs.getDate("Date");
                                rentalPeriodStart = srs.getDate("rentalPeriodStart");
                                rentalPeriodEnd = srs.getDate("rentalPeriodEnd"); 
                                price = srs.getDouble("price");
                                
				
			} else {
				DBConnector.closeConnection(con);
				return null;
			}

			Invoice invoice = new Invoice(number, supplierInvoiceNumber, date, supplier, purchaseOrder, equipmentCode, rentalPeriodStart, rentalPeriodEnd, price, nameSupplier);
			

			DBConnector.closeConnection(con);
			return invoice;
		} catch (Exception ex) {
			ex.printStackTrace();
			DBConnector.closeConnection(con);
			throw new DBException(ex);
		}
	}
    
    
    
}
