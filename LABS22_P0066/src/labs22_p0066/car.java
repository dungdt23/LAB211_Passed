/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labs22_p0066;

/**
 *
 * @author Admin
 */
public class car {

    private String nameCar;
    private String[] color;
    private int[] Price;
    private String[] soldOn;

    public car() {
    }

    public car(String nameCar, String[] color, int[] Price, String[] soldOn) {
        this.nameCar = nameCar;
        this.color = color;
        this.Price = Price;
        this.soldOn = soldOn;
    }

    public String getNameCar() {
        return nameCar;
    }

    public String[] getColor() {
        return color;
    }

    public int[] getPrice() {
        return Price;
    }

    public String[] getSoldOn() {
        return soldOn;
    }

    public void setNameCar(String nameCar) {
        this.nameCar = nameCar;
    }

    public void setColor(String[] color) {
        this.color = color;
    }

    public void setPrice(int[] Price) {
        this.Price = Price;
    }

    public void setSoldOn(String[] soldOn) {
        this.soldOn = soldOn;
    }

    
}
