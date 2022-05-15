/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labs22_p0103;

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

    public String StringInput(String notice) {
        Scanner sc = new Scanner(System.in);
        String result = null;
        //loop until finish input string
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

    public Date getDate(String notice) {
        boolean existDate = false;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        //set date when parsing not to be lenient
        dateFormat.setLenient(false);
        Date DateOutput = null;
        String inputDate = this.StringInput(notice);;
        while (true) {
            /*  \d{1,2}: the number have 1 or 2 digit number
            [/]: contain character /
            \d{4}: the number must have 4 digit       */
            if (!inputDate.matches("\\d{1,2}[/]\\d{1,2}[/]\\d{4}")) {
                System.out.println("Input is wrong format date");
            } else {
                try {
                    DateOutput = dateFormat.parse(inputDate);
                    existDate = true;
                    break;
                } catch (Exception e) {
                    System.out.println("Date doesn't existed!!");
                }
            }
            if (!existDate) {
                inputDate = this.StringInput(notice);
            }
        }
        return DateOutput;
    }

}
