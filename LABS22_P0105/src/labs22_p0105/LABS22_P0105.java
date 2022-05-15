/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labs22_p0105;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class LABS22_P0105 {

    public static void productManage() {
        display Display = new display();
        getInput getInput = new getInput();
        boolean continueProgram = true;
        productManage productManage = new productManage();
        ArrayList<storekeeper> storeList = new ArrayList<>();
        ArrayList<product> productList = new ArrayList<>();
        //DATA TEST
//        storekeeper storekeeper1 = new storekeeper("s1", "Alex");
//        storekeeper storekeeper2 = new storekeeper("s2", "Bruno");
//        storekeeper storekeeper3 = new storekeeper("s3", "Chris");
//        storeList.add(storekeeper1);
//        storeList.add(storekeeper2);
//        storeList.add(storekeeper3);
//        LocalDate date1 = LocalDate.parse("2007-12-12");
//        LocalDate date2 = LocalDate.parse("2007-10-12");
//        LocalDate date3 = LocalDate.parse("2007-12-31");
//        LocalDate date4 = LocalDate.parse("2007-12-20");
//        LocalDate date5 = LocalDate.parse("2007-12-25");
//        product product1 = new product("p1", "apple", "hanoi", 20000, date1, date2, "fruit", storekeeper1, date3);
//        product product2 = new product("p2", "snack", "phutho", 25000, date2, date1, "food", storekeeper2, date4);
//        product product3 = new product("p3", "candy", "hanoi", 10000, date3, date4, "food", storekeeper3, date5);
//        product product4 = new product("p4", "pant", "vinhphuc", 220000, date1, date3, "clothers", storekeeper2, date3);
//        product product5 = new product("p5", "orange", "hanoi", 30000, date3, date4, "fruit", storekeeper3, date5);
//        productList.add(product1);
//        productList.add(product2);
//        productList.add(product3);
//        productList.add(product4);
//        productList.add(product5);
        //
        //STEP 1: Display a menu and ask users to select an option 
        int choice = Display.displayMenu();
        //STEP 2: Implement function 
        while (continueProgram) {
            switch (choice) {
                //Option 1: Add Storekeeper
                case 1:
                    storekeeper newStoreKeeper = new storekeeper();
                    boolean addStoreKeeperStatus = productManage.addStoreKeeper(newStoreKeeper, storeList);
                    Display.displayStatus(addStoreKeeperStatus);
                    break;
                //Option 2: Add product: all property are required
                case 2:
                    product newProduct = new product();
                    boolean addProductStatus = productManage.addProduct(newProduct, storeList, productList);
                    Display.displayStatus(addProductStatus);
                    break;
                //Option 3: Update product: Find product by Id
                case 3:
                    boolean updateProductStatus = productManage.updateProduct(storeList, productList);
                    Display.displayStatus(updateProductStatus);
                    break;
                //Option 4: Search product by Name, Category, Storekeeper, ReceiptDate
                case 4:
                    ArrayList<product> foundProducts = productManage.searchProduct(productList);
                    Display.displayProductList(foundProducts);
                    break;
                //Option 5: Sort product by Expiry date, Date of manufacture
                case 5:
                    ArrayList<product> sortedProducts = productManage.sortProduct(productList);
                    Display.displayProductList(sortedProducts);
                    break;
                case 6:
                    continueProgram = false;
                    break;

            }
            if (continueProgram) {
                choice = Display.displayMenu();
            }
        }
    }

    public static void main(String[] args) {
         productManage();

    }

}
