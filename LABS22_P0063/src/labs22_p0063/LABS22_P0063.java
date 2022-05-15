/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labs22_p0063;

/**
 *
 * @author Admin
 */
public class LABS22_P0063 {

    public static void main(String[] args) {
        display Display = new display();
        manage Manage = new manage();
        person[] Person = new person[3];
        //STEP 1: Display GUI
        Display.displayGUI();

        //STEP 2: Input Data
        Person[0] = Manage.inputPersonInfo();
        Person[1] = Manage.inputPersonInfo();
        Person[2] = Manage.inputPersonInfo();

        //STEP 3: Sort person list by salary ascending
        person[] sortedPerson = Manage.sortBySalary(Person);
        //STEP 4: Display sorted list 
        Display.displayArray(sortedPerson);
    }

}
