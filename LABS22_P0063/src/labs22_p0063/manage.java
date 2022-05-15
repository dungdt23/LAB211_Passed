/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labs22_p0063;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class manage {

    public manage() {
    }

    //input information of person
    public person inputPersonInfo() {
        System.out.println("Input Information of Person");
        getInput getInput = new getInput();
        person Person = new person();
        String name = getInput.StringInput("Please input name:");
        String address = getInput.StringInput("Please input address:");
        double salary = getInput.SalaryInput("Please input salary:");
        Person.setName(name);
        Person.setAddress(address);
        Person.setSalary(salary);
        return Person;
    }

    //sort person list salary
    public person[] sortBySalary(person[] Person) {
        int size = Person.length;
        /*First Loop: Run from first  element to element before last elements of array.After each loop, one 
        element will be sorted*/
        for (int i = 0; i < size - 1; i++) {
            /*Second Loop: Run from first to element before last unsorted element.*/
            for (int j = 0; j < size - 1 - i; j++) {
                //Compare salary of each pair of unsorted elements.  After this, the bigger will stand behind.
                if (Person[j].getSalary() > Person[j + 1].getSalary()) {
                    person temp = Person[j];
                    Person[j] = Person[j + 1];
                    Person[j + 1] = temp;
                }
            }
        }
        return Person;
    }

}
