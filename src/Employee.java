
import java.sql.Connection;
import java.sql.Date;
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
public class Employee {
    
    private int employeeID;
    private Function grp;//subklasses vervangen dit!
    private String emailAdress;
    private String phoneNumber;
    

    public Employee(int employeeID, Function grp, String emailAdress, String phoneNumber) {
        this.employeeID = employeeID;
        this.grp = grp;
        this.emailAdress = emailAdress;
        this.phoneNumber = phoneNumber;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public Function getGroup() {
        return grp;
    }

    public void setGroup(Function grp) {
        this.grp = grp;
    }
    
    public String getEmailAdress() {
        return emailAdress;
    }

    public void setEmailAdress(String emailAdress) {
        this.emailAdress = emailAdress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
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
}
