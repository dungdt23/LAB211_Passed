/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labs22_p0063;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class getInput {

    public getInput() {
    }

    public String StringInput(String notice) {
        System.out.print(notice);
        Scanner sc = new Scanner(System.in);
        String result = null;
        //loop until finish input string
        do {
            result = sc.nextLine();
            if (!result.isEmpty()) {
                break;
            } else {
                System.out.println("Input can not be empty");
            }
        } while (true);
        return result;
    }

    public double SalaryInput(String notice) {
        Scanner sc = new Scanner(System.in);
        double salaryOutput = 0;
        String input = null;
        //loop until finish input double
        do {
            System.out.print(notice);
            input = sc.nextLine();
            if (input.isEmpty()) {
                System.out.println("Input can not be empty");
                continue;
            }
            try {
                salaryOutput = Double.parseDouble(input);
                if (salaryOutput >= 0) {
                    break;
                } else {
                    System.out.println("Salary is greater than zero");
                }
            } catch (Exception e) {
                System.out.println("You must input digit.");
            }
        } while (true);
        return salaryOutput;
    }
}
