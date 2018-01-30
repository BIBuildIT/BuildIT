

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
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
public class PurchaseOrder {
    
    private int orderNr;
    private LocalDate date;
    private int handlingClerk;
    //identificatieCode
    private String equipmentCode;
    //--> wat is dat?
    private String dailyRentalPrice;
    private LocalDate rentalStartDate;
    private LocalDate rentalEndDate;
    private double totalPrice;
    private String constructionSite;
    private String phoneSiteEngineer;
    private String nameSupplier;
    private int employeeID;
    private int rentalRequestNr;

    public PurchaseOrder( int handlingClerk, String equipmentCode, String dailyRentalPrice, LocalDate rentalStartDate, LocalDate RentalEndDate, double totalPrice, String constructionSite, String phoneSiteEngineer, String nameSupplier, int employeeID, int rentalRequestNr) throws DBException {
       ArrayList<PurchaseOrder> puOr= getPurchaseOrders();
        int orderNumber=1;//1 geeft hij niet goed weer!!!!
        
        for(int i=0;i<puOr.size();i++){
            orderNumber=puOr.get(i).getOrderNr();
        }
        this.orderNr=orderNumber+10;//moet nog aanpassen, want nu uit lucht gegrepen
        
        this.date = LocalDate.now();
        this.handlingClerk = handlingClerk;
        this.equipmentCode =equipmentCode;
        this.dailyRentalPrice = dailyRentalPrice;
        this.rentalStartDate = rentalStartDate;
        this.rentalEndDate = RentalEndDate;
        this.totalPrice = totalPrice;
        this.constructionSite = constructionSite;
        this.phoneSiteEngineer = phoneSiteEngineer;
        
        this.nameSupplier = nameSupplier;
        this.employeeID = employeeID;
        this.rentalRequestNr = rentalRequestNr;
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

    public LocalDate getRentalStartDate() {
        return rentalStartDate;
    }

    public void setRentalStartDate(LocalDate rentalStartDate) {
        this.rentalStartDate = rentalStartDate;
    }

    public LocalDate getRentalEndDate() {
        return rentalEndDate;
    }

    public void setRentalEndDate(LocalDate rentalEndDate) {
        this.rentalEndDate = rentalEndDate;
    }

   

    public int getHandlingClerk() {
        return handlingClerk;
    }

    public void setHandlingClerk(int handlingClerk) {
        this.handlingClerk = handlingClerk;
    }

  

    public String getDailyRentalPrice() {
        return dailyRentalPrice;
    }

    public void setDailyRentalPrice(String dailyRentalPrice) {
        this.dailyRentalPrice = dailyRentalPrice;
    }

   
    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getConstructionSite() {
        return constructionSite;
    }

    public void setConstructionSite(String constructionSite) {
        this.constructionSite = constructionSite;
    }

    public String getPhoneSiteEngineer() {
        return phoneSiteEngineer;
    }

    public void setPhoneSiteEngineer(String phoneSiteEngineer) {
        this.phoneSiteEngineer = phoneSiteEngineer;
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

			String sql = "SELECT orderNr, date, handlingClerk, supplierEquipCode, dailyRentalPrice, rentalStartDate, rentalEndDate, totalPrice, constructionSite, phoneSiteEngineer, nameSupplier, employeeID "
					+ "FROM PurchaseOrder ";
					
			
			ResultSet srs = stmt.executeQuery(sql);
			
                        String  phoneSiteEngineer, nameSupplier, supplierEquipCode,dailyRentalPrice;
                        int orderNr, handlingClerk, employeeID;
                        LocalDate date, rentalStartDate, rentalEndDate;  
                        double totalPrice ;  
                        String constructionsite;
                        
			

			if (srs.next()) {
				orderNr = srs.getInt("orderNr");
                                date=srs.getDate("date").toLocalDate();
				handlingClerk = srs.getInt("handlingClerk");
				supplierEquipCode = srs.getString("supplierEquipCode");
                                employeeID = srs.getInt("employeeID");
                                phoneSiteEngineer = srs.getString("phoneSiteEngineer");
                                nameSupplier = srs.getString("nameSupplier");
                                rentalStartDate = srs.getDate("rentalStartDate").toLocalDate();
                                rentalEndDate = srs.getDate("rentalEndDate").toLocalDate();
                                dailyRentalPrice = srs.getString("dailyRentalPrice");
                                totalPrice = srs.getDouble("price");
                                constructionsite = srs.getString("constructionSite");
				
			} else {
				DBConnector.closeConnection(con);
				return null;
			}

			PurchaseOrder purchaseOrder = new PurchaseOrder(srs.getInt("orderNr"));
                        purchaseOrder.setDate(date);
                        purchaseOrder.setHandlingClerk(handlingClerk);
                        purchaseOrder.setEquipmentCode(	supplierEquipCode);
                        purchaseOrder.setEmployeeID(employeeID);
                        purchaseOrder.setPhoneSiteEngineer(phoneSiteEngineer);
                        purchaseOrder.setNameSupplier(nameSupplier);
                        purchaseOrder.setRentalStartDate(rentalStartDate);
                        purchaseOrder.setRentalEndDate(rentalEndDate);
                        purchaseOrder.setDailyRentalPrice(dailyRentalPrice);
                        purchaseOrder.setTotalPrice(totalPrice);
                        purchaseOrder.setConstructionSite(constructionsite);
                        
                     
			DBConnector.closeConnection(con);
			return purchaseOrder;
		} catch (Exception ex) {
			ex.printStackTrace();
			DBConnector.closeConnection(con);
			throw new DBException(ex);
		}
	}
     public static ArrayList<PurchaseOrder> getPurchaseOrders() throws DBException {
        Connection con= null;
        try {
            con= DBConnector.getConnection();
            Statement stmt= con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            String sql = "SELECT ALL orderNr, date, handlingClerk, supplierEquipCode, dailyRentalPrice, rentalStartDate, rentalEndDate, totalPrice, constructionSite, phoneSiteEngineer, nameSupplier, employeeID "
			+"FROM PurchaseOrder";
            ResultSet srs= stmt.executeQuery(sql);
            
            
               String  phoneSiteEngineer, nameSupplier, supplierEquipCode,dailyRentalPrice;
                        int orderNr, handlingClerk, employeeID;
                        LocalDate date, rentalStartDate, rentalEndDate;  
                        double totalPrice ;  
                        String constructionsite;
                        
			
                
            ArrayList<PurchaseOrder> purchaseOrders = new ArrayList<>();
            while(srs.next()){
                orderNr = srs.getInt("orderNr");
				handlingClerk = srs.getInt("handlingClerk");
				supplierEquipCode = srs.getString("supplierEquipCode");
                                employeeID = srs.getInt("employeeID");
                                phoneSiteEngineer = srs.getString("phoneSiteEngineer");
                                nameSupplier = srs.getString("nameSupplier");
                                date = srs.getDate("Date").toLocalDate();
                                rentalStartDate = srs.getDate("rentalStartDate").toLocalDate();
                                rentalEndDate = srs.getDate("rentalEndDate").toLocalDate();
                                dailyRentalPrice = srs.getString("dailyRentalPrice");
                                totalPrice = srs.getDouble("totalPrice");
                                constructionsite = srs.getString("constructionSite");
                                PurchaseOrder purchaseOrder=new PurchaseOrder(srs.getInt("orderNr"));
                                 purchaseOrder.setOrderNr(orderNr);
                        purchaseOrder.setHandlingClerk(handlingClerk);
                        purchaseOrder.setEquipmentCode(	supplierEquipCode);
                        purchaseOrder.setEmployeeID(employeeID);
                        purchaseOrder.setPhoneSiteEngineer(phoneSiteEngineer);
                        purchaseOrder.setNameSupplier(nameSupplier);
                        purchaseOrder.setDate(date);
                        purchaseOrder.setRentalStartDate(rentalStartDate);
                        purchaseOrder.setRentalEndDate(rentalEndDate);
                        purchaseOrder.setDailyRentalPrice(dailyRentalPrice);
                        purchaseOrder.setTotalPrice(totalPrice);
                        purchaseOrder.setConstructionSite(constructionsite);
                        
               purchaseOrders.add(purchaseOrder);
                   
            }
           
            DBConnector.closeConnection(con);
            return purchaseOrders;
        }
        catch (DBException dbe){
            dbe.printStackTrace();
            DBConnector.closeConnection(con);
            throw dbe;
        }
        catch(Exception ex) {
            ex.printStackTrace();
            DBConnector.closeConnection(con);
            throw new DBException(ex);
        }
    }
    public static void savePO(PurchaseOrder e) throws DBException{
        Connection con = null;
		try {
                    
			con = DBConnector.getConnection();
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

			String sql = "SELECT orderNr "
					+ "FROM PurchaseOrder "
                                        +"WHERE orderNr = " 
                                        +e.getOrderNr();
					
			ResultSet srs = stmt.executeQuery(sql);
			if (srs.next()) {
				// UPDATE
				sql = "UPDATE PurchaseOrder "
						+ "SET date = '"+ e.getDate()+"'"
                                                +", handlingClerk = "+e.getHandlingClerk()
                                                +", supplierEquipCode = '"+e.getEquipmentCode()+"'"
                                                +", dailyRentalPrice = '"+e.getDailyRentalPrice()+"'"
                                                +", rentalStartDate = '"+e.getRentalStartDate()+"'"
                                                +", rentalEndDate = '"+e.getRentalEndDate()+"'"
                                                +", totalPrice = "+e.getTotalPrice()
                                                +", constructionSite = '"+e.getConstructionSite()+"'"
                                                +", phoneSiteEngineer = '"+e.getPhoneSiteEngineer()+"'"
                                                +", nameSupplier = '"+e.getNameSupplier()+"'"
                                                +", employeeID = "+e.getEmployeeID()
                                                
                                               
                                                +" WHERE orderNr = "+ e.getOrderNr();
				stmt.executeUpdate(sql);
			} else {
				// INSERT
				sql = "INSERT into PurchaseOrder "
						+ "(date, handlingClerk, supplierEquipCode, dailyRentalPrice, rentalStartDate, rentalEndDate, totalPrice, constructionSite, phoneSiteEngineer, nameSupplier, employeeID) "
						+ "VALUES ('"+e.getDate()+ "'"
                                                +", "+e.getHandlingClerk()
                                                +", '"+e.getEquipmentCode()+"'"
                                                +", '"+e.getDailyRentalPrice()+"'"
                                                +", '"+e.getRentalStartDate()+"'"
                                                +", '"+e.getRentalEndDate()+"'"
                                                +", "+e.getTotalPrice()
                                                +", '"+e.getConstructionSite()+"'"
                                                +", '"+e.getPhoneSiteEngineer()+"'"
                                                +", '"+e.getNameSupplier()+"'"
                                                +", "+e.getEmployeeID()
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
}
