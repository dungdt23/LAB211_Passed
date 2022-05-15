/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labs22_p0103;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class compare {

    public compare() {
    }

    public void CompareAndDisplay(Date firstDate, Date secondDate) {
        if (firstDate.before(secondDate)) {
            System.out.println("");
            System.out.println("Date1 is before Date2");
        } else {
            if (firstDate.after(secondDate)) {
                System.out.println("");
                System.out.println("Date1 is after Date2");
            } else {
                System.out.println("");
                System.out.println("Date1 is same as  Date2");
            }
        }

    }
}
