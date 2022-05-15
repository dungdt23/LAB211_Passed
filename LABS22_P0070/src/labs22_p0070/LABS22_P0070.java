/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labs22_p0070;

import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 *
 * @author Admin
 */
public class LABS22_P0070 {

    public static void LoginSystem() {

        //Function 1: Display a menu and ask users to select an option
        display Display = new display();
        int choice = Display.displayMenu();
        //Function 2: Perform language based on the selected option
        boolean continueProgram = true;
        accountList accList = new accountList();
        language Language = new language();
        login loginSystem = new login();
        ArrayList<account> accountList = accList.accountList();
        while (continueProgram) {
            switch (choice) {
                //Option 3: exit program
                case 3:
                    continueProgram = false;
                    break;
                //Other option: Implement login    
                default:
                    //Step 1: Convert language
                    ResourceBundle convertLanguage = Language.convertLanguage(choice);
                    //Step 1: Checking account number
                    String checkAccountNumber = loginSystem.accountLogin(convertLanguage, accountList);
                    //Step 2: Check the password
                    String checkPassword = loginSystem.passwordLogin(convertLanguage);
                    //Step 4: Check the captcha code
                    boolean checkCaptcha = loginSystem.captchaLogin(convertLanguage);
                    //Step 5: Login 
                    boolean loginStatus = loginSystem.loginStatus(checkAccountNumber, checkPassword, checkCaptcha, accountList);
                    Display.displayLoginStatus(loginStatus, convertLanguage);
                    break;
            }
            if (continueProgram) {
                choice = Display.displayMenu();
            }
        }

    }

    public static void main(String[] args) {
        LoginSystem();
    }

}
