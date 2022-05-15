/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labs22_p0052;

/**
 *
 * @author Admin
 */
public class Country implements Comparable<Country> {

    protected String countryCode;
    protected String countryName;
    protected float totalArea;

    public Country() {
    }

    public Country(String countryCode, String countryName, float totalArea) {
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.totalArea = totalArea;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public float getTotalArea() {
        return totalArea;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public void setTotalArea(float totalArea) {
        this.totalArea = totalArea;
    }

//    @Override
//    public String toString() {
//        return "Country{" + "countryCode=" + countryCode + ", countryName=" + countryName + ", totalArea=" + totalArea + '}';
//    }

//    public void display() {
//        String[][] display = new String[2][3];
//        display[0][0] = "ID\t";
//        display[0][1] = "Name\t\t";
//        display[0][2] = "Total Area\t";
//        display[1][0] = this.getCountryCode() + "\t";
//        display[1][1] = this.getCountryName() + "\t";
//        display[1][2] = Float.toString(totalArea);
//        //System.out.println(display[0][0]);
//        for (int j = 0; j < 3; j++) {
//            System.out.print(display[0][j]);
//
//        }
//        System.out.println("");
//        for (int j = 0; j < 3; j++) {
//            System.out.print(display[1][j] + "\t\t\t");
//
//        }
//    }

    @Override
    public int compareTo(Country otherCountry) {
        return this.getCountryName().compareTo(otherCountry.getCountryName());
    }

}
