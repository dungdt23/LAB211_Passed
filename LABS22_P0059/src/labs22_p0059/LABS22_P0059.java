/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labs22_p0059;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class LABS22_P0059 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        display Display = new display();
        getInput getInput = new getInput();
        boolean continueProgram = true;
        //STEP 1: Display a menu and ask users to select an option
        int choice = Display.displayMenu();
        //STEP 2: Perform function based on the selected option.
        manage ManagePerson = new manage();
        //Loop until user want to stop
        while (continueProgram) {
            switch (choice) {
                //Option 1: Find person info
                case 1:
                    Display.displayHeaderInfo();
                    String path = getInput.StringInput("Enter Path: ");
                    Double money = 0.0;
                    ManagePerson.getPerson(path, money);
                    break;
                //Option 2: Copy text to new file    
                case 2:
                    Display.displayHeaderCopyText();
                    String source = null;
                    String destination = null;
                    boolean copyStatus = ManagePerson.copyWordOneTimes(source, destination);
                    Display.displayCopyStatus(copyStatus);
                    break;
                //Option 3: Exit    
                case 3:
                    continueProgram = false;
                    break;
            }
            if (continueProgram) {
                choice = Display.displayMenu();
            }
        }
    }

}
