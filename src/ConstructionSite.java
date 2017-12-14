
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
public class ConstructionSite {
    
    private String address;

    public ConstructionSite(String address) {
        this.address = address;
    }

    public String getaddress() {
        return address;
    }

    public void setaddress(String address) {
        this.address = address;
    }
    
        public static ArrayList<ConstructionSite> getConstructionSites() throws DBException {
        Connection con= null;
        try {
            con= DBConnector.getConnection();
            Statement stmt= con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            String sql= "SELECT address "
                       +"FROM ConstructionSite";
            ResultSet srs= stmt.executeQuery(sql);
            
            ArrayList<ConstructionSite> constructionsites= new ArrayList<>();
            while(srs.next())
                constructionsites.add(new ConstructionSite(srs.getString("address")));
            
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
