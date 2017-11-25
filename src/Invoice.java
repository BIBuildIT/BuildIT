
import java.sql.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lmoentje
 */
public class Invoice {
    private int number;
    private int supplierInvoiceNumber;
    private Date date;
    private String supplier;
    private String purchaseOrder;
    private int equipmentCode;
    //WAAROM NIET GEWOON 'CODE' ZETTEN?
    private Date rentalPeriodStart;
    //DATUM?
    private Date rentalPeriodEnd;
    private double price;
    private String nameSupplier;
    //WAAROM NIET GEWOON 'NAME'

    public Invoice(int number, int supplierInvoiceNumber, Date date, String supplier, String purchaseOrder, int equipmentCode, Date rentalPeriodStart, Date rentalPeriodEnd, double price, String nameSupplier) {
        this.number = number;
        this.supplierInvoiceNumber = supplierInvoiceNumber;
        this.date = date;
        this.supplier = supplier;
        this.purchaseOrder = purchaseOrder;
        this.equipmentCode = equipmentCode;
        this.rentalPeriodStart = rentalPeriodStart;
        this.rentalPeriodEnd = rentalPeriodEnd;
        this.price = price;
        this.nameSupplier = nameSupplier;
        //OOK MET IF EN ELSE WERKEN?!
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getSupplierInvoiceNumber() {
        return supplierInvoiceNumber;
    }

    public void setSupplierInvoiceNumber(int supplierInvoiceNumber) {
        this.supplierInvoiceNumber = supplierInvoiceNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getPurchaseOrder() {
        return purchaseOrder;
    }

    public void setPurchaseOrder(String purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }

    public int getEquipmentCode() {
        return equipmentCode;
    }

    public void setEquipmentCode(int equipmentCode) {
        this.equipmentCode = equipmentCode;
    }

    public Date getRentalPeriodStart() {
        return rentalPeriodStart;
    }

    public void setRentalPeriodStart(Date rentalPeriodStart) {
        this.rentalPeriodStart = rentalPeriodStart;
    }

    public Date getRentalPeriodEnd() {
        return rentalPeriodEnd;
    }

    public void setRentalPeriodEnd(Date rentalPeriodEnd) {
        this.rentalPeriodEnd = rentalPeriodEnd;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getNameSupplier() {
        return nameSupplier;
    }

    public void setNameSupplier(String nameSupplier) {
        this.nameSupplier = nameSupplier;
    }
    
    
    
    
}
