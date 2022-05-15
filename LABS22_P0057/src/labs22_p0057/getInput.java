/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labs22_p0057;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class getInput {

    public getInput() {
    }

    public String LoginInput(String notice, int checkUserOrPass) {
        Scanner sc = new Scanner(System.in);
        String result = null;
        boolean continueInput = true;
        do {
            System.out.print(notice);
            result = sc.nextLine();
            if (!result.isEmpty()) {
                switch (checkUserOrPass) {
                    case 1:
                        if (checkUsername(result)) {
                            continueInput = false;
                        } else {
                            System.out.println("Username must be at least 5 characters and no spaces ");
                        }
                        break;
                    case -1:
                        if (checkPassword(result)) {
                            continueInput = false;
                        } else {
                            System.out.println("Password must be at least 6 characters and no spaces");
                        }
                        break;
                }
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

    boolean checkUsername(String str) {
        if (str.length() >= 5 && !str.contains(" ")) {
            return true;
        } else {
            return false;
        }
    }

    boolean checkPassword(String str) {
        if (str.length() >= 6 && !str.contains(" ")) {
            return true;
        } else {
            return false;
        }
    }
}
