/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labs22_p0101;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class Employee implements Comparable<Employee> {

    private String ID;
    private String FirstName;
    private String LastName;
    private String Phone;
    private String Email;
    private String Address;
    private String DOB;
    private String Sex;
    private String Salary;
    private String Agency;

    public Employee() {
    }

    public String getID() {
        return ID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getPhone() {
        return Phone;
    }

    public String getEmail() {
        return Email;
    }

    public String getAddress() {
        return Address;
    }

    public String getDOB() {
        return DOB;
    }

    public String getSex() {
        return Sex;
    }

    public String getSalary() {
        return Salary;
    }

    public String getAgency() {
        return Agency;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public void setSex(String Sex) {
        this.Sex = Sex;
    }

    public void setSalary(String Salary) {
        this.Salary = Salary;
    }

    public void setAgency(String Agency) {
        this.Agency = Agency;
    }

    @Override
    public String toString() {
        String result = "";
        result += "ID:" + ID + "        FirstName:" + FirstName + "     LastName:" + LastName + "       Phone:" + Phone + "             Email:" + Email + "         Address:" + Address + "         DOB:" + DOB + "         Sex:" + Sex + "     Salary:" + Salary + "           Agency:" + Agency;
        return result;
    }

    public void display() {
        System.out.format("%-10s | %-10s | %-10s | %-10s | %-20s | %-20s | %-10s | %-10s | %-10s | %-10s ", ID, FirstName, LastName, Phone, Email, Address, DOB, Sex, Salary, Agency);
    }

    @Override
    public int compareTo(Employee e) {
        return this.getSalary().compareTo(e.getSalary());
    }

}
