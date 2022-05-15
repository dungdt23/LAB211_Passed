/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labs22_p0070;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class accountList {

    public accountList() {
    }
    public ArrayList<account> accountList() {
        ArrayList<account> accountList = new ArrayList<>();
        account acc1 = new account("0123456789","123456ab");
        account acc2 = new account("7777777777","1234567810");
        account acc3 = new account("5555555555","1234567810");
        accountList.add(acc1);
        accountList.add(acc2);
        accountList.add(acc3);
        return  accountList;
    }
}
