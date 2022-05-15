/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labs22_p0070;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class getData {

    public getData() {
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
                    System.out.println("Input must be in allowed range");
                }
            } catch (Exception e) {
                System.out.println("Input must be integer");
            }
        } while (true);
        return result;
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

    //account number input
    public String accountInput(String notice1, String notice2) {
        checkData checkData = new checkData();
        String accountNumber = null;
        //loop until account is valid
        while (true) {
            System.out.print(notice1);
            accountNumber = this.StringInput("");
            //check if account is digit and have size of 10
            if (checkData.isNumeric(accountNumber) && accountNumber.length() == 10) {
                break;
            }
            System.out.println(notice2);
        }
        return accountNumber;
    }

    //password input 
    public String passwordInput(String notice1, String notice2) {
        checkData checkData = new checkData();
        String password = null;
        //loop unitl password is valid
        while (true) {
            System.out.print(notice1);
            password = this.StringInput("");
            //check if pass have aphanumeric and size from 8 to 31
            if (checkData.checkAlphanumeric(password) && checkData.checkSize(password, 8, 31)) {
                break;
            }
            System.out.println(notice2);
        }
        return password;
    }

    //generate captcha
    public String captchaGenerate(String notice) {
        String captcha = "";
        //create a string to have character that can be in captcha
        String library = "";
        //traverse from 'a' to 'z'
        for (char c = 'a'; c <= 'z'; c++) {
            //store character in string
            library += c;
        }
        //traverse from 'A' to 'Z'
        for (char c = 'A'; c <= 'Z'; c++) {
            //store character in string
            library += c;
        }
        //traverse from 0 to 9
        for (char c = '0'; c <= '9'; c++) {
            //store character in string
            library += c;
        }
        for (int i = 0; i < 5; i++) {
            Random random = new Random();
            int index = random.nextInt(library.length());
            //get any character in store string randomly
            char newChar = library.charAt(index);
            captcha += newChar;
        }
        System.out.println(notice + captcha);
        return captcha;
    }

}
