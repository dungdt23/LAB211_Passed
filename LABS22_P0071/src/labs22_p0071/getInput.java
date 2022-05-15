/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labs22_p0071;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class getInput {

    public getInput() {
    }

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

    public String StringInput(String notice) {

        Scanner sc = new Scanner(System.in);
        String result = null;
        do {
            System.out.print(notice);
            result = sc.nextLine();
            if (!result.isEmpty()) {
                break;
            } else {
                System.out.println("Input can not be empty");
            }
        } while (true);
        return result;
    }

    public int IntegerInput(String notice, int min, int max) {

        Scanner sc = new Scanner(System.in);
        int result = 0;
        String input = null;
        do {
            System.out.print(notice);
            input = sc.nextLine();
            if (input.isEmpty()) {
                System.out.println("Input can not be empty");
                continue;
            }
            try {
                result = Integer.parseInt(input);
                if (result >= min && result <= max) {
                    break;
                } else {
                    System.out.println("Input must be in allowed range");
                }
            } catch (Exception e) {
                System.out.println("Input must be integer");
            }
        } while (true);
        return result;
    }

    public String DateInput(String notice) {

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String inputDate = null;
        //loop until date is right format
        while (true) {
            System.out.print(notice);
            inputDate = this.StringInput("");
            // \d{1,2}: the number have 1 or 2 digit number
            //[-]: have "-"
            //\d{4}: the number must have 4 digit
            if (inputDate.matches("\\d{1,2}[-]\\d{1,2}[-]\\d{4}")) {
                break;
            } else {
                System.out.println("Input must be dd-MM-yyyy");
            }
        }
        return inputDate;

    }

    public String FromPlanInput(String notice) {
        String input = null;
        //loop until input is valid
        while (true) {
            input = this.StringInput(notice);
            //check if input is numeric
            if (this.isNumeric(input)) {
                float temp = Float.valueOf(input);
                //check if digit value of input is in allowed range
                if (temp >= 8 && temp < 17.5) {
                    break;
                } else {
                    System.out.println("Input must be in allowed range");
                }
            } else {
                System.out.println("Input must be numberic");
            }
        }
        return input;
    }

    public String ToPlanInput(String notice, String fromPlan) {
        String input = null;
        //loop until input is valid
        while (true) {
            input = this.StringInput(notice);
            //check if input is numeric
            if (this.isNumeric(input)) {
                float temp = Float.valueOf(input);
                //check if digit value of input is in allowed range
                if (temp > 8 && temp <= 17.5) {
                    if (Float.valueOf(input) > Float.valueOf(fromPlan)) {
                        break;
                    } else {
                        System.out.println("fromPlan must be less than toPlan");
                    }
                } else {
                    System.out.println("Input must be in allowed range");
                }
            } else {
                System.out.println("Input must be numberic");
            }
        }
        return input;
    }

}
