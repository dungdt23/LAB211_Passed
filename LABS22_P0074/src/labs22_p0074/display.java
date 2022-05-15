/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labs22_p0074;

/**
 *
 * @author Admin
 */
public class display {

    public display() {
    }

    public int displayMenu() {
        getInput getInput = new getInput();
        System.out.println("=======Calculator program=======");
        System.out.println("1. Addition Matrix");
        System.out.println("2. Subtraction Matrix");
        System.out.println("3. Multiplication Matrix");
        System.out.println("4. Quit");
        int choice = getInput.IntegerInput("Your choice:", 1, 4);
        return choice;
    }

    public void displayMatrix(int[][] input) {
        //traverse from first element to last element of row in input
        for (int i = 0; i < input.length; i++) {
            //traverse from first elemnt to last element of column in input
            for (int j = 0; j < input[0].length; j++) {
                System.out.print("[" + input[i][j] + "]");
            }
            System.out.println("");
        }
    }

    public void displayResult(int[][] input1, int[][] input2, int[][] result, int choice) {
        if (result == null) {
            System.out.println("Can't calculate");
            return;
        } else {
            System.out.println("------- Result -------");
            displayMatrix(input1);
            switch (choice) {
                case 1:
                    System.out.println("+");
                    break;
                case 2:
                    System.out.println("-");
                    break;
                case 3:
                    System.out.println("*");
                    break;
            }
            displayMatrix(input2);
            System.out.println("=");
            displayMatrix(result);

        }
    }

    public void displayAddition() {
        System.out.println("------- Addition -------");
    }

    public void displaySubtraction() {
        System.out.println("------- Subtraction -------");
    }

    public void displayMultiplication() {
        System.out.println("------- Multiplication -------");
    }
}
