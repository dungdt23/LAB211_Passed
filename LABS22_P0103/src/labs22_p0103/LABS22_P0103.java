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
public class LABS22_P0103 {

    public static void main(String[] args) {
        getInput getInput = new getInput();
        compare Compare = new compare();
        
        //STEP 1:User enter the first date with [dd/mm/yyyy] format 
        Date firstDate = getInput.getDate("Please enter the first date: ");
        //STEP 2:User enter the second date with [dd/mm/yyyy] format 
        Date secondDate = getInput.getDate("Please enter the second date: ");
        //STEP 3:Compare and display
        Compare.CompareAndDisplay(firstDate, secondDate);
    }

}
