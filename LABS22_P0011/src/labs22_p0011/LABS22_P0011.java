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
public class LABS22_P0011 {

    //Display choices for user
    public static int display() {
        getInput getInput = new getInput();
        int result = -1;
        boolean loopCheck = true;
        System.out.println("1.Convert ");
        System.out.println("0. Exit");
        result = getInput.IntegerInputMenu("", 0, 1);
        return result;
    }

    public static void displayResult(String result) {
        System.out.println(result);
    }

    public static void main(String[] args) {
        getInput getInput = new getInput();
        convert convert = new convert();
        int choice = display();
        //boolean variable to check user want to keep convert or exit
        boolean continueProgram = true;
        while (continueProgram) {
            switch (choice) {
                case 1:
                    //STEP 1 : Required user choose the base number input 
                    int baseNumberInput = getInput.baseNumberInput();

                    //STEP 2:  Required user choose the base number out
                    int baseNumberOutput = getInput.baseNumberOutput();

                    //STEP 3:  Required user enter the input value
                    String InputValue = getInput.getValue();

                    //STEP 4:  Program process and print output value
                    String OutputValue = convert.implementConvert(baseNumberInput, baseNumberOutput, InputValue);
                    displayResult(OutputValue);
                    break;
                case 0:
                    continueProgram = false;
                    break;
            }
            if (continueProgram) {
                choice = display();
            }
        }

    }

}
