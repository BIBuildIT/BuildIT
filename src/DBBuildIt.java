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


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

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
			String sql = "CREATE TABLE Equipment ()";
			stmt.executeUpdate(sql);
			sql = "CREATE TABLE Depot ()";
			stmt.executeUpdate(sql);
			sql = "CREATE TABLE Supplier ()";
			stmt.executeUpdate(sql);
                        sql = "CREATE TABLE Invoice ()";
			stmt.executeUpdate(sql);
                        sql = "CREATE TABLE PurchaseOrder ()";
			stmt.executeUpdate(sql);
                        sql = "CREATE TABLE Request ()";
			stmt.executeUpdate(sql);
                        
			DBConnector.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
    
}
