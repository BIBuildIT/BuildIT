
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lmoentje
 */
public class Saves {
    
    public static void save(Equipment e) throws DBException {
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
    /*"CREATE TABLE Employee ("
                                + "employeeID int(15) NOT NULL AUTO_INCREMENT,"
                                + "function VARCHAR(50) NOT NULL,"
                                + "emailAdress VARCHAR(50) NOT NULL,"
                                + "phoneNumber VARCHAR(50) NOT NULL,"
                                + "adressConstructionSite VARCHAR(50) NOT NULL,"
                                + "PRIMARY KEY(employeeID)"+")";*/
    
    public static void saveE(Employee e) throws DBException {
		Connection con = null;
		try {
                    
			con = DBConnector.getConnection();
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

			String sql = "SELECT EmployeeID "
					+ "FROM Employee "
                                        +"WHERE EMployeeID = " 
                                        +e.getEmployeeID();
					
			ResultSet srs = stmt.executeQuery(sql);
			if (srs.next()) {
				// UPDATE
				sql = "UPDATE Employee "
						+ "SET function = '"+ e.getFunction()+"'"
                                                +"' emailAdress = '"+e.getEmailAdress()+"'"
                                                +", phoneNumber = '"+ e.getPhoneNumber()+"'"
                                               
                                                +" WHERE EmployeeID = "+ e.getEmployeeID();
				stmt.executeUpdate(sql);
			} else {
				// INSERT
				sql = "INSERT into Employee "
						+ "(EmployeeID , function, emailAdress, phoneNumber) "
						+ "VALUES (" + e.getEmployeeID()
                                                +", '"+e.getFunction()+ "'"
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
	}
    
    
}
