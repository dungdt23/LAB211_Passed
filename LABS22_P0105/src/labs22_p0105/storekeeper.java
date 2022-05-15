/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labs22_p0105;

/**
 *
 * @author Admin
 */
public class storekeeper {

    private String storeID;
    private String storeName;

    public storekeeper() {
    }

    public storekeeper(String storeID, String storeName) {
        this.storeID = storeID;
        this.storeName = storeName;
    }

    public String getStoreID() {
        return storeID;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreID(String storeID) {
        this.storeID = storeID;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    @Override
    public String toString() {
        return "StoreID:    " + storeID + "       StoreName :  " + storeName ;
    }


}
