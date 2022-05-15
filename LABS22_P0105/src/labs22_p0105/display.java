/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labs22_p0105;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class display {

    public display() {
    }

    //display Menu
    public int displayMenu() {
        System.out.println("1.  Add Storekeeper");
        System.out.println("2.  Add product");
        System.out.println("3.  Update product");
        System.out.println("4.  Search product by Name, Category, Storekeeper, ReceiptDate");
        System.out.println("5.  Sort product by Expiry date, Date of manufacture");
        System.out.println("6.  Exit");
        getInput getInput = new getInput();
        int choice = getInput.IntegerInput("Enter youir choice :", 1, 6);
        return choice;
    }

    public void displayStatus(boolean status) {
        if (status) {
            System.out.println("Successfully");
        } else {
            System.out.println("Unsuccessfully");
        }
    }

    public void displayProductList(ArrayList<product> list) {
        if (list.isEmpty()) {
            System.out.println("Not found");
            return;
        } else {
            System.out.format(" %-10s %-10s %-10s   %-10s  %-15s %-10s %-10s %-10s %-10s %-10s ", "ID", "Name", "Location", "Price", "ExpiryDate", "DateOfManufacture", "Category", "StoreKeeper", "StoreKeeper", "ReceiptDate");
            for (product product : list) {
                System.out.println("");
                product.display();
            }
        }
        System.out.println("");
    }
}
