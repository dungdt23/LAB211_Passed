/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labs22_p0101;

import java.util.ArrayList;
import java.util.Formatter;

/**
 *
 * @author Admin
 */
public class Display {

    public Display() {
    }

    public int DisplayMenu() {
        getInput getInput = new getInput();
        int result = 0;
        System.out.println("Main menu:");
        System.out.println("1. Add employees ");
        System.out.println("2. Update employees");
        System.out.println("3. Remove employees");
        System.out.println("4. Search employees");
        System.out.println("5. Sort employees by salary");
        System.out.println("6. Exit");
        result = getInput.IntegerInputMenu("Enter your choice : ", 1, 6);
        return result;
    }

    public void DisplayStatus(boolean status) {
        if (status) {
            System.out.println("Successfully");
        } else {
            System.out.println("Unsuccessfully");
        }
    }

    public void DisplayList(ArrayList<Employee> list) {
        if (list.isEmpty()) {
            System.out.println("Not found");
            return;
        }
        System.out.format(" %-10s | %-10s | %-10s | %-10s | %-20s | %-20s | %-10s | %-10s | %-10s | %-10s ", "ID", "FirstName", "LastName", "Phone", "Email", "Address", "DOB", "Sex", "Salary", "Agency");
        System.out.println();
        for (Employee employee : list) {
            employee.display();
            System.out.println();
        }
    }
}
