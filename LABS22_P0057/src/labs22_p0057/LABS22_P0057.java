/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labs22_p0057;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class LABS22_P0057 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        display Display = new display();
        //STEP 1:Display GUI and input Data
        int choice = Display.displayMenu();
        //STEP 2: Perfrom function
        boolean continueProgram = true;
        manageAccount ManageAccount = new manageAccount();
        objectInteract ObjectInterat = new objectInteract();
        ObjectInterat.writeObject(new ArrayList<account>());
        while (continueProgram) {
            switch (choice) {
                //Function 1: Add User
                case 1:
                    ArrayList<account> accountList1 = ObjectInterat.readObject();
                    account newAccount = new account();
                    ManageAccount.addAccount(newAccount, accountList1);
                    ObjectInterat.writeObject(accountList1);
                    break;
                //Function 2: Login
                case 2:
                    ArrayList<account> accountList2 = ObjectInterat.readObject();
                    account loginAccount = ManageAccount.findAccount(new account(), accountList2);
                    Display.displayLoginStatus(loginAccount);
                    break;
                //Exit
                case 3:
                    continueProgram = false;
                    break;
            }
            if (continueProgram) {
                choice = Display.displayMenu();
            }

        }
    }

}
