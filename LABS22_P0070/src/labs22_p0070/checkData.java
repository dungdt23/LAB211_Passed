/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labs22_p0070;

/**
 *
 * @author Admin
 */
public class checkData {

    public checkData() {
    }

    //check if input string is numberic or not
    public boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            float d = Float.parseFloat(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    //check size of input string
    public boolean checkSize(String input, int min, int max) {
        if (input.length() >= min && input.length() <= max) {
            return true;
        } else {
            return false;
        }
    }

    //check if input size must both have alpha and numberic 
    public boolean checkAlphanumeric(String input) {
        //^[a-zA-Z0-9]*: check password start with character a-z A-Z 0-9
        //[a-zA-Z0-9]*$: check password end with character a-z A-Z 0-9
        //([a-zA-Z]+[0-9]+): check password must contain character first, after that is digit
        //[0-9]+[a-zA-Z]+: check password must contain first, after that is character
        String regex = "^[a-zA-Z0-9]*(([a-zA-Z]+[0-9]+)|[0-9]+[a-zA-Z]+)[a-zA-Z0-9]*$";
        boolean result = input.matches(regex);
        return result;
    }

}
