/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labs22_p0105;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class product {

    private String ID;
    private String Name;
    private String Location;
    private int Price;
    private LocalDate ExpiryDate;
    private LocalDate DateOfManufacture;
    private String Category;
    private storekeeper StoreKeeper;
    private LocalDate ReceiptDate;

    public product() {
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public String getLocation() {
        return Location;
    }

    public int getPrice() {
        return Price;
    }

    public LocalDate getExpiryDate() {
        return ExpiryDate;
    }

    public LocalDate getDateOfManufacture() {
        return DateOfManufacture;
    }

    public String getCategory() {
        return Category;
    }

    public storekeeper getStoreKeeper() {
        return StoreKeeper;
    }

    public LocalDate getReceiptDate() {
        return ReceiptDate;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }

    public void setExpiryDate(LocalDate ExpiryDate) {
        this.ExpiryDate = ExpiryDate;
    }

    @Override
    public String toString() {
        return "ID: " + ID + "      Name:" + Name + "       Location:" + Location + "        Price:" + Price + "        ExpiryDate:" + ExpiryDate + "       DateOfManufacture:" + DateOfManufacture + "     Category:" + Category + "       StoreKeeper:" + StoreKeeper + "     ReceiptDate:" + ReceiptDate;
    }

    public void display() {
        System.out.format(" %-10s |%-10s |%-10s |%-10d |%-15s |%-10s       |%-10s |%-10s |%-10s |%-10s ", ID, Name, Location, Price, ExpiryDate.toString(), DateOfManufacture.toString(), Category, StoreKeeper.getStoreID(), StoreKeeper.getStoreName(), ReceiptDate.toString());
    }

    public void setDateOfManufacture(LocalDate DateOfManufacture) {
        this.DateOfManufacture = DateOfManufacture;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }

    public void setStoreKeeper(storekeeper StoreKeeper) {
        this.StoreKeeper = StoreKeeper;
    }

    public void setReceiptDate(LocalDate ReceiptDate) {
        this.ReceiptDate = ReceiptDate;
    }

    public product(String ID, String Name, String Location, int Price, LocalDate ExpiryDate, LocalDate DateOfManufacture, String Category, storekeeper StoreKeeper, LocalDate ReceiptDate) {
        this.ID = ID;
        this.Name = Name;
        this.Location = Location;
        this.Price = Price;
        this.ExpiryDate = ExpiryDate;
        this.DateOfManufacture = DateOfManufacture;
        this.Category = Category;
        this.StoreKeeper = StoreKeeper;
        this.ReceiptDate = ReceiptDate;
    }

}
