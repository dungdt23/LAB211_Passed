/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labs22_p0066;

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
}
