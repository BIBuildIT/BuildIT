//import java.sql.Date;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.Instant;
import java.util.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class RentalRequest {
    
    private int requestNumber;
    private LocalDate requestDate;
    
    private LocalDate rentalPeriodStart;
    private LocalDate rentalPeriodEnd;
    private RentalStatus currentStatus;
    private String reasonForCancelationOrRefusal;
    private int employeeID;//MOET altijd siteEngineer zijn
    private String constructionSite;
    
   // private ArrayList<Equipment> equipmentNeeded;
    private Equipment selectedEquipment;//dit String?
    private Supplier selectedSupplier;
    private double dailyRentalPrice;
    private String equipmentType;
    
    


    public RentalRequest(LocalDate rentalPeriodStart, LocalDate rentalPeriodEnd, int employeeID, String constructionSite, String equipmentType) throws DBException {
        ArrayList<RentalRequest> reRe= Getters.getRentalRequests();
        int reqNumber=1;//1 geeft hij niet goed weer!!!!
        
        for(int i=0;i<reRe.size();i++){
            reqNumber=reRe.get(i).getRequestNumber();
        }
        this.requestNumber=reqNumber+10;//moet nog aanpassen, want nu uit lucht gegrepen
        
        this.requestDate = LocalDate.now();
        this.rentalPeriodStart = rentalPeriodStart;
        this.rentalPeriodEnd = rentalPeriodEnd;
       // this.currentStatus= RentalStatus.requested;
        //this.reasonForCancelationOrRefusal = null;
        this.employeeID = employeeID;
        this.constructionSite = constructionSite;
        this.equipmentType = equipmentType;
        


        this.selectedEquipment = null;//vanaf rentalstatus processed
        this.selectedSupplier = null;//vanaf rentalstatus processed
        this.dailyRentalPrice = 0.0;//vanaf rentalstatus processed
        
    }
   

    public RentalRequest(int requestNumber) {
        this.requestNumber = requestNumber;
    }
    // voor de handigheid bij opvragen= getrentalrequest
    
    public int getRequestNumber() {
        return requestNumber;
    }

    public void setRequestNumber(int requestNumber) {
        this.requestNumber = requestNumber;
    }

    public LocalDate getRequestDate() {
        return requestDate;
    }

    public LocalDate getRentalPeriodStart() {
        return rentalPeriodStart;
    }

    public void setRentalPeriodStart(LocalDate rentalPeriodStart) {
        this.rentalPeriodStart = rentalPeriodStart;
    }

    public LocalDate getRentalPeriodEnd() {
        return rentalPeriodEnd;
    }

    public void setRentalPeriodEnd(LocalDate rentalPeriodEnd) {
        this.rentalPeriodEnd = rentalPeriodEnd;
    }

    public RentalStatus getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(RentalStatus currentStatus) {
        this.currentStatus = currentStatus;
    }
    public void setCurrentStatus(String currentStatus) {
        RentalStatus rS= RentalStatus.valueOf(currentStatus);
        this.currentStatus= rS;
        
    }

    public void setRequestDate(LocalDate requestDate) {
        this.requestDate = requestDate;
    }
    

    public String getReasonForCancelationOrRefusal() {
        return reasonForCancelationOrRefusal;
    }

    public void setReasonForCancelationOrRefusal(String reasonForCancelationOrRefusal) {
        this.reasonForCancelationOrRefusal = reasonForCancelationOrRefusal;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getConstructionSite() {
        return constructionSite;
    }

    public void setConstructionSite(String constructionSite) {
        this.constructionSite = constructionSite;
    }

    public Supplier getSelectedSupplier() {
        return selectedSupplier;
    }

    public void setSelectedSupplier(Supplier selectedSupplier) {
        this.selectedSupplier = selectedSupplier;
    }

    public double getDailyRentalPrice() {
        return dailyRentalPrice;
    }

    public void setDailyRentalPrice(double dailyRentalPrice) {
        this.dailyRentalPrice = dailyRentalPrice;
    }

    public String getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(String equipmentType) {
        this.equipmentType = equipmentType;
    }

    public Equipment getSelectedEquipment() {
        return selectedEquipment;
    }

    public void setSelectedEquipment(Equipment selectedEquipment) {
        this.selectedEquipment = selectedEquipment;
    }

    
    public static void saveRR(RentalRequest e) throws DBException{
        Connection con = null;
		try {
                    
			con = DBConnector.getConnection();
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

			String sql = "SELECT requestNumber "
					+ "FROM RentalRequest "
                                        +"WHERE requestNumber = " 
                                        +e.getRequestNumber();
					
                        
                        
			ResultSet srs = stmt.executeQuery(sql);
			if (srs.next()) {
				// UPDATE
				sql = "UPDATE RentalRequest "
						+ "SET requestDate = '"+e.getRequestDate().toString()+"'" 
                                                +", rentalPeriodStart = '"+ e.getRentalPeriodStart().toString()+"'"
                                                +", rentalPeriodEnd = '"+e.getRentalPeriodStart().toString()+"'"
                                                +", rentalStatus = '"+e.getCurrentStatus()+"'"
                                                +", reasonFOrCancellationOrRefusal = '"+e.getReasonForCancelationOrRefusal()+"'"
                                                +", employeeID = "+e.getEmployeeID()+""
                                                +", constructionSite = '"+e.getConstructionSite()+"'"
                                                +", equipmentType = '"+e.getEquipmentType()+"'"
                                                +", selectedEquipment = '"+e.getSelectedEquipment()+"'"
                                                +", selectedSupplier = '"+e.getSelectedSupplier()+"'"
                                                +", dailyRentalPrice = "+e.getDailyRentalPrice()
                                                +" WHERE requestNumber = "+ e.getRequestNumber();
				stmt.executeUpdate(sql);
                                 
			} else {
				// INSERT
				sql = "INSERT into RentalRequest "
						+ "(requestDate, rentalPeriodStart, rentalPeriodEnd, rentalStatus, reasonFOrCancellationOrRefusal, constructionSite, equipmentType, selectedEquipment, selectedSupplier, dailyRentalPrice, employeeID) "
						+ "VALUES ('" +e.getRequestDate().toString()+"'"
                                                +", '"+e.getRentalPeriodStart().toString()+"'"
                                                +", '" +e.getRentalPeriodEnd().toString()+"'"
                                                +", '"+RentalStatus.requested+"'"
                                                +", '"+""+"'"
                                                +", '"+e.getConstructionSite()+"'"
                                                +", '"+e.getEquipmentType()+"'"
                                                +", '"+e.getSelectedEquipment()+"'"
                                                +", '"+e.getSelectedSupplier()+"'"
                                                +", "+e.getDailyRentalPrice()
                                                +", "+e.getEmployeeID()
                                        + ")";
						
				stmt.executeUpdate(sql);
			}
			
			
			DBConnector.closeConnection(con);
		} catch (Exception ex) {
			ex.printStackTrace();
			DBConnector.closeConnection(con);
			throw new DBException(ex);
		}
        
    }
    public static RentalRequest getRentalRequest(int reqnr) throws DBException{//moet aangepast worden aan constructor
            Connection con= null; 
        try {
            
                con= DBConnector.getConnection();
                Statement stmt= con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
                String sql = "SELECT requestNumber, requestDate, rentalPeriodStart, rentalPeriodEnd, rentalStatus, reasonForCancellationOrRefusal, constructionSite, equipmentType, selectedEquipment, selectedSupplier, dailyRentalPrice, employeeID "
					+ "FROM RentalRequest "
					+ "WHERE requestNumber = " + reqnr;
                ResultSet srs = stmt.executeQuery(sql);
     
                
                int requestNumber;
                LocalDate rentalPeriodStart, requestDate;
                LocalDate rentalPeriodEnd;
                int employeeID;
                String constructionSite;
                String rentalStatus, reasonForCancellationOrRefusal;
                //String equipmentType;
                String equipmentType, selectedSupplier, selectedEquipment;
                double dailyRentalPrice;
                
            
                if (srs.next()){
                    requestNumber = srs.getInt("requestNumber");
                    requestDate=srs.getDate("requestDate").toLocalDate();
                    
                    rentalPeriodStart= srs.getDate("rentalPeriodStart").toLocalDate();
                    rentalPeriodEnd = srs.getDate("rentalPeriodEnd").toLocalDate();
                    rentalStatus=srs.getString("rentalStatus");
                    reasonForCancellationOrRefusal=srs.getString("reasonForCancellationOrRefusal");
                             
                    constructionSite = srs.getString("constructionSite");
                    equipmentType= srs.getString("equipmentType");
                    selectedEquipment=srs.getString("selectedEquipment");
                    selectedSupplier=srs.getString("selectedSupplier");
                    dailyRentalPrice=srs.getDouble("dailyRentalPrice");
                    employeeID = srs.getInt("employeeID");
                    
            
                } else {
                    DBConnector.closeConnection(con);
                    return null;
                }
            
            RentalRequest rentalrequest = new RentalRequest( rentalPeriodStart, rentalPeriodEnd, employeeID, constructionSite, equipmentType);
            
            DBConnector.closeConnection(con);
            return rentalrequest;
        }
            catch (Exception ex) {
			ex.printStackTrace();
			DBConnector.closeConnection(con);
			throw new DBException(ex);
                }
        }
    
}
