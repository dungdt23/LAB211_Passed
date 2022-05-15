/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labs22_p0070;

import java.util.ResourceBundle;

/**
 *
 * @author Admin
 */
public class display {
    
    public display() {
    }
    
    public int displayMenu() {
        getData getData = new getData();
        System.out.println("------- Login Program -------");
        System.out.println("1. Vietnamese");
        System.out.println("2. English");
        System.out.println("3. Exit");
        int choice = getData.IntegerInput("Please choice one option:", 1, 3);
        return choice;
    }
    
    public void displayLoginStatus(boolean status, ResourceBundle convertLanguage) {
        if (status) {
            System.out.println(convertLanguage.getString("loginSuccess"));
        } else {
            System.out.println(convertLanguage.getString("loginFail"));
        }
    }
}
