/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labs22_p0101;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class EmployeeManagement {

    public EmployeeManagement() {
    }

    //add employee    
    public boolean AddEmployees(Employee employee, ArrayList<Employee> list) {
        boolean status = true;
        getInput getInput = new getInput();
        System.out.println("----- Add Employee -----");
        //input id 
        String id = getInput.StringInput("Enter ID: ");
        employee.setID(id);
        //check if id is duplicated
        if (checkDuplicated(employee, list)) {
            System.out.println("Employee code is duplicated! Can't add");
            status = false;
        } else {
            //input First Name
            String FirstName = getInput.StringInput("Enter First Name: ");
            employee.setFirstName(FirstName);
            //input Last Name
            String LastName = getInput.StringInput("Enter Last Name: ");
            employee.setLastName(LastName);
            //input Phone
            String phone = getInput.StringNumberInput("Enter Phone Number: ", 0, Integer.MAX_VALUE);
            employee.setPhone(phone);
            //input Email
            String Email = getInput.EmailInput("Enter Email: ");
            employee.setEmail(Email);
            //input Address
            String Address = getInput.StringInput("Enter Address: ");
            employee.setAddress(Address);
            //input DOB
            String DOB = getInput.InputDOB("Enter DOB(yyyy-mm-dd): ");
            employee.setDOB(DOB);
            //input Sex
            String Sex = getInput.GenderInput("Enter Sex: ");
            employee.setSex(Sex);
            //input Salary
            String Salary = getInput.StringNumberInput("Enter Salary: ", 0, Integer.MAX_VALUE);
            employee.setSalary(Salary);
            //input Agency
            String Agency = getInput.StringInput("Enter Agency: ");
            employee.setAgency(Agency);
            //add to list
            list.add(employee);
        }
        return status;
    }

    //update employee
    public boolean UpdateEmployees(Employee employee, ArrayList<Employee> list) {
        System.out.println("----- Update Employee -----");
        boolean status = true;
        getInput getInput = new getInput();
        //check if employee is exist
        if (employee == null) {
            System.out.println("ID doesn't exist ");
            status = false;
        } else {
            //input id 
            String oldID = employee.getID();
            String id = getInput.StringInput("Enter ID: ");
            employee.setID(id);
            //check if id is duplicated
            if (checkDuplicated(employee, list)) {
                System.out.println("Employee code is duplicated! Can't update");
                employee.setID(oldID);
                status = false;
            } else {
                //input First Name
                String FirstName = getInput.StringInput("Enter First Name: ");
                employee.setFirstName(FirstName);
                //input Last Name
                String LastName = getInput.StringInput("Enter Last Name: ");
                employee.setLastName(LastName);
                //input Phone
                String phone = getInput.StringNumberInput("Enter Phone Number: ", 0, Integer.MAX_VALUE);
                employee.setPhone(phone);
                //input Email
                String Email = getInput.StringInput("Enter Email: ");
                employee.setEmail(Email);
                //input Address
                String Address = getInput.StringInput("Enter Address: ");
                employee.setAddress(Address);
                //input DOB
                String DOB = getInput.InputDOB("Enter DOB(yyyy/mm/dd): ");
                employee.setDOB(DOB);
                //input Sex
                String Sex = getInput.StringInput("Enter Sex: ");
                employee.setSex(Sex);
                //input Salary
                String Salary = getInput.StringNumberInput("Enter Salary: ", 0, Integer.MAX_VALUE);
                employee.setSalary(Salary);
                //input Agency
                String Agency = getInput.StringInput("Enter Agency: ");
                employee.setAgency(Agency);
            }
        }
        return status;
    }

    //remove employee
    public boolean RemoveEmployees(Employee employee, ArrayList<Employee> list) {
        System.out.println("----- Remove Employee -----");
        boolean status = true;;
        //check if employee id exist
        if (employee == null) {
            System.out.println("ID doesn't exist ");
            status = false;
        } else {
            list.remove(employee);
        }
        return status;
    }

    //search employee
    public ArrayList<Employee> SearchEmployees(ArrayList<Employee> list) {
        System.out.println("----- Search Employee -----");
        getInput getInput = new getInput();
        ArrayList<Employee> foundList = new ArrayList<>();
        boolean status = true;
        System.out.println("1.Search by Name        2.Search by a part of Name");
        int choice = getInput.IntegerInputMenu("", 1, 2);
        switch (choice) {
            case 1:
                String Name = getInput.StringInput("Enter Name: ");
                for (Employee employee : list) {
                    if (employee.getFirstName().equalsIgnoreCase(Name) || employee.getLastName().equalsIgnoreCase(Name)) {
                        foundList.add(employee);
                    }
                }
                break;
            case 2:
                String partOfName = getInput.StringInput("Enter part of Name: ");
                for (Employee employee : list) {
                    if (employee.getFirstName().contains(partOfName) || employee.getLastName().contains(partOfName)) {
                        foundList.add(employee);
                    }
                }
                break;
        }
        return foundList;
    }

    //sorted employees
    public ArrayList<Employee> sortedEmployees(ArrayList<Employee> list) {
        ArrayList<Employee> sortedEmployees = new ArrayList<>();
        for (Employee employee : list) {
            sortedEmployees.add(employee);
        }
        Collections.sort(list);
        return sortedEmployees;
    }

    //check if id of employee is duplicated
    public boolean checkDuplicated(Employee employee, ArrayList<Employee> list) {
        boolean status = false;
        for (Employee employeeList : list) {
            if (employeeList.getID().equalsIgnoreCase(employee.getID()) && employeeList != employee) {
                status = true;
                break;
            }
        }
        return status;
    }

    //get employee by id
    public Employee getEmployee(ArrayList<Employee> list) {
        Employee foundEmployee = null;
        getInput getInput = new getInput();
        String ID = getInput.StringInput("Enter ID of employee :");
        for (Employee employee : list) {
            if (ID.equalsIgnoreCase(employee.getID())) {
                foundEmployee = employee;
                break;
            }
        }
        return foundEmployee;
    }

}
