/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lmoentje
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author lmoentje
 */
public class DBBuildIt {
    
    public static void createTables() throws DBException {
		try {
			// dit maakt de tabellen aan, de relaties moeten nog wel gelegd
			// worden via phpmyadmin
			Connection con = DBConnector.getConnection();
			Statement stmt = con.createStatement();
			String sql = "CREATE TABLE Equipment ("
                                + "code NUMBER(15) NOT NULL,"
                                + "type VARCHAR(50) NOT NULL,"
                                + "description VARCHAR(200) NOT NULL,"
                                + "PRIMARY KEY(code))";
                        //moet er not null bij description?
			
			stmt.executeUpdate(sql);
			sql = "CREATE TABLE Supplier ("
                                + "name VARCHAR(50) NOT NULL,"
                                + "email VARCHAR(50) NOT NULL,"
                                + "phoneNumber VARCHAR(50) NOT NULL,"
                                + "PRIMARY KEY(name))";
			stmt.executeUpdate(sql);
                        sql = "CREATE TABLE Invoice ("
                                + "number NUMBER(15) NOT NULL AUTO_INCREMENT, "
                                // AUTO INCREMENT BIJ NIEUWE INVOICE
                                + "supplierInvoiceNumber NUMBER(15) NOT NULL,"
                                + "date DATE NOT NULL,"
                                + "supplier VARCHAR(50) NOT NULL"
                                + "purchaseOrder VARCHAR(50) NOT NULL,"
                                + "equipmentCode NUMBER(15) NOT NULL,"
                                + "rentalPeriodStart DATE NOT NULL,"
                                + "rentalPeriodEnd DATE NOT NULL,"
                                + "price NUMBER(15) NOT NULL,"
                                + "nameSupplier VARCHAR(50) NOT NULL,"
                                + "PRIMARY KEY(number)"
                                +")";
			stmt.executeUpdate(sql);
                        sql= "ALTER TABLE Invoice "
                                +" ADD FOREIGN KEY(nameSupplier) REFERENCES Supplier (name))"
                                +"ON DELETE RESTRICT ON UPDATE RESTRICT;";
                        stmt.executeUpdate(sql);
                        sql = "CREATE TABLE PurchaseOrder ("
                                + "orderNr NUMBER(15) NOT NULL,"
                                + "date DATE NOT NULL,"
                                + "handlingClerk NUMBER(15) NOT NULL,"
                                + "supplier VARCHAR(50) NOT NULL,"
                                + "sequence Code NUMBER(15) NOT NULL,"
                                + "dailyRentalPrice NUMBER(15) NOT NULL,"
                                + "rentStartDate DATE NOT NULL,"
                                + "endDate DATE NOT NULL,"
                                + "totalPrice NUMBER(15) NOT NULL,"
                                + "constructionSite VARCHAR(50) NOT NULL,"
                                + "phoneSiteEngineer VARCHAR(50) NOT NULL,"
                                + "numberInvoice NUMBER(15) NOT NULL,"
                                + "nameSupplier VARCHAR(50) NOT NULL,"
                                + "employeeID NUMBER(15) NOT NULL,"
                                + "PRIMARY KEY(orderNr)"
                                +")";
			stmt.executeUpdate(sql);
                        sql="ALTER TABLE PurchaseOrder "
                                + " ADD FOREIGN KEY(numberInvoice) REFERENCES Invoice(number)"
                                +"ON DELETE RESTRICT ON UPDATE RESTRICT,"
                                + "FOREIGN KEY(nameSupplier) REFERENCES Supplier (name)"
                                +"ON DELETE RESTRICT ON UPDATE RESTRICT,"
                                + "FOREIGN KEY(employeeID) REFERENCES Employee (EmployeeID))"
                                +"ON DELETE RESTRICT ON UPDATE RESTRICT;";
                        stmt.executeUpdate(sql);
                        
                        sql = "CREATE TABLE RentalRequest ("
                                + "requestNumber NUMBER(15) NOT NULL,"
                                + "requestDATE DATE NOT NULL,"
                                + "rentalPeriodStart DATE NOT NULL,"
                                + "rentalPeriodEnd DATE NOT NULL,"
                                + "rentalStatus BOOLEAN NOT NULL,"
                                + "reasonFOrCancellationOrRefusal VARCHAR(50) NOT NULL"//overal nog aanpassen met twee l'en
                                + "requestor VARCHAR(50) NOT NULL,"
                                + "constructionSite VARCHAR(50) NOT NULL,"
                                + "equipmentType VARCHAR(50) NOT NULL,"
                                + "employeeID NUMBER(15) NOT NULL,"
                                + "PRIMARY KEY(requestNumber)"
                                +")";
                                
			stmt.executeUpdate(sql);
                        sql="ALTER TABLE RentalRequest("
                                + "ADD FOREIGN KEY(employeeID) REFERENCES Employee (EmployeeID))"
                                +"ON DELETE RESTRICT ON UPDATE RESTRICT;";
                        stmt.executeUpdate(sql);
                        sql = "CREATE TABLE Employee ("
                                + "employeeID NUMBER(15) NOT NULL,"
                                + "function VARCHAR(50) NOT NULL,"
                                + "emailAdress VARCHAR(50) NOT NULL,"
                                + "phoneNumber VARCHAR(50) NOT NULL,"
                                + "group VARCHAR(50) NOT NULL,"
                                + "adressConstructionSite VARCHAR(50) NOT NULL,"
                                + "PRIMARY KEY(employeeID))";
                        stmt.executeUpdate(sql);
                        sql = "CREATE TABLE ConstructionSite ("
                                + "adress VARCHAR(50) NOT NULL,"
                                + "PRIMARY KEY(adress))";
			stmt.executeUpdate(sql);
                        /**stmt.executeUpdate(sql);
			sql = "CREATE TABLE Depot ()";*/
			DBConnector.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
    public static Equipment getEquipment(int coEq) throws DBException {
		Connection con = null;
		try {
			con = DBConnector.getConnection();
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

			String sql = "SELECT code, type, description "
					+ "FROM Equipment "
					+ "WHERE code = " + coEq;
			// let op de spatie na 'summary' en 'Students' in voorgaande SQL
			ResultSet srs = stmt.executeQuery(sql);
			String type, description;
                        int code;
			
			

			if (srs.next()) {
				code = srs.getInt("code");
				type = srs.getString("type");
				description = srs.getString("description");
				
			} else {// we verwachten slechts 1 rij...
				DBConnector.closeConnection(con);
				return null;
			}

			Equipment equipment = new Equipment(code, type, description);
			//hier nog iets???
			

			DBConnector.closeConnection(con);
			return equipment;
		} catch (Exception ex) {
			ex.printStackTrace();
			DBConnector.closeConnection(con);
			throw new DBException(ex);
		}
	}
    
    public static void save(Equipment e) throws DBException {
		Connection con = null;
		try {
			con = DBConnector.getConnection();
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

			String sql = "SELECT code "
					+ "FROM Equipment "
					+ "WHERE code = "
					+ e.getCode();
			ResultSet srs = stmt.executeQuery(sql);
			if (srs.next()) {
				// UPDATE
				sql = "UPDATE Equipment "
						+ "SET code = " + e.getCode() 
                                                +", type = '"+ e.getType()+"'"
                                                +", description = '"+ e.getDescription()+"'";
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
    public static ArrayList<Equipment> getEquipments() throws DBException {
        Connection con= null;
        try {
            con= DBConnector.getConnection();
            Statement stmt= con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            String sql= "SELECT code"
                       +"FROM Equipment";
            ResultSet srs= stmt.executeQuery(sql);
            
            ArrayList<Equipment> equipments= new ArrayList<>();
            while(srs.next())
                equipments.add(getEquipment(srs.getInt("code")));
            
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
    }
    
}
