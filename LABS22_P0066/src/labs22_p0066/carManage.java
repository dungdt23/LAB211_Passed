/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labs22_p0066;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class carManage {

    public carManage() {
    }

    class ExceptionCar extends Exception {

        String message;

        ExceptionCar(String str) {
            message = str;
        }

    }

    //enum Name
    public enum Name {
        AUDI, MERCEDES, BMW;

        String getName(String nameInput) {
            String nameOutput = "";
            //traverse from first to last of enum name values
            for (Name name : Name.values()) {
                if (name.toString().equals(nameInput)) {
                    nameOutput = nameInput;
                    break;
                }
            }
            return nameOutput;
        }
    }

    //enum Day
    public enum Day {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY,SUNDAY;

        String getDay(String day) {
            String dayOutput = "";
            //traverse from first to last of enum day values
            for (Day dayValue : Day.values()) {
                if (dayValue.toString().equals(day)) {
                    dayOutput = day;
                    break;
                }
            }
            return dayOutput;
        }
    }

    //enum Color
    public enum Color {
        WHITE, YELLOW, ORANGE, GREEN, PURPLE, PINK, RED, BROWN;

        String getColor(String color) {
            String ColorOutput = "";
            //check if car doesn't have color
            if (color.equalsIgnoreCase("no color")) {
                ColorOutput = "no color";
            } else {
                //traverse from first to last of enum color values
                for (Color ColorValue : Color.values()) {
                    if (ColorValue.toString().equals(color)) {
                        ColorOutput = color.toString();
                        break;
                    }
                }
            }

            return ColorOutput;
        }
    }

    //enum Price
    public enum Price {
        PRICE1(5500), PRICE2(3000), PRICE3(4500), PRICE4(5000), PRICE5(6000), PRICE6(8500), PRICE7(2500), PRICE8(3000), PRICE9(3500);
        private int value;

        private Price(int value) {
            this.value = value;
        }

        int getPrice(String priceInputStr) {
            int priceInput = Integer.parseInt(priceInputStr);
            int priceOutput = 0;
            //traverse from first to last of enum price values
            for (Price price : Price.values()) {
                if (price.value == priceInput) {
                    priceOutput = priceInput;
                    break;
                }
            }
            return priceOutput;
        }
    }

    public ArrayList<car> addCarList() {
        ArrayList<car> carList = new ArrayList<>();
        String[] listColorAudi = {"WHITE", "YELLOW", "ORANGE"};
        int[] listPriceAudi = {5500, 3000, 4500};
        String[] listSoldDayAudi = {"FRIDAY", "SUNDAY", "MONDAY"};
        carList.add(new car("AUDI", listColorAudi, listPriceAudi, listSoldDayAudi));

        String[] listColorMercedes = {"GREEN", "BLUE", "PURPLE"};
        int[] listPriceMercedes = {5000, 6000, 8500};
        String[] listSoldDayMercedes = {"TUESDAY", "SATURDAY", "WEDNESDAY"};
        carList.add(new car("MERCEDES", listColorMercedes, listPriceMercedes,
                listSoldDayMercedes));

        String[] listColorBMW = {"PINK", "RED", "BROWN"};
        int[] listPriceBMW = {2500, 3000, 3500};
        String[] listSoldDayBMW = {"MONDAY", "SUNDAY", "THURSDAY"};
        carList.add(new car("BMW", listColorBMW, listPriceBMW, listSoldDayBMW));

        return carList;
    }

    public void checkCarInfo(ArrayList<car> carList, String nameInput, String colorInput, String priceInput, String dayInput) throws ExceptionCar {
        //get name from Enum Name
        Name carName = Name.AUDI;
        String name = carName.getName(nameInput);

        //get color from Enum Color
        Color carColor = Color.BROWN;
        String color = carColor.getColor(colorInput);

        //get color from Enum Day
        Day carDay = Day.MONDAY;
        String day = carDay.getDay(dayInput);

        //check name
        boolean checkname = false;
        int indexOfCar = 0;
        //traverse from first to last element in car list
        for (car carInList : carList) {
            if (carInList.getNameCar().equals(name)) {
                checkname = true;
                indexOfCar = carList.indexOf(carInList);
                break;
            }
        }
        //if name doesn't exist, throw car exception
        if (!checkname) {
            System.out.println("Can't sell Car");
            throw new ExceptionCar("Car break");
        } else {
            car Car = carList.get(indexOfCar);
            String[] listColor = Car.getColor();
            int[] listPrice = Car.getPrice();
            String[] listDay = Car.getSoldOn();
            //check color 
            boolean nocolorCheck = false;
            boolean colorCheck = false;
            if (!color.equalsIgnoreCase("no color")) {
                //traverse from first to last element in color array of car
                for (int i = 0; i < 3; i++) {
                    if (color.equals(listColor[i])) {
                        colorCheck = true;
                    }
                }
                if (!colorCheck) {
                    System.out.println("Can't sell Car");
                    throw new ExceptionCar("Color Car does not exist");
                }
            } else {
                nocolorCheck = true;
            }
            //check price
            int[] priceList = Car.getPrice();
            boolean checkPrice = false;
            //check if price is digit or not
            if (!isNumeric(priceInput)) {
                System.out.println("Can't sell Car");
                throw new ExceptionCar("Price is digit");
            } else {

                int price = Integer.valueOf(priceInput);
                //check if price is greater than 0
                if (price <= 0) {
                    System.out.println("Can't sell Car");
                    throw new ExceptionCar("Price greater than zero");
                } else {
                    //traverse from first to last element in price array of car
                    for (int i = 0; i < 3; i++) {
                        //check if car has no color
                        if (nocolorCheck) {
                            Price carPrice = Price.PRICE1;
                            int newPriceInput = Integer.valueOf(priceInput) + 100;
                            price = carPrice.getPrice(Integer.toString(newPriceInput));
                            if (listPrice[i] == price) {
                                checkPrice = true;
                                break;
                            }
                        } else {
                            Price carPrice = Price.PRICE1;
                            price = carPrice.getPrice(priceInput);
                            if (listPrice[i] == price) {
                                checkPrice = true;
                                break;
                            }
                        }
                    }
                    //check if price exist in price array of car
                    if (!checkPrice) {
                        System.out.println("Can't sell Car");
                        throw new ExceptionCar("Car price does not exist");
                    }

                }
                //checkDay
                boolean checkDay = false;
                //traverse from first to last element in day array of car
                for (int i = 0; i < 3; i++) {
                    if (day.equals(listDay[i])) {
                        checkDay = true;
                        break;
                    }
                }
                //check if day exist in day array of car
                if (!checkDay) {
                    System.out.println("Can't sell Car");
                    throw new ExceptionCar("Car can't sell today");
                }

            }
        }

    }

    public boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public boolean checkCarExist(ArrayList<car> carList, String nameInput, String colorInput, String priceInput, String dayInput) {
        boolean checkCar = false;
        try {
            checkCarInfo(carList, nameInput, colorInput, priceInput, dayInput);
            checkCar = true;
            System.out.println("Sell Car");
        } catch (ExceptionCar e) {
            System.out.println(e.message);
        }
        return checkCar;
    }

}
