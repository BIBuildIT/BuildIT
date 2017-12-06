/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jonas & pieter
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
                                + "code int(15) NOT NULL,"
                                + "type VARCHAR(50) NOT NULL,"
                                + "description VARCHAR(200) NOT NULL,"
                                + "PRIMARY KEY(code)"+")";
                        //moet er not null bij description?
			
			stmt.executeUpdate(sql);
			sql = "CREATE TABLE Supplier ("
                                + "name VARCHAR(50) NOT NULL,"
                                + "email VARCHAR(50) NOT NULL,"
                                + "phoneNumber VARCHAR(50) NOT NULL,"
                                + "PRIMARY KEY(name)"+")";
			stmt.executeUpdate(sql);
                        sql = "CREATE TABLE Employee ("
                                + "employeeID int(15) NOT NULL AUTO_INCREMENT,"
                                + "grp ENUM('SiteEngineer', 'Clerk', 'WorksEngineer') NOT NULL,"
                                + "emailAdress VARCHAR(50) NOT NULL,"
                                + "phoneNumber VARCHAR(50) NOT NULL,"
                                + "PRIMARY KEY(employeeID)"+")";
                        stmt.executeUpdate(sql);
                        sql = "CREATE TABLE ConstructionSite ("
                                + "adress VARCHAR(50) NOT NULL,"
                                + "PRIMARY KEY(adress)"+")";
			stmt.executeUpdate(sql);
                        
                        sql = "CREATE TABLE RentalRequest ("
                                + "requestNumber int(15) NOT NULL AUTO_INCREMENT,"//ook auto increment??
                                + "requestDate DATE NOT NULL,"
                                + "rentalPeriodStart DATE NOT NULL,"
                                + "rentalPeriodEnd DATE NOT NULL,"
                                + "rentalStatus ENUM('requested', 'processed', 'readyForApproval', 'approved', 'cancelled', 'ordered', 'refused', 'accepted', 'submittedForPayment') NOT NULL,"
                                + "reasonForCancellationOrRefusal VARCHAR(50) NULL,"
                                + "constructionSite VARCHAR(50) NOT NULL,"
                                + "equipmentType VARCHAR(50) NOT NULL,"
                                + "selectedEquipment VARCHAR(50) NULL,"
                                + "selectedSupplier VARCHAR(50) NULL,"
                                + "dailyRentalPrice int(15) NULL,"
                                + "employeeID int(15) NOT NULL,"
                                + "PRIMARY KEY(requestNumber)"+")";
                                
                      
                        
			stmt.executeUpdate(sql);
                        sql="ALTER TABLE RentalRequest"
                                +" ADD FOREIGN KEY(employeeID) REFERENCES Employee (employeeID)"
                                +" ON DELETE RESTRICT ON UPDATE RESTRICT;";
                        stmt.executeUpdate(sql);
                         sql = "CREATE TABLE Invoice ("
                                + "number int(15) NOT NULL AUTO_INCREMENT, "
                                // AUTO INCREMENT BIJ NIEUWE INVOICE
                                + "supplierInvoiceNumber int(15) NOT NULL,"
                                + "date DATE NOT NULL,"
                                + "supplier VARCHAR(50) NOT NULL,"
                                + "purchaseOrder VARCHAR(50) NOT NULL,"
                                + "equipmentCode int(15) NOT NULL,"
                                + "rentalPeriodStart DATE NOT NULL,"
                                + "rentalPeriodEnd DATE NOT NULL,"
                                + "price int(15) NOT NULL,"
                                + "nameSupplier VARCHAR(50) NOT NULL,"
                                + "PRIMARY KEY(number)"
                                +")";
			stmt.executeUpdate(sql);
                        sql= "ALTER TABLE Invoice "
                                +" ADD FOREIGN KEY(nameSupplier) REFERENCES Supplier (name)"
                                +" ON DELETE RESTRICT ON UPDATE RESTRICT;";
                        stmt.executeUpdate(sql);
                        
                        sql = "CREATE TABLE PurchaseOrder ("
                                + "orderNr int(15) NOT NULL,"
                                + "date DATE NOT NULL,"
                                + "handlingClerk int(15) NOT NULL,"
                                + "supplier VARCHAR(50) NOT NULL,"
                                + "sequenceCode int(15) NOT NULL,"
                                + "dailyRentalPrice int(15) NOT NULL,"
                                + "rentStartDate DATE NOT NULL,"
                                + "endDate DATE NOT NULL,"
                                + "totalPrice int(15) NOT NULL,"
                                + "constructionSite VARCHAR(50) NOT NULL,"
                                + "phoneSiteEngineer VARCHAR(50) NOT NULL,"
                                + "numberInvoice int(15) NOT NULL,"
                                + "nameSupplier VARCHAR(50) NOT NULL,"
                                + "employeeID int(15) NOT NULL,"
                                + "PRIMARY KEY(orderNr)"
                                +")";
			stmt.executeUpdate(sql);
                        sql="ALTER TABLE PurchaseOrder "
                                +" ADD FOREIGN KEY(numberInvoice) REFERENCES Invoice(number)"
                                +" ON DELETE RESTRICT ON UPDATE RESTRICT,"
                                +" ADD FOREIGN KEY(nameSupplier) REFERENCES Supplier (name)"
                                +" ON DELETE RESTRICT ON UPDATE RESTRICT,"
                                +" ADD FOREIGN KEY(employeeID) REFERENCES Employee (employeeID)"
                                +" ON DELETE RESTRICT ON UPDATE RESTRICT";
                        stmt.executeUpdate(sql); 
                        
                        
                        
			DBConnector.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}