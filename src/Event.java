import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
 
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
/**
 *
 * @author Jhooster
 */
public class Event {
   
    //private RentalRequest rental;//private String activityType;
    // niet beter request nummer?
    private int requestNumber;
    private String activityType ;
    private int initiatorID;// degene die aanpast
    private LocalDate date;
    private LocalTime time;
    private String outcome;// knop waarop er geklikt wordt
    
   
    private static HashMap<Integer, Integer> requests;
    //private static HashMap<Integer, Employee> employees; // overbodig?

    
 
    

    public Event(int requestNumber, String activityType, int initiatorID, String outcome) {
        //DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
       
        //SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
         LocalTime time = LocalTime.now();
         LocalDate localDate = LocalDate.now();

        //System.out.println(dtf.format(date));
        this.requestNumber = requestNumber;
        this.activityType = activityType;
        this.initiatorID = initiatorID;
        this.outcome = outcome;
       this.date = localDate;
        this.time = time;
    }
   
 
    public void addRequest(int requestNumber){
        requests.put(initiatorID, requestNumber);
    }
   
   /* public void addEmployee(Employee employee){
       
        employees.put(employee.getEmployeeID(), employee);
    }*/

    public int getRequestNumber() {
        return requestNumber;
    }

    public void setRequestNumber(int requestNumber) {
        this.requestNumber = requestNumber;
    }

    public static HashMap<Integer, Integer> getRequests() {
        return requests;
    }

    public static void setRequests(HashMap<Integer, Integer> requests) {
        Event.requests = requests;
    }
 
    public LocalDate getDate() {
        return date;
    }
 
    public void setDate(LocalDate date) {
        this.date = date;
    }
 
    public LocalTime getTime() {
        return time;
    }
 
    public void setTime(LocalTime time) {
        this.time = time;
    }
 
    /*public static HashMap<Integer, Employee> getEmployees() {
        return employees;
    }*/
 
   /* public void setEmployees(HashMap<Integer, Employee> employees) {
        this.employees = employees; 
    }*/

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    

    public void setInitiatorID(int initiatorID) {
        this.initiatorID = initiatorID;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }
 
   
    

    public int getInitiatorID() {
        return initiatorID;
    }

    public String getOutcome() {
        return outcome;
    }
    
    
    public static void saveEvent(Event e) throws DBException{
        Connection con = null;
		try {
                    
			con = DBConnector.getConnection();
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

                        System.out.println("eerste");
                        
			/*String sql = "SELECT date, time "
					+ "FROM Event "
                                        +"WHERE date = " 
                                        + e.getDate().toString()
                                        +" AND time = "+e.getTime().toString();
			//requests.put(e.getInitiatorID(), e.getRequestNumber());
                        
                        System.out.println("tweede");
                        
			ResultSet srs = stmt.executeQuery(sql);
                        System.out.println("aaah kwil dat vinden");
			if (srs.next()) {
				// UPDATE
                                System.out.println("derde");
				sql = "UPDATE Event "
                                                +"SET requestNumber = "+e.getRequestNumber()
						+", activityType = '"+e.getActivityType()+"'"
                                                + ", initiatorID = "+e.getInitiatorID()
                                                +", outcome = '"+e.getOutcome()+"'"  
                                                +" WHERE date = " 
                                                +e.getDate()
                                                +" AND time = "+e.getTime();
				stmt.executeUpdate(sql);
                                System.out.println("vierde");
   
			} else {
				// INSERT
                        */
                                System.out.println("vijfde");
				String sql = "INSERT into Event "
						+ "(date, time, requestNumber, activityType, initatorID, outcome) "
						+ "VALUES ( " +e.getDate()
                                                +", "+e.getTime()
                                                +", "+e.getRequestNumber()
                                                +", '"+e.getActivityType()+"'"
                                                +", "+e.getInitiatorID()
                                                +", '"+e.getOutcome()+"'"
                                        + ")";
						
				stmt.executeUpdate(sql);
                                
			
			
			
			DBConnector.closeConnection(con);
		} catch (Exception ex) {
			ex.printStackTrace();
			DBConnector.closeConnection(con);
			throw new DBException(ex);
		}
   
}
                        /* private RentalRequest rental;//private String activityType;
    // niet beter request nummer?
    private RentalStatus status;
    private int initiatorID;// degene die aanpast
    private LocalDate date;
    private Date time;
    private String outcome;*/
    /*public static String getEventTable() throws DBException, SQLException{//moet aangepast worden aan constructor
            Connection con= null; 
            String re = null;
        try {
            
                con= DBConnector.getConnection();
                Statement stmt= con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
               
                for( int id :Event.getRequests().keySet()){
                String sql = "SELECT date, time, requestNumber, initatorID, activityType, outcome"
					+ "FROM Event "
					+ "WHERE date = " +id ;
                
                ResultSet srs = stmt.executeQuery(sql);

                int requestNumber, initiatorID;
                LocalDate date;
                LocalTime time;
                String status;
                String outcome;
                
                
            
                if (srs.next()){
                    requestNumber = srs.getInt("requestNumber");
                    date=srs.getDate("date").toLocalDate();

                        time= srs.getTime("time").toLocalTime();
                   
                    initiatorID = srs.getInt("initiatorID");
                    status = srs.getString("status");
                    outcome=srs.getString("outcome");
            
                } else {
                    DBConnector.closeConnection(con);
                    return null;
                }
            
            re= requestNumber + "; \n"
                + date + "; \n"
                + time + "; \n"
                + initiatorID + "; \n"
                + status + "; \n"
                + outcome  + "; \n";   
            re+=re;

                }
            DBConnector.closeConnection(con);
        } 
        catch (Exception ex) 
        {
            ex.printStackTrace();
            DBConnector.closeConnection(con);
            throw new DBException(ex);
        }
        return re;
    }
 */   

}