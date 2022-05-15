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
public class LABS22_P0074 {

    public static void calculatorProgram() {
        display display = new display();
        getInput getInput = new getInput();
        boolean continueProgram = true;
        //Function 1: Display a menu and ask users to select an option.
        int choice = display.displayMenu();
        //Function 2: Perform function based on the selected option.
        calculatorProgram calculatorProgram = new calculatorProgram();
        while (continueProgram) {
            switch (choice) {
                //Option 1: Addition matrixes
                case 1:
                    display.displayAddition();
                    int[][] addMaxtrix1 = getInput.MatrixInput(1);
                    int[][] addMaxtrix2 = getInput.MatrixInput(2);
                    int[][] addResult = calculatorProgram.additionMatrix(addMaxtrix1, addMaxtrix2);
                    display.displayResult(addMaxtrix1, addMaxtrix2, addResult, 1);
                    break;
                //Option 2: Subtraction matrixes   
                case 2:
                    display.displaySubtraction();
                    int[][] subMaxtrix1 = getInput.MatrixInput(1);
                    int[][] subMaxtrix2 = getInput.MatrixInput(2);
                    int[][] subResult = calculatorProgram.subtractionMatrix(subMaxtrix1, subMaxtrix2);
                    display.displayResult(subMaxtrix1, subMaxtrix2, subResult, 2);
                    break;
                //Option 3: Multiplication matrixes  
                case 3:
                    display.displayMultiplication();
                    int[][] multiplicationMaxtrix1 = getInput.MatrixInput(1);
                    int[][] multiplicationMaxtrix2 = getInput.MatrixInput(2);
                    int[][] multiplicationResult = calculatorProgram.multiplicationMatrix(multiplicationMaxtrix1, multiplicationMaxtrix2);
                    display.displayResult(multiplicationMaxtrix1, multiplicationMaxtrix2, multiplicationResult, 3);
                    break;
                //Option 4: Exit program  
                case 4:
                    continueProgram = false;
                    break;
            }
            if (continueProgram) {
                choice = display.displayMenu();
            }
        }

    }

    public static void main(String[] args) {
        calculatorProgram();

    }

}
