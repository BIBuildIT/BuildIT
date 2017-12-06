/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jhooster
 */
public class Clerk extends Employee {
    
    public Clerk(int employeeID, String emailAdress, String phoneNumber) {
        super(employeeID, Function.Clerk, emailAdress, phoneNumber);
    }
    
  /*  public void requestStatusAanpassen(RentalStatus currentStatus, RentalRequest request) { //werken met requestNumber ipv request
        if (request.getCurrentStatus().equals(RentalStatus.requested) && (currentStatus.equals(RentalStatus.processed))) {
            request.setCurrentStatus(RentalStatus.processed);
            //nu zou methode processed moeten gebeuren, maar we weten niet hoe
                 
        }
        if (request.getCurrentStatus().equals(RentalStatus.processed)&&(currentStatus.equals(RentalStatus.readyForApproval))){
            request.setCurrentStatus(RentalStatus.readyForApproval);
        }
        
        if (request.getCurrentStatus().equals(RentalStatus.accepted)&&(currentStatus.equals(RentalStatus.submittedForPayment))){
            request.setCurrentStatus(RentalStatus.submittedForPayment);
        }
        
        else System.exit(0);
        
    }
    
    public void processed(Equipment selectedEquipment, Supplier selectedSupplier, double dailyRentalPrice, RentalRequest request){
        request.setSelectedEquipment(selectedEquipment);
        request.setSelectedSupplier(selectedSupplier);
        request.setDailyRentalPrice(dailyRentalPrice);
        
    }
    // methodes: aanvullen*/
}
