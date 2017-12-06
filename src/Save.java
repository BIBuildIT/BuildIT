
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;

public class Save {
   
    
 /*   public static void saveE(Equipment e) throws DBException {
		Connection con = null;
		try {
			con = DBConnector.getConnection();
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

			String sql = "SELECT code "
					+ "FROM Equipment "
                                        +"WHERE code = " 
                                        +e.getCode();
					
			ResultSet srs = stmt.executeQuery(sql);
			if (srs.next()) {
				// UPDATE
				sql = "UPDATE Equipment "
						+ "SET type = '"+ e.getType()+"'"
                                                +", description = '"+ e.getDescription()+"'"
                                                +" WHERE code = "+ e.getCode();
				stmt.executeUpdate(sql);
			} else {
				// INSERT
				sql = "INSERT into Equipment "
						+ "(code, type, description) "
						+ "VALUES (" + e.getCode()
                                                +", '"+e.getType()+ "'"
                                                +", '"+e.getDescription()+"')";
						
				stmt.executeUpdate(sql);
			}
			
			
			DBConnector.closeConnection(con);
		} catch (Exception ex) {
			ex.printStackTrace();
			DBConnector.closeConnection(con);
			throw new DBException(ex);
		}
	}
    
    public static void saveS(Supplier e) throws DBException {
		Connection con = null;
		try {
                    
			con = DBConnector.getConnection();
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

			String sql = "SELECT name "
					+ "FROM Supplier "
                                        +"WHERE name = '" 
                                        +e.getName() + "'";
					
			ResultSet srs = stmt.executeQuery(sql);
			if (srs.next()) {
				// UPDATE
				sql = "UPDATE Supplier "
						+ "SET email = '"+ e.getEmail()+"'"
                                                +", phoneNumber = '"+ e.getPhoneNumber()+"'"
                                                +" WHERE name = '"+ e.getName() +"'";
				stmt.executeUpdate(sql);
			} else {
				// INSERT
				sql = "INSERT into Supplier "
						+ "(name, email, phoneNumber) "
						+ "VALUES ('" + e.getName()
                                                +"' , '"+e.getEmail()+ "'"
                                                +", '"+e.getPhoneNumber()+"')";
						
				stmt.executeUpdate(sql);
			}
			
			
			DBConnector.closeConnection(con);
		} catch (Exception ex) {
			ex.printStackTrace();
			DBConnector.closeConnection(con);
			throw new DBException(ex);
		}
	}
    
    
    /*public static void saveE(Employee e) throws DBException {
		Connection con = null;
		try {
                    
			con = DBConnector.getConnection();
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

			String sql = "SELECT EmployeeID "
					+ "FROM Employee "
                                        +"WHERE EmployeeID = " 
                                        + e.getEmployeeID();
					
			//ResultSet srs = stmt.executeQuery(sql);
			if (srs.next()) {
				// UPDATE
				sql = "UPDATE Employee "
						+ "SET group = '"+ e.getGroup()+"'"
                                                +", emailAdress = '"+e.getEmailAdress()+"'"
                                                +", phoneNumber = '"+ e.getPhoneNumber()+"'"
                                               
                                                +" WHERE EmployeeID = "+ e.getEmployeeID();
				stmt.executeUpdate(sql);
			} else {
				// INSERT
				sql = "INSERT into Employee "
						+ "(employeeID, group, emailAdress, phoneNumber) "
						+ "VALUES (" + e.getEmployeeID()
                                                +", '"+e.getGroup()+ "'"
                                                +", '"+e.getEmailAdress()+"'"
                                                +", '"+e.getPhoneNumber()+"')";
						
				stmt.executeUpdate(sql);
			}
			
			
			DBConnector.closeConnection(con);
		} catch (Exception ex) {
			ex.printStackTrace();
			DBConnector.closeConnection(con);
			throw new DBException(ex);
		}
	}*/
        
