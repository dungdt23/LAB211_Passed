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
public class manageAccount {

    getInput getInput = new getInput();

    public manageAccount() {
    }

    // Add User
    public void addAccount(account acc, ArrayList<account> accountList) {
        //check if accountList is exist
        if (accountList == null) {
            return;
        }
        //set username
        acc.setUsername(getInput.LoginInput("Enter Username: ", 1));
        //set password
        acc.setPassword(getInput.LoginInput("Enter Password : ", -1));
        if (!checkexistedAccount(acc, accountList)) {
            accountList.add(acc);
            System.out.println("Create new account successfully!");

        } else {
            System.out.println("Unsuccessful! Username is not allowed to coincide with the existing username in the database");
        }
    }

    //Find account ( login )
    public account findAccount(account acc, ArrayList<account> accountList) {
        account foundAccount = new account();
        //check if accountList is exist
        if (accountList == null) {
            foundAccount = null;
        } else {
            //set username
            acc.setUsername(getInput.LoginInput("Enter Username: ", 1));
            //set password
            acc.setPassword(getInput.LoginInput("Enter Password : ", -1));
            //check if account is existed
            if (loginCheck(acc, accountList)) {
                foundAccount = acc;
            }
            else
                foundAccount.setUsername("");
        }
        return foundAccount;
    }

    //check if account is existed
    public boolean checkexistedAccount(account acc, ArrayList<account> accountList) {
        boolean result = false;
        for (account Account : accountList) {
            if (Account.getUsername().equals(acc.getUsername())) {
                result = true;
                break;
            }
        }
        return result;
    }

    //check login
    public boolean loginCheck(account acc, ArrayList<account> accountList) {
        boolean result = false;
        for (account Account : accountList) {
            if (Account.getUsername().equals(acc.getUsername()) && Account.getPassword().equals(acc.getPassword())) {
                result = true;
                break;
            }
        }
        return result;
    }
}
