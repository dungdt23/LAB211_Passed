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
public class login {

    public login() {

    }

    //get login account
    public String accountLogin(ResourceBundle convertLanguage, ArrayList<account> accountList) {
        boolean result = true;
        language Language = new language();
        getData getData = new getData();
        String notice1 = convertLanguage.getString("accountNumber");
        String notice2 = convertLanguage.getString("inputAcountError");
        String account = getData.accountInput(notice1, notice2);

        return account;
    }

    //get login password
    public String passwordLogin(ResourceBundle convertLanguage) {
        language Language = new language();
        getData getData = new getData();
        String notice1 = convertLanguage.getString("password");
        String notice2 = convertLanguage.getString("inputPasswordError");
        String password = getData.passwordInput(notice1, notice2);
        return password;
    }

    //check captcha login
    public boolean captchaLogin(ResourceBundle convertLanguage) {
        boolean result = true;
        language Language = new language();
        getData getData = new getData();
        String notice = convertLanguage.getString("Capcha");
        String captcha = getData.captchaGenerate(notice);
        String notice1 = convertLanguage.getString("inputCapcha");
        String notice2 = convertLanguage.getString("CapchaError");
        String inputCaptcha = getData.StringInput(notice1);
        if (!inputCaptcha.equals(captcha)) {
            System.out.println(notice2);
            result = false;
        }
        return result;
    }

    //check status of login
    public boolean loginStatus(String account, String password, boolean captchaLogin, ArrayList<account> accountList) {
        boolean accStatus = this.checkAccount(account, password, accountList);
        boolean result = false;
        //check if account is corret and captcha is correct 
        if (accStatus && captchaLogin) {
            result = true;
        }
        return result;
    }

    //check valid of account
    public boolean checkAccount(String account, String password, ArrayList<account> accountList) {
        boolean result = false;
        //traverse from first to last element in account list
        for (account acc : accountList) {
            //check if both account number and password is correct
            if (acc.getAccountNumber().equals(account) && acc.getPassword().equals(password)) {
                result = true;
            }
        }
        return result;
    }
}
