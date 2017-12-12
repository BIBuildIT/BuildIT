
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lmoentje
 */
public class Supplier {
    private String name;
    private String email;
    private String phoneNumber;

    public Supplier(String name, String email, String phoneNumber) {
        if(name.isEmpty()  || email.isEmpty() || phoneNumber.isEmpty()|| (phoneNumber.length())!=10){
            System.out.println("Error: wrong syntax.");
        }
        else{
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        }
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
 // methode getsupplier bestaat nog niet? 
   /* public static ArrayList<Supplier> getSuppliers() throws DBException {
        Connection con= null;
        try {
            con= DBConnector.getConnection();
            Statement stmt= con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            String sql= "SELECT bame "
                       +"FROM Supplier";
            ResultSet srs= stmt.executeQuery(sql);
            
            ArrayList<Supplier> suppliers= new ArrayList<>();
            while(srs.next())
                suppliers.add(Supplier.getSupplier(srs.getInt("name")));
            
            DBConnector.closeConnection(con);
            return suppliers;
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
    */ 
    
     public static Supplier getSupplier(String supplierName) throws DBException {
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
    
    
    
}
