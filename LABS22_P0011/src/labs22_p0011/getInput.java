/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labs22_p0011;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class getInput {

    public getInput() {
    }

    //Get base number input 
    public int baseNumberInput() {
        System.out.println("Choose base number input : 1.Binary 2.Decimal 3.Hexadecimal");
        Scanner sc = new Scanner(System.in);
        boolean continueProgram = true;
        int baseNumberInput = 0;
        int result = -1;
        //Loop until get valid base number input
        while (continueProgram) {
            try {
                baseNumberInput = Integer.parseInt(StringInput());
                if (baseNumberInput < 1 || baseNumberInput > 3) {
                    System.out.println("Input must be in 1-3");
                } else {
                    switch (baseNumberInput) {
                        case 1:
                            result = 2;
                            break;
                        case 2:
                            result = 10;
                            break;
                        case 3:
                            result = 16;
                            break;
                    }
                    continueProgram = false;
                }
            } catch (Exception e) {
                System.out.println("Input must be integer");
            }
        }
        return result;
    }

    //Get base number output
    public int baseNumberOutput() {
        System.out.println("Choose base number output : 1.Binary 2.Decimal 3.Hexadecimal");
        Scanner sc = new Scanner(System.in);
        boolean continueProgram = true;
        int result = -1;
        //Loop until get valid base number output
        while (continueProgram) {
            try {
                int baseNumberOutput = Integer.parseInt(StringInput());
                if (baseNumberOutput < 1 || baseNumberOutput > 3) {
                    System.out.println("Input must be in 1-3");
                } else {
                    switch (baseNumberOutput) {
                        case 1:
                            result = 2;
                            break;
                        case 2:
                            result = 10;
                            break;
                        case 3:
                            result = 16;
                            break;
                    }
                    continueProgram = false;
                }
            } catch (Exception e) {
                System.out.println("Input must be integer");
            }
        }
        return result;
    }

    //Get value need to be converted
    public String getValue() {
        System.out.println("Enter value: ");
        Scanner sc = new Scanner(System.in);
        String result = null;
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

    public String StringInput() {
        Scanner sc = new Scanner(System.in);
        String result = null;
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

    public int IntegerInputMenu(String notice, int min, int max) {
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
                    System.out.println("The selection must be in the allowed range");
                }
            } catch (Exception e) {
                System.out.println("Input must be integer");
            }
        } while (true);
        return result;
    }

}
