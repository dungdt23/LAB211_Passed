/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labs22_p0066;

/**
 *
 * @author Admin
 */
public class display {

    public display() {
    }
    public void displayGUI() {
        System.out.println("===== Showroom car program =====");
        System.out.println("Input Information of Car");
    }
    public int buyOption() {
        int choice = 0;
        getInput getInput = new getInput();
        String optionStr = getInput.StringInput("Do you want find more?(Y/N):");
        switch(optionStr) {
            case "Y":
                choice = 1;
                break;
            case "N":
                choice = -1;
                break;
        }
        return choice;
    }
}
