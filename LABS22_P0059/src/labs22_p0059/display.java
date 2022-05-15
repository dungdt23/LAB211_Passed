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
public class display {

    getInput getInput = new getInput();

    public display() {
    }

    public int displayMenu() {
        System.out.println("========= File Processing =========");
        System.out.println(".  Find person info");
        System.out.println(".  Copy Text to new file");
        System.out.println(".  Exit");
        int choice = getInput.IntegerInput("", 1, 3);
        return choice;
    }

    public void displayList(ArrayList<person> list) {
        if (list == null) {
            return;
        } else {
            System.out.println("------------- Result -------------");
            System.out.format("%-10s %-10s %-10s", "Name", "Address", "Money");
            for (person Person : list) {
                System.out.println("");
                Person.display();

            }
        }
        System.out.println("");
        System.out.println("");
    }

    public void displayCopyStatus(boolean status) {
        if (status) {
            System.out.println("Copy done...");
        } else {
            System.out.println("Copy text failed ...");
        }
    }

    public void displayPerson(String notice, person Person) {
        System.out.println(notice + ": " + Person.getName());
    }
    
    public void displayHeaderCopyText() {
        System.out.println("------------- Copy text -------------");
    }
    public void displayHeaderInfo() {
        System.out.println("------------- Person info -------------");
    }

}
