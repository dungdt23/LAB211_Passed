/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labs22_p0102;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class LABS22_P0102 {
    
    public static void main(String[] args) {
        getInput getInput = new getInput();
        findDay findDay = new findDay();
       
        //STEP 1: User enter date with [dd/mm/yyyy] format
        String inputDate = getInput.inputDateWithFormat();
        
        //STEP 2: Check user input date exits
        boolean checkExistDate = getInput.checkDateExist(inputDate);
        
        //STEP 3: Determine day of week with input date if it exist
        findDay.dayOfWeek(inputDate, checkExistDate);
    }
    
}
