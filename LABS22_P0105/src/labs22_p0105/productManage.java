/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labs22_p0105;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import org.xml.sax.ext.DefaultHandler2;

/**
 *
 * @author Admin
 */
public class productManage {
    
    public productManage() {
    }
    
    getInput getInput = new getInput();
    display Display = new display();

    //add StoreKeeper
    public boolean addStoreKeeper(storekeeper storekeeper, ArrayList<storekeeper> storeList) {
        System.out.println("-----Add StoreKeeper -----");
        boolean addStatus = false;
        //set store id
        storekeeper.setStoreID(getInput.StringInput("Enter StoreKeeper ID :"));
        //set store nam
        storekeeper.setStoreName(getInput.StringInput("Enter StoreName :"));
        if (!checkDuplicatedStore(storekeeper, storeList)) {
            storeList.add(storekeeper);
            addStatus = true;
        } else {
            System.out.println("StoreKeeper ID is duplicated. Can't add to the list");
        }
        return addStatus;
    }

    //add product
    public boolean addProduct(product product, ArrayList<storekeeper> storeList, ArrayList<product> productList) {
        System.out.println("-----Add Product -----");
        boolean addStatus = false;
        //check if store list is empty
        if (storeList.isEmpty()) {
            System.out.println("Store List doesn't exist");
            return addStatus;
        } else {
            //set product id
            product.setID(getInput.StringInput("Enter Product ID :"));
            if (checkDuplicatedProduct(product, productList)) {
                System.out.println("Product ID is duplicated. Can't add to the list");
                return false;
            } else {
                product.setName(getInput.StringInput("Enter Product Name :"));
                product.setPrice(getInput.IntegerInput("Enter Product Price :", 0, Integer.MAX_VALUE));
                product.setLocation(getInput.StringInput("Enter Product Location:"));
                product.setStoreKeeper(this.foundStoreKeeper(getInput.StringInput("Enter ID of StoreKeeper :"), storeList, true));
                product.setCategory(getInput.StringInput("Enter Product Category :"));
                product.setDateOfManufacture(getInput.DateInput("Enter Date of Manufacture :"));
                product.setExpiryDate(getInput.DateInput("Enter Expiry Date :"));
                product.setReceiptDate(getInput.DateInput("Enter Receipt Date :"));
                //check if dateOfManufacture is before expiry and receipt date
                if (validateDate(product.getDateOfManufacture(), product.getExpiryDate(), product.getReceiptDate())) {
                    productList.add(product);
                    addStatus = true;
                } else {
                    System.out.println("Date is not valid. Can't update");
                }
            }
            return addStatus;
        }
        
    }

    //update product
    public boolean updateProduct(ArrayList<storekeeper> storeList, ArrayList<product> productList) {
        System.out.println("-----Update Product -----");
        boolean updateStatus = false;
        //get product need to be updated
        product updateProduct = this.foundProduct(getInput.StringInput("Enter Product ID :"), productList);
        //check if product is null
        if (updateProduct == null) {
            System.out.println("Product ID doesn't exist");
            return false;
        } else {
            String oldID = updateProduct.getID();
            updateProduct.setID(getInput.StringInput("Enter Product ID :"));
            if (checkDuplicatedProduct(updateProduct, productList)) {
                System.out.println("Product ID is duplicated. Can't update");
                updateProduct.setID(oldID);
                return false;
            } else {
                LocalDate newManufactureDate = getInput.DateInput("Enter Date of Manufacture :");
                LocalDate newExpiryDate = getInput.DateInput("Enter Expiry Date :");
                LocalDate newReceiptDate = getInput.DateInput("Enter Receipt Date :");
                //check if their date is valid
                if (validateDate(newManufactureDate, newExpiryDate, newReceiptDate)) {
                    updateProduct.setDateOfManufacture(getInput.DateInput("Enter Date of Manufacture :"));
                    updateProduct.setExpiryDate(getInput.DateInput("Enter Expiry Date :"));
                    updateProduct.setReceiptDate(getInput.DateInput("Enter Receipt Date :"));
                    
                    updateProduct.setName(getInput.StringInput("Enter Product Name :"));
                    updateProduct.setPrice(getInput.IntegerInput("Enter Product Price :", 0, Integer.MAX_VALUE));
                    updateProduct.setLocation(getInput.StringInput("Enter Product Location:"));
                    updateProduct.setStoreKeeper(this.foundStoreKeeper(getInput.StringInput("Enter ID of StoreKeeper :"), storeList, true));
                    updateProduct.setCategory(getInput.StringInput("Enter Product Category :"));
                    
                    updateStatus = true;
                } else {
                    System.out.println("Date is not valid. Can't update");
                }
                
            }
            
        }
        return updateStatus;
    }

