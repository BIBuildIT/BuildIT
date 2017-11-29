import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;

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
    
    private RentalRequest rental;
    private int initiatorID;
    private LocalDate date;
    private Date time;
    // moet wsl nog bij
    private HashMap<Integer, RentalRequest> requests;
    private HashMap<Integer, Employee> employees;

    public Event(RentalRequest rental, int initiatorID) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate localDate = LocalDate.now();
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date time = new Date();

        System.out.println(dateFormat.format(date));
        this.rental = rental;
        this.initiatorID = initiatorID;
        this.date = localDate;
        this.time = time;
        
        
    }

    
  
    public void addRequest(){
        
    }
    
    public void addEmployee(Employee employee){
        
        employees.put(employee.getEmployeeID(), employee);
    }

    public RentalRequest getRental() {
        return rental;
    }

    public void setRental(RentalRequest rental) {
        this.rental = rental;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public HashMap<Integer, Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(HashMap<Integer, Employee> employees) {
        this.employees = employees;
    }

    public HashMap<Integer, RentalRequest> getRequests() {
        return requests;
    }

    public void setRequests(HashMap<Integer, RentalRequest> requests) {
        this.requests = requests;
    }
    
    
}