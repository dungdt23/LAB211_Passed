/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labs22_p0057;

/**
 *
 * @author Admin
 */
public class display {

    getInput getInput = new getInput();

    public display() {
    }

    public int displayMenu() {
        System.out.println("===== USER MANAGEMENT SYSTEM =====");
        System.out.println("1.  Create a new account");
        System.out.println("2   Login system");
        System.out.println("3.  Exit");
        int choice = getInput.IntegerInput(">  Choose:", 1, 3);
        return choice;
    }

    public void displayLoginStatus(account acc) {
        if (acc == null) {
            return;
        } else {
            if (acc.getUsername().isEmpty()) {
                System.out.println("Invalid user name or password");
            } else {
                System.out.println("Login successful!");
            }
        }

    }
}
