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
    
    public static void save(Student s) throws DBException {
		Connection con = null;
		try {
			con = DBConnector.getConnection();
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

			String sql = "SELECT number "
					+ "FROM Students "
					+ "WHERE number = "
					+ s.getNumber();
			ResultSet srs = stmt.executeQuery(sql);
			if (srs.next()) {
				// UPDATE
				sql = "UPDATE Students "
						+ "SET name = '" + s.getName() + "'"
						+ ", number = " + s.getNumber()
						+ ", GPA = '" + s.getGPA()
						+ "'" + ", fullTime = " + s.isFullTime()
						+ ", commuting = " + s.isCommuting()
						+ ", graduate = " + s.isGraduate()
						+ ", summary = '" + s.getSummary() + "'";
				stmt.executeUpdate(sql);
			} else {
				// INSERT
				sql = "INSERT into Students "
						+ "(number, name, GPA, fullTime, commuting, graduate, summary) "
						+ "VALUES (" + s.getNumber()
						+ ", '" + s.getName() + "'"
						+ ", '" + s.getGPA() + "'"
						+ ", " + s.isFullTime()
						+ ", " + s.isCommuting()
						+ ", " + s.isGraduate()
						+ ", '" + s.getSummary() + "')";
				stmt.executeUpdate(sql);
			}
			// majors
			sql = "DELETE FROM StudentMajors "
					+ "WHERE studentNumber = " + s.getNumber();
			stmt.executeUpdate(sql);
			ArrayList<String> majors = s.getMajors();
			for (int i = 0; i < majors.size(); i++) {
				// indien nodig
                                try {
				sql = "INSERT INTO Majors "
						+ "(name) "
						+ "VALUES ('" + majors.get(i) + "')";
				stmt.executeUpdate(sql);
                                } catch(MySQLIntegrityConstraintViolationException eee) {
                                    //bestond al
                                }
				//voeg student major toe
				sql = "INSERT INTO StudentMajors "
						+ "(studentNumber, majorName) "
						+ "VALUES (" + s.getNumber() + ", '"
						+ majors.get(i) + "')";
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