    /*public static void saveC(ConstructionSite e) throws DBException {
		Connection con = null;
		try {
                    
			con = DBConnector.getConnection();
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

			String sql = "SELECT adress "
					+ "FROM ConstructionSite "
                                        +"WHERE adress = '" 
                                        +e.getAdress()+"'";
					
			ResultSet srs = stmt.executeQuery(sql);
			if (srs.next()) {
				// UPDATE
				sql = "UPDATE ConstructionSite "
						+" WHERE EmployeeID = '"+ e.getAdress()+"'";
				stmt.executeUpdate(sql);
			} else {
				// INSERT
				sql = "INSERT into ConstructionSite "
						+ "(adress) "
						+ "VALUES ("
                                                +"'"+e.getAdress()+ "')";
                                                
						
				stmt.executeUpdate(sql);
			}
			
			
			DBConnector.closeConnection(con);
		} catch (Exception ex) {
			ex.printStackTrace();
			DBConnector.closeConnection(con);
			throw new DBException(ex);
		}
	}*/
    //allemaal matersata?
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
    
    
                                
    
    public static void saveRR(RentalRequest e) throws DBException{
        Connection con = null;
		try {
                    
			con = DBConnector.getConnection();
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

			String sql = "SELECT requestNumber "
					+ "FROM RentalRequest "
                                        +"WHERE requestNumber = " 
                                        +e.getRequestNumber();
					
			ResultSet srs = stmt.executeQuery(sql);
			if (srs.next()) {
				// UPDATE
				sql = "UPDATE RentalRequest "
						+ "SET requestDate = '"+e.getRequestDate()+"'" //MOET DIE DATE IN GROTE LETTERS BLIJVEN STAAN?
                                                +", rentalPeriodStart = '"+ e.getRentalPeriodStart()+"'"
                                                +", rentalPeriodEnd = '"+e.getRentalPeriodEnd()+"'"
                                                +", rentalStatus = '"+e.getCurrentStatus()+"'"
                                                +", reasonFOrCancellationOrRefusal = '"+e.getReasonForCancelationOrRefusal()+"'"
                                                +", employeeID = '"+e.getEmployeeID()+"'"
                                                +", constructionSite = "+e.getConstructionSite()
                                                +", equipmentType = '"+e.getEquipmentType()+"'"
                                               +", selectedEquipment = '"+e.getSelectedEquipment()+"'"
                                                +", selectedSupplier = '"+e.getSelectedSupplier()+"'"
                                                +", dailyRentalPrice = "+e.getDailyRentalPrice()
                                                
                                               
                                                +" WHERE requestNumber = "+ e.getRequestNumber();
				stmt.executeUpdate(sql);
                                
			} else {
				// INSERT
				sql = "INSERT into RentalRequest "
						+ "(requestDATE, rentalPeriodStart, rentalPeriodEnd, rentalStatus, reasonFOrCancellationOrRefusal, constructionSite, equipmentType, selectedEquipment, selectedSupplier, dailyRentalPrice, employeeID) "
						+ "VALUES (" 
                                                + java.sql.Date.valueOf(e.getRequestDate())
                                                +", '"+java.sql.Date.valueOf(e.getRentalPeriodStart())+"'"
                                                +", '"+java.sql.Date.valueOf(e.getRentalPeriodEnd())+"'"
                                                +", '"+e.getCurrentStatus()+"'"
                                                +", '"+e.getReasonForCancelationOrRefusal()+"'"
                                                +", '"+e.getConstructionSite()+"'"
                                                +", '"+e.getEquipmentType()+"'"
                                                +", '"+e.getSelectedEquipment()+"'"
                                                +", '"+e.getSelectedSupplier()+"'"
                                                +", "+e.getDailyRentalPrice()+ ""
                                                +", "+5
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
    
    /*public static void saveRRL(RentalRequestLine r) throws DBException{//moet nog juist zijn
        Connection con = null;
		try {
                    
			con = DBConnector.getConnection();
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

			String sql = "SELECT orderNumber "
					+ "FROM PurchaseOrder "
                                        +"WHERE orderNumber = " 
                                        +e.getOrderNr();
					
			ResultSet srs = stmt.executeQuery(sql);
			if (srs.next()) {
				// UPDATE
				sql = "UPDATE PurchaseOrder "
						+ "SET date = '"+ e.getDate()+"'"
                                                +", handlingClerk = "+e.getHandlingClerk()
                                                +", supplier = '"+ e.getSupplier()+"'"
                                                +", sequenceCode = "+e.getSeqCode()
                                                +", dailyRentalPrice = "+e.getDailyRentalPrice()
                                                +", rentStartDate = '"+e.getRentStartDate()+"'"
                                                +", endDate = '"+e.getEndDate()+"'"
                                                +", totalPrice = "+e.getTotalPrice()
                                                +", constructionSite = '"+e.getConstructionSite()+"'"
                                                +", phoneSiteEngineer = '"+e.getPhoneSiteEngineer()+"'"
                                                +", numberInvoice = "+e.getNumberInvoice()
                                                +", nameSupplier = '"+e.getNameSupplier()+"'"
                                                +", employeeID = "+e.getEmployeeID()
                                                
                                               
                                                +" WHERE orderNumber = "+ e.getOrderNr();
				stmt.executeUpdate(sql);
			} else {
				// INSERT
				sql = "INSERT into RentalRequest "
						+ "(orderNumber , date, handlingClerk, supplier, sequenceCode, dailyRentalPrice, rentStartDate, endDate, totalPrice, constructionSite, phoneSiteEngineer, numberInvoice, nameSupplier, employeeID) "
						+ "VALUES (" + e.getOrderNr()
                                                +", '"+e.getDate()+ "'"
                                                +", "+e.getHandlingClerk()
                                                +", '"+e.getSupplier()+"'"
                                                +", "+e.getSeqCode()
                                                +", "+e.getDailyRentalPrice()
                                                +", '"+e.getRentStartDate()+"'"
                                                +", '"+e.getEndDate()+"'"
                                                +", "+e.getTotalPrice()
                                                +", '"+e.getConstructionSite()+"'"
                                                +", '"+e.getPhoneSiteEngineer()+"'"
                                                +", "+e.getNumberInvoice()
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
        
    }*/
    
    
    public static void savePO(PurchaseOrder e) throws DBException{
        Connection con = null;
		try {
                    
			con = DBConnector.getConnection();
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

			String sql = "SELECT orderNumber "
					+ "FROM PurchaseOrder "
                                        +"WHERE orderNumber = " 
                                        +e.getOrderNr();
					
			ResultSet srs = stmt.executeQuery(sql);
			if (srs.next()) {
				// UPDATE
				sql = "UPDATE PurchaseOrder "
						+ "SET date = '"+ e.getDate()+"'"
                                                +", handlingClerk = "+e.getHandlingClerk()
                                                +", supplier = '"+ e.getSupplier()+"'"
                                                +", sequenceCode = "+e.getSeqCode()
                                                +", dailyRentalPrice = "+e.getDailyRentalPrice()
                                                +", rentStartDate = '"+e.getRentStartDate()+"'"
                                                +", endDate = '"+e.getEndDate()+"'"
                                                +", totalPrice = "+e.getTotalPrice()
                                                +", constructionSite = '"+e.getConstructionSite()+"'"
                                                +", phoneSiteEngineer = '"+e.getPhoneSiteEngineer()+"'"
                                                +", numberInvoice = "+e.getNumberInvoice()
                                                +", nameSupplier = '"+e.getNameSupplier()+"'"
                                                +", employeeID = "+e.getEmployeeID()
                                                
                                               
                                                +" WHERE orderNumber = "+ e.getOrderNr();
				stmt.executeUpdate(sql);
			} else {
				// INSERT
				sql = "INSERT into RentalRequest "
						+ "(orderNumber , date, handlingClerk, supplier, sequenceCode, dailyRentalPrice, rentStartDate, endDate, totalPrice, constructionSite, phoneSiteEngineer, numberInvoice, nameSupplier, employeeID) "
						+ "VALUES (" + e.getOrderNr()
                                                +", '"+e.getDate()+ "'"
                                                +", "+e.getHandlingClerk()
                                                +", '"+e.getSupplier()+"'"
                                                +", "+e.getSeqCode()
                                                +", "+e.getDailyRentalPrice()
                                                +", '"+e.getRentStartDate()+"'"
                                                +", '"+e.getEndDate()+"'"
                                                +", "+e.getTotalPrice()
                                                +", '"+e.getConstructionSite()+"'"
                                                +", '"+e.getPhoneSiteEngineer()+"'"
                                                +", "+e.getNumberInvoice()
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
