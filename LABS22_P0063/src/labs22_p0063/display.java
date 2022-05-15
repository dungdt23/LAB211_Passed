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
public class display {

    public display() {
    }
    
    //display person infor
    public void display(person Person) {
        System.out.println("");
        System.out.println("Information of Person you have entered:");
        System.out.println("Name:" + Person.getName());
        System.out.println("Address:" + Person.getAddress());
        System.out.println("Salary:" + Person.getSalary());
    }

    //display array of person
    public void displayArray(person[] Person) {
        System.out.println("=====================================");
        //traverse from first to last element of array
        for (int i = 0; i < 3; i++) {
            display(Person[i]);
        }
    }
    //displayGUI
    public void displayGUI() {
        System.out.println("=====Management Person programer=====");
    }
}
