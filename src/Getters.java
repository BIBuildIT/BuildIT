
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author swornoo
 */
public class Getters {

    public Getters() {
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
    
        /*public Supplier getSupplier(String supplierName) throws DBException {
		Connection con = null;
		try {
			con = DBConnector.getConnection();
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

			String sql = "SELECT name, email, phoneNumber "
					+ "FROM Supplier "
                                        + "WHERE name =" + supplierName ;
					
			
			ResultSet srs = stmt.executeQuery(sql);
			String name, email, phoneNumber;
			

			if (srs.next()) 
                        {
				name = srs.getString("name");
				email = srs.getString("email");
				phoneNumber = srs.getString("phoneNumber");
				
			} 
                        else 
                        {
				DBConnector.closeConnection(con);
				return null;
			}

			Supplier supplier = new Supplier(name, email, phoneNumber);
			

			DBConnector.closeConnection(con);
			return supplier;
                        } 
                catch (Exception ex) 
                {
			ex.printStackTrace();
			DBConnector.closeConnection(con);
			throw new DBException(ex);
		}
	}
        /*public static Equipment getEquipment(int coEq) throws DBException {
		Connection con = null;
		try {
			con = DBConnector.getConnection();
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

			String sql = "SELECT code, type, description, price, supplier "
					+ "FROM Equipment "
					+ "WHERE code = " + coEq;
			// let op de spatie na 'summary' en 'Students' in voorgaande SQL->??
			ResultSet srs = stmt.executeQuery(sql);
			String type, description;
                        int code;
                        double price;
                        String supplier;
                        //Getters g  = new Getters();
                        //Supplier s;
                        
			
			

			if (srs.next()) {
				code = srs.getInt("code");
				type = srs.getString("type");
				description = srs.getString("description");
                                price = srs.getDouble("price");
                                supplier = srs.getString("supplier");
                                //s = g.getSupplier(supplier);
				
			} else {// we verwachten slechts 1 rij...
				DBConnector.closeConnection(con);
				return null;
			}

			Equipment equipment = new Equipment(code, type, description, price, supplier);
			//hier nog iets???
                        
                        
			

			DBConnector.closeConnection(con);
			return equipment;
		} catch (Exception ex) {
			ex.printStackTrace();
			DBConnector.closeConnection(con);
			throw new DBException(ex);
		}
	}*/
        
        
        public static Employee getEmployee(int eID) throws DBException {
        Connection con= null; 
        try {
            
                con= DBConnector.getConnection();
                Statement stmt= con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
                String sql = "SELECT employeeID, grp, emailAdress, phoneNumber "
					+ "FROM Employee "
					+ "WHERE EmployeeID = " + eID;
                ResultSet srs = stmt.executeQuery(sql);
                String emailAdress, phoneNumber;
                int employeeID;
                Function grp;
            
            
                if (srs.next()){
                    employeeID = srs.getInt("employeeID");
                    grp = null; //group moet nog aangepast worden, function 
                    emailAdress = srs.getString("emailAdress");
                    phoneNumber = srs.getString("phoneNumber");
            } else {
                    DBConnector.closeConnection(con);
                    return null;
                }
            
            Employee employee = new Employee(employeeID, grp ,emailAdress,phoneNumber);
            
            DBConnector.closeConnection(con);
            return employee;
        }
            catch (Exception ex) {
			ex.printStackTrace();
			DBConnector.closeConnection(con);
			throw new DBException(ex);
                }
            
        }
        
        /*public static RentalRequest getRentalRequest(int reqnr) throws DBException{//moet aangepast worden aan constructor
            Connection con= null; 
        try {
            
                con= DBConnector.getConnection();
                Statement stmt= con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
                String sql = "SELECT requestNumber, rentalPeriodStart, rentalPeriodEnd, requestor, constructionSite, equipmentType, selectedEquipment "
					+ "FROM RentalRequest "
					+ "WHERE requestNumber = " + reqnr;
                ResultSet srs = stmt.executeQuery(sql);
     
                
                int requestNumber;
                LocalDate rentalPeriodStart;
                LocalDate rentalPeriodEnd;
                int employeeID;
                String constructionSite;
                //String equipmentType;
                String equipmentType;
                
            
                if (srs.next()){
                    //requestNumber = srs.getInt("requestNumber");
                    
                    java.sql.Date rentalStart = srs.getDate("rentalPeriodStart");
                    rentalPeriodStart= rentalStart.toLocalDate();
                    rentalPeriodEnd = srs.getDate("rentalPeriodEnd").toLocalDate();
                    employeeID = srs.getInt("employeeID");
                    constructionSite = srs.getString("constructionSite");
                    equipmentType= srs.getString("equipmentTypes");
                    
            
                } else {
                    DBConnector.closeConnection(con);
                    return null;
                }
            
            RentalRequest rentalrequest = new RentalRequest( rentalPeriodStart, rentalPeriodEnd, employeeID, constructionSite, equipmentType);
            
            DBConnector.closeConnection(con);
            return rentalrequest;
        }
            catch (Exception ex) {
			ex.printStackTrace();
			DBConnector.closeConnection(con);
			throw new DBException(ex);
                }
        }*/
    
        /*public static ArrayList<Equipment> getEquipments() throws DBException {
        Connection con= null;
        try {
            con= DBConnector.getConnection();
            Statement stmt= con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            String sql= "SELECT code "
                       +"FROM Equipment";
            ResultSet srs= stmt.executeQuery(sql);
            
            ArrayList<Equipment> equipments= new ArrayList<>();
            while(srs.next())
                equipments.add(Equipment.getEquipment(srs.getInt("code")));
            
            DBConnector.closeConnection(con);
            return equipments;
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
    }*/
    
    
   /* public static ArrayList<ConstructionSite> getConstructionSites() throws DBException {
        Connection con= null;
        try {
            con= DBConnector.getConnection();
            Statement stmt= con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            String sql= "SELECT adress "
                       +"FROM ConstructionSite";
            ResultSet srs= stmt.executeQuery(sql);
            
            ArrayList<ConstructionSite> constructionsites= new ArrayList<>();
            while(srs.next())
                constructionsites.add(new ConstructionSite(srs.getString("adress")));
            
            DBConnector.closeConnection(con);
            return constructionsites;
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
    }*/
    
    
        public static ArrayList<RentalRequest> getRentalRequests() throws DBException {
        Connection con= null;
        try {
            con= DBConnector.getConnection();
            Statement stmt= con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            String sql= "SELECT requestNumber "
                       +"FROM RentalRequest";
            ResultSet srs= stmt.executeQuery(sql);
            
            ArrayList<RentalRequest> rentalRequests = new ArrayList<>();
            while(srs.next())
                rentalRequests.add(new RentalRequest(srs.getInt("requestNumber")));
            
            DBConnector.closeConnection(con);
            return rentalRequests;
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
}
