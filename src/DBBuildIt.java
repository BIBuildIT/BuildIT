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
                                + "price DOUBLE NOT NULL,"
                                + "supplier VARCHAR(50) NOT NULL,"
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
                                + "emailAddress VARCHAR(50) NOT NULL,"
                                + "phoneNumber VARCHAR(50) NOT NULL,"
                                + "PRIMARY KEY(employeeID)"+")";
                        stmt.executeUpdate(sql);
                        sql = "CREATE TABLE ConstructionSite ("
                                + "address VARCHAR(50) NOT NULL,"
                                + "PRIMARY KEY(address)"+")";
            stmt.executeUpdate(sql);
                       
                        sql = "CREATE TABLE RentalRequest ("
                                + "requestNumber int(15) NOT NULL AUTO_INCREMENT,"  //AUTO_INCREMENT," ook auto increment??
                                + "requestDate DATE NOT NULL,"
                                + "rentalPeriodStart DATE NOT NULL,"
                                + "rentalPeriodEnd DATE NOT NULL,"
                                + "rentalStatus ENUM('requested', 'processed', 'readyForApproval', 'approved', 'cancelled', 'ordered', 'refused', 'accepted', 'submittedForPayment', 'readyToCancel', 'readyForInvoice') NOT NULL,"
                                + "reasonForCancellationOrRefusal VARCHAR(50) NULL,"
                                + "constructionSite VARCHAR(50) NOT NULL,"
                                + "equipmentType VARCHAR(10000) NOT NULL,"
                                + "selectedEquipment VARCHAR(1000) NULL,"
                                + "selectedSupplier VARCHAR(1000) NULL,"
                                + "dailyRentalPrice VARCHAR(1000) NULL,"
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
                                + "orderNr int(15) NOT NULL AUTO_INCREMENT,,"
                                + "date DATE NOT NULL,"
                                + "handlingClerk int(15) NOT NULL,"
                                + "supplierEquipCode VARCHAR(100) NOT NULL,"
                                + "dailyRentalPrice VARCHAR(100) NOT NULL,"
                                + "rentalStartDate DATE NOT NULL,"
                                + "rentalEndDate DATE NOT NULL,"
                                + "totalPrice DOUBLE NOT NULL,"
                                + "constructionSite VARCHAR(50) NOT NULL,"
                                + "phoneSiteEngineer VARCHAR(50) NOT NULL,"
                                + "nameSupplier VARCHAR(50) NOT NULL,"
                                + "employeeID int(15) NOT NULL,"
                                + "PRIMARY KEY(orderNr)"
                                +")";
            stmt.executeUpdate(sql);
                        sql="ALTER TABLE PurchaseOrder "
                                +" ADD FOREIGN KEY(nameSupplier) REFERENCES Supplier (name)"
                                +" ON DELETE RESTRICT ON UPDATE RESTRICT,"
                                +" ADD FOREIGN KEY(employeeID) REFERENCES Employee (employeeID)"
                                +" ON DELETE RESTRICT ON UPDATE RESTRICT";
                        stmt.executeUpdate(sql);
                       
                        sql = "CREATE TABLE Event ("  
                                + "requestNumber int(15) NOT NULL,"
                                + "initiatorID int(15) NOT NULL,"
                                + "date DATE NOT NULL,"
                                + "time TIME NOT NULL,"
                                + "status ENUM('requested', 'processed', 'readyForApproval', 'approved', 'cancelled', 'ordered', 'refused', 'accepted', 'submittedForPayment', 'readyToCancel', 'readyForInvoice') NOT NULL,"
                                + "outcome VARCHAR(50)"
                                + ")";
                        stmt.executeUpdate(sql);
                       
            DBConnector.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}