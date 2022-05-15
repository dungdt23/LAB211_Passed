/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labs22_p0059;

/**
 *
 * @author Admin
 */
public class person {

    private String name;
    private String address;
    private double money;

    public person() {
    }

    public person(String name, String address, double money) {
        this.name = name;
        this.address = address;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public double getMoney() {
        return money;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public void display() {
        System.out.format("%-10s %-10s %-10s", getName(), getAddress(), getMoney());
    }

}
