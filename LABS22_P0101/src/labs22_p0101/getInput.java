/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labs22_p0101;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

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

    public String EmailInput(String notice) {
        System.out.print(notice);
        Scanner sc = new Scanner(System.in);
        String result = null;
        do {
            result = sc.nextLine();
            if (!this.checkEmail(result, "^(.+)@(\\S+)$")) {
                System.out.println("This is not an email");
                continue;
            }
            if (!result.isEmpty()) {
                break;
            } else {
                System.out.println("Input can not be empty");
            }
        } while (true);
        return result;
    }

    public String GenderInput(String notice) {
        System.out.print(notice);
        Scanner sc = new Scanner(System.in);
        String result = null;
        do {
            result = sc.nextLine();
            if (!this.checkGender(result)) {
                System.out.println("It has to be Male or Female");
                continue;
            }
            if (!result.isEmpty()) {
                break;
            } else {
                System.out.println("Input can not be empty");
            }
        } while (true);
        return result;
    }

    public int IntegerInput(String notice) {
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
                if (result >= 0) {
                    break;
                } else {
                    System.out.println("Input must be great or equal to 0");
                }
            } catch (Exception e) {
                System.out.println("Input must be integer");
            }
        } while (true);
        return result;
    }

    public String InputDOB(String notice) {
        System.out.print(notice);
        Scanner sc = new Scanner(System.in);
        String result = null;
        String input = null;
        do {
            input = sc.nextLine();
            if (input.isEmpty()) {
                System.out.println("Input can not be empty");
                continue;
            }
            try {
                LocalDate dob = LocalDate.parse(input);
                result = dob.toString();
                break;
            } catch (Exception e) {
                System.out.println("Wrong DOB format");
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

    public String StringNumberInput(String notice, int min, int max) {
        System.out.print(notice);
        Scanner sc = new Scanner(System.in);
        String result = null;
        String input = null;
        do {
            input = sc.nextLine();
            if (input.isEmpty()) {
                System.out.println("Input can not be empty");
                continue;
            } else {
                String temp = input;
                try {
                    long numbericInput = Long.parseLong(temp);
                    if (numbericInput > min && numbericInput < max) {
                        result = input;
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("Input must be numberic");
                }
            }

        } while (true);
        return result;
    }

    public boolean checkEmail(String emailAddress, String regexPattern) {
        return Pattern.compile(regexPattern)
                .matcher(emailAddress)
                .matches();
    }

    public boolean checkGender(String gender) {
        if (gender.equalsIgnoreCase("Male") || gender.equalsIgnoreCase("Female")) {
            return true;
        } else {
            return false;
        }
    }

}
