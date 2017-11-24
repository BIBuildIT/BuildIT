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
                                + "number int(11) NOT NULL)";
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
    
    public static void save(Equipment s) throws DBException {
		Connection con = null;
		try {
			con = DBConnector.getConnection();
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

			String sql = "SELECT number "
					+ "FROM Equipment "
					+ "WHERE number = "
					+ s.getNumber();
			ResultSet srs = stmt.executeQuery(sql);
			if (srs.next()) {
				// UPDATE
				sql = "UPDATE Equipment "
						+ "SET number" + s.getNumber();
				stmt.executeUpdate(sql);
			} else {
				// INSERT
				sql = "INSERT into Equipment "
						+ "(number) "
						+ "VALUES (" + s.getNumber()+"')";
						
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
