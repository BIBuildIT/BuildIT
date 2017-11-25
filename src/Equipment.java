/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lmoentje
 */
public class Equipment {
    
    //LIJST BIJHOUDEN
    private int code;
    private String type;
    private String description;

    public Equipment() {
    }

    public Equipment(int code, String type, String description) {
        if(code>0 && !(type.isEmpty())&&!(description.isEmpty())){
        this.code = code;
        this.type = type;
        this.description = description;
        }
        else
            System.out.println("Error: wrong syntax");
    }
        

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
    
    
    
}
