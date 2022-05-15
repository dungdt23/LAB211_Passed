/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labs22_p0074;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class getInput {

    public getInput() {
    }

    public int IntegerInput(String notice, int min, int max) {

        Scanner sc = new Scanner(System.in);
        int result = 0;
        String input = null;
        do {
            System.out.print(notice);
            input = sc.nextLine();
            //check if input is empty
            if (input.isEmpty()) {
                System.out.println("Input can not be empty");
                continue;
            }
            try {
                result = Integer.parseInt(input);
                //check if input in allowed range
                if (result >= min && result < max) {
                    break;
                } else {
                    System.out.println("Input must be in allowed range");
                }
            } catch (Exception e) {
                System.out.println("Value of matrix is digit");
            }
        } while (true);
        return result;
    }

    public int[][] MatrixInput(int number) {
        int row = this.IntegerInput("Enter Row Matrix " + number + ":", 1, Integer.MAX_VALUE);
        int column = this.IntegerInput("Enter Column Matrix " + number + ":", 1, Integer.MAX_VALUE);
        int[][] matrixOutput = new int[row][column];
        //traverse from first elemnt to last element of row in maxtrix output
        for (int i = 0; i < row; i++) {
            //traverse from first elemnt to last element of column in maxtrix output
            for (int j = 0; j < column; j++) {
                String notice = "Enter Maxtrix[" + (i + 1) + "][" + (j + 1) + "]:";
                matrixOutput[i][j] = this.IntegerInput(notice, Integer.MIN_VALUE, Integer.MAX_VALUE);
            }
        }
        return matrixOutput;
    }
}
