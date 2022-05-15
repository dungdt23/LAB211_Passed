/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labs22_p0066;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class LABS22_P0066 {

    public static void main(String[] args) {
        display Display = new display();
        getInput getInput = new getInput();
        carManage carManage = new carManage();
        ArrayList<car> carList = carManage.addCarList();
        boolean continueProgram = true;
        while (continueProgram) {
            //FUNCTION 1: Display GUI and input data
            Display.displayGUI();
            //User input car name
            String carName = getInput.StringInput("Name: ");
            //User input car color
            String carColor = getInput.StringInput("Color: ");
            //User input car price
            String carPrice = getInput.StringInput("Price: ");
            //User input car day
            String carDay = getInput.StringInput("Today: ");

            //FUNCTION 2: Check if they match the cars in show room
            boolean checkCarExist = carManage.checkCarExist(carList, carName, carColor, carPrice, carDay);
            //if car exist, ask user to want to buy more
            if (checkCarExist) {
                int choice = Display.buyOption();
                switch (choice) {
                    case 1:
                        continueProgram = true;
                        break;
                    case -1:
                        continueProgram = false;
                        break;
                }
            } else {
                continueProgram = false;
            }

        }

    }

}
