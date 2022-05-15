/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labs22_p0055;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class getInput {

    public getInput() {
    }

    public String StringInput(String notice) {
        System.out.println(notice);
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

    public int IntegerInput(String notice) {
        System.out.println(notice);
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
}
