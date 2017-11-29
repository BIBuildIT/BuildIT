
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author swornoo
 */
public class Getters {

    public Getters() {
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
        
        public static Employee getEmployee(int eID) throws DBException {
        Connection con= null; 
        try {
            
                con= DBConnector.getConnection();
                Statement stmt= con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
                String sql = "SELECT employeeID, function, emailAdress, phoneNumber "
					+ "FROM Employee "
					+ "WHERE EmployeeID = " + eID;
                ResultSet srs = stmt.executeQuery(sql);
                String function, emailAdress, phoneNumber;
                int employeeID;
            
            
                if (srs.next()){
                    employeeID = srs.getInt("employeeID");
                    function = srs.getString("function");
                    emailAdress = srs.getString("emailAdress");
                    phoneNumber = srs.getString("phoneNumber");
            } else {
                    DBConnector.closeConnection(con);
                    return null;
                }
            
            Employee employee = new Employee(employeeID,function,emailAdress,phoneNumber);
            
            DBConnector.closeConnection(con);
            return employee;
        }
            catch (Exception ex) {
			ex.printStackTrace();
			DBConnector.closeConnection(con);
			throw new DBException(ex);
                }
            
        }
        
        public static RentalRequest getRentalRequest(int reqnr) throws DBException{
            Connection con= null; 
        try {
            
                con= DBConnector.getConnection();
                Statement stmt= con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
                String sql = "SELECT requestNumber, rentalPeriodStart, rentalPeriodEnd, requestor, constructionSite, equipmentType, selectedEquipment"
					+ "FROM RentalRequest "
					+ "WHERE requestNumber = " + reqnr;
                ResultSet srs = stmt.executeQuery(sql);
     
                
                int requestNumber;
                Date rentalPeriodStart;
                Date rentalPeriodEnd;
                SiteEngineer requestor;
                ConstructionSite constructionSite;
                String equipmentType;
                Equipment selectedEquipment;
                
            
                if (srs.next()){
                    requestNumber = srs.getInt("requestNumber");
                    rentalPeriodStart = srs.getDate("rentalPeriodStart");
                    rentalPeriodEnd = srs.getDate("rentalPeriodEnd");
                    requestor = new SiteEngineer(); //hier moeten nog constructors komen maar ik weet niet goed hoe?
                    constructionSite = new ConstructionSite(srs.getString("constructionSite"));
                    equipmentType = srs.getString("equipmentType");
                    
            
                } else {
                    DBConnector.closeConnection(con);
                    return null;
                }
            
            RentalRequest rentalrequest = new RentalRequest(requestNumber, rentalPeriodStart, rentalPeriodEnd, requestor, constructionSite, equipmentType);
            
            DBConnector.closeConnection(con);
            return rentalrequest;
        }
            catch (Exception ex) {
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
    
    
    public static ArrayList<ConstructionSite> getConstructionSites() throws DBException {
        Connection con= null;
        try {
            con= DBConnector.getConnection();
            Statement stmt= con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            String sql= "SELECT adress"
                       +"FROM ConstructionSite";
            ResultSet srs= stmt.executeQuery(sql);
            
            ArrayList<ConstructionSite> constructionsites= new ArrayList<>();
            while(srs.next())
                constructionsites.add(new ConstructionSite(srs.getString("adress")));
            
            DBConnector.closeConnection(con);
            return constructionsites;
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
