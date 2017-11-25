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
        if(name.isEmpty()  || email.isEmpty() || phoneNumber.isEmpty()){
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
    
    
    
}
