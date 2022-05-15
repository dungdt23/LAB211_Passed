/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labs22_p0059;

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
        boolean continueInput = true;
        do {
            System.out.print(notice);
            result = sc.nextLine();
            if (!result.isEmpty()) {
                break;
            } else {
                System.out.println("Input can not be empty");
            }
        } while (continueInput);
        return result;
    }

    public int IntegerInput(String notice, int min, int max) {
        System.out.print(notice);
        Scanner sc = new Scanner(System.in);
        int result = 0;
        String input = null;
        do {
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
                    System.out.println("Input must be in the allowed range");
                }
            } catch (Exception e) {
                System.out.println("Input must be integer");
            }
        } while (true);
        return result;
    }

    public double DoubleInput(String notice, double min, double max) {
        System.out.print(notice);
        Scanner sc = new Scanner(System.in);
        double result = 0;
        String input = null;
        do {
            input = sc.nextLine();
            if (input.isEmpty()) {
                System.out.println("Input can not be empty");
                continue;
            }
            try {
                result = Double.valueOf(input);
                if (result >= min && result <= max) {
                    break;
                } else {
                    System.out.println("Input must be in the allowed range");
                }
            } catch (Exception e) {
                System.out.println("Input must be integer");
            }
        } while (true);
        return result;
    }

}