    //search product
    public ArrayList<product> searchProduct(ArrayList<product> productList) {
        ArrayList<product> foundProductList = null;
        System.out.println("-----Search Product -----");
        System.out.println("1.Search by Name  2.Search by Category  3.Search by StoreKeeperID  4.ReceiptDate");
        int choice = getInput.IntegerInput("Enter your choice :", 1, 4);
        switch (choice) {
            case 1:
                foundProductList = this.foundProducts(1, productList);
                break;
            case 2:
                foundProductList = this.foundProducts(2, productList);
                break;
            case 3:
                foundProductList = this.foundProducts(3, productList);
                break;
            case 4:
                foundProductList = this.foundProducts(4, productList);
                break;
        }
        return foundProductList;
    }

    //sort product
    public ArrayList<product> sortProduct(ArrayList<product> productList) {
        //traverse from first element to before last element
        for (int i = 0; i < productList.size() - 1; i++) {
            //traverse from lastest unsorted to last element
            for (int j = i + 1; j < productList.size(); j++) {
                LocalDate expiryDate1 = productList.get(i).getExpiryDate();
                LocalDate expiryDate2 = productList.get(j).getExpiryDate();
                LocalDate manufacture1 = productList.get(i).getDateOfManufacture();
                LocalDate manufacture2 = productList.get(j).getDateOfManufacture();
                if (expiryDate1.equals(expiryDate2)) {
                    if (manufacture1.compareTo(manufacture2) > 0) {
                        Collections.swap(productList, i, j);
                    }
                } else {
                    if (expiryDate1.compareTo(expiryDate2) > 0) {
                        Collections.swap(productList, i, j);
                    }
                    
                }
            }
        }
        return productList;
    }

    //check duplicate for store
    public boolean checkDuplicatedStore(storekeeper storekeeper, ArrayList<storekeeper> storeList) {
        boolean result = false;
        //traverse from first to last in store list
        for (storekeeper Storekeeper : storeList) {
            if (Storekeeper.getStoreID().equalsIgnoreCase(storekeeper.getStoreID()) && storekeeper != Storekeeper) {
                result = true;
                break;
            }
        }
        return result;
    }

    //check duplicate for product
    public boolean checkDuplicatedProduct(product product, ArrayList<product> productList) {
        boolean result = false;
        //traverse from first to last in product list
        for (product Product : productList) {
            if (Product.getID().equalsIgnoreCase(product.getID()) && Product != product) {
                result = true;
                break;
            }
        }
        return result;
    }

    //get storeKeeper
    public storekeeper foundStoreKeeper(String ID, ArrayList<storekeeper> storeList, boolean returnOption) {
        storekeeper foundStoreKeeper = null;
        boolean checkExist = false;
        while (true) {
            //traverse from first to last in store list
            for (storekeeper StoreKeeper : storeList) {
                if (StoreKeeper.getStoreID().equalsIgnoreCase(ID)) {
                    foundStoreKeeper = StoreKeeper;
                    checkExist = true;
                    break;
                }
            }
            if (checkExist) {
                break;
            } else {
                //check if user want to re-enter store ID
                if (returnOption == false) {
                    break;
                } else {
                    System.out.println("StoreKeeper ID doesn't exist. Enter again: ");
                    ID = getInput.StringInput("Enter ID of StoreKeeper :");
                }
            }
            
        }
        return foundStoreKeeper;
    }

    //get product by ID
    public product foundProduct(String ID, ArrayList<product> productList) {
        product foundProduct = null;
        //traverse from first to last in product list
        for (product Product : productList) {
            //check if input id is same as product id
            if (ID.equalsIgnoreCase(Product.getID())) {
                foundProduct = Product;
                break;
            }
        }
        return foundProduct;
    }

    //get product lists
    public ArrayList<product> foundProducts(int choice, ArrayList<product> productList) {
        ArrayList<product> foundProducts = new ArrayList<>();
        switch (choice) {
            //search by name
            case 1:
                String Name = getInput.StringInput("Enter Name to search :");
                for (product Product : productList) {
                    if (Product.getName().equalsIgnoreCase(Name)) {
                        foundProducts.add(Product);
                    }
                }
                break;
            //search by category
            case 2:
                String Category = getInput.StringInput("Enter Category to search :");
                for (product Product : productList) {
                    if (Product.getCategory().equalsIgnoreCase(Category)) {
                        foundProducts.add(Product);
                    }
                }
                break;
            //search by store id    
            case 3:
                String StoreKeeperID = getInput.StringInput("Enter StoreID to search :");
                for (product Product : productList) {
                    if (Product.getStoreKeeper().getStoreID().equalsIgnoreCase(StoreKeeperID)) {
                        foundProducts.add(Product);
                    }
                }
                break;
            //search by receipt date    
            case 4:
                LocalDate date = getInput.DateInput("Enter receipt date to search :");
                for (product Product : productList) {
                    if (Product.getReceiptDate().equals(date)) {
                        foundProducts.add(Product);
                    }
                }
        }
        return foundProducts;
    }

    //check if date of product is valid or not
    public boolean validateDate(LocalDate date1, LocalDate date2, LocalDate date3) {
        if (date2.compareTo(date1) > 0 && date3.compareTo(date2) <= 0) {
            return true;
        } else {
            return false;
        }
    }
    
}
