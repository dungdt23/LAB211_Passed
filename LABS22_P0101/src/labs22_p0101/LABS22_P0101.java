/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labs22_p0101;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class LABS22_P0101 {

    public static void EmployeeManagement() {
        Display display = new Display();
        //STEP 1 : Display a menu and ask users to select an option 
        int choice = display.DisplayMenu();
        //STEP 2 : Perform function based on the selected option
        getInput getData = new getInput();
        ArrayList<Employee> employeesList = new ArrayList<>();
        EmployeeManagement employeeManagement = new EmployeeManagement();
        boolean continueProgram = true;
        while (continueProgram) {
            switch (choice) {
                //Option 1: Add employees: all property are required (Check duplicate Id) 
                case 1:
                    Employee addedEmployee = new Employee();
                    boolean addedStatus = employeeManagement.AddEmployees(addedEmployee, employeesList);
                    display.DisplayStatus(addedStatus);
                    break;
                //Option 2: Update employees: Find an employee by Id       
                case 2:
                    Employee updatedEmployee = employeeManagement.getEmployee(employeesList);
                    boolean updatedStatus = employeeManagement.UpdateEmployees(updatedEmployee, employeesList);
                    display.DisplayStatus(updatedStatus);
                    break;
                //Option 3: Remove employees: The program allows user find an employee by Id
                case 3:
                    Employee removeEmployee = employeeManagement.getEmployee(employeesList);
                    boolean removeStatus = employeeManagement.RemoveEmployees(removeEmployee, employeesList);
                    display.DisplayStatus(removeStatus);
                    break;
                //Option 4: Search employees: The program allows user find an employee by Name        
                case 4:
                    ArrayList<Employee> searchedEmployees = employeeManagement.SearchEmployees(employeesList);
                    display.DisplayList(searchedEmployees);
                    break;
                //Option 5:  Sort employees by salary      
                case 5:
                    ArrayList<Employee> sortedList = employeeManagement.sortedEmployees(employeesList);
                    display.DisplayList(sortedList);
                    break;
                //Option 6: Exit
                case 6:
                    continueProgram = false;
                    break;
            }
            choice = display.DisplayMenu();
        }
    }

    public static void main(String[] args) {
        EmployeeManagement();
    }

}
