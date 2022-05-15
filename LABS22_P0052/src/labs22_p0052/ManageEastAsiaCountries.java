/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labs22_p0052;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ManageEastAsiaCountries {

    public ManageEastAsiaCountries() {

    }

    //Function 1: Add information for a country (code, name, total area, terrain)
    public void addCountryInformation(EastAsiaCountries newCountry, ArrayList<EastAsiaCountries> countryList) throws Exception {
        getInput getInput = new getInput();
        boolean checkaddInfor;
            checkaddInfor = false;
            //Check the amount of countries in the list        
            if (!checkAmount(countryList)) {
                System.out.println("Exceed the allowed amount of countries");
                return;
            }
            //input country code
            String countryCode = getInput.StringInput("Enter code of country");
            newCountry.setCountryCode(countryCode);

            //input country name
            String countryName = getInput.StringInput("Enter name of country");
            newCountry.setCountryName(countryName);

            //input country area
            float totalArea = getInput.FloatInput("Enter total area of country:");
            newCountry.setTotalArea(totalArea);
            //check country area

            //input terrain of country
            String terrain = getInput.StringInput("Enter terrain of country: ");
            newCountry.setCountryTerrain(terrain);

            //if code is not duplicated, country will be added
            if (checkDuplicated(newCountry, countryList)) {
                countryList.add(newCountry);
                System.out.println("Successfully");
            } else {
                System.out.println("This code is duplicated! Can't add ");
                return;
            }
        
    }

    //Function 2: Display information of countries you've just input  
    public EastAsiaCountries getRecentlyEnteredInformation(ArrayList<EastAsiaCountries> countryList) throws Exception {
        EastAsiaCountries resultEAC = null;
        //Check if the list is empty    
        if (countryList.isEmpty()) {
            System.out.println("You haven't added any countries yet. Please add at least one country!");
        } else {
            resultEAC = countryList.get(countryList.size() - 1);
        }
        return resultEAC;
    }

    //Function 3: Search information of countries by user-entered name
    public ArrayList<EastAsiaCountries> searchInformationByName(String name, ArrayList<EastAsiaCountries> countryList) {
        Scanner sc = new Scanner(System.in);
        ArrayList<EastAsiaCountries> foundCountries = new ArrayList<>();
        getInput getInput = new getInput();
        name = getInput.StringInput("Enter name of countries you want to search :");
        //Loop run from the first to the last elemnent in the list.
        for (Country countries : countryList) {
            //If any country has the same name as input, it will be added to the list.        
            if (countries.getCountryName().equalsIgnoreCase(name)) {
                foundCountries.add((EastAsiaCountries) countries);
            }
        }

        return foundCountries;
    }

    //Function 4: Displays the names of countries by name ascending
    public ArrayList<EastAsiaCountries> sortInformationByAscendingOrder(ArrayList<EastAsiaCountries> countryList) throws Exception {
        ArrayList<EastAsiaCountries> sortedCountries = new ArrayList<>();
        sortedCountries = countryList;
        //Sort the list by name ascending    
        Collections.sort(sortedCountries);
        return sortedCountries;
    }

    //Display function according to the format
    public void displayList(ArrayList<EastAsiaCountries> countryList) {
        if (countryList.isEmpty()) {
            System.out.println("Not exist !!");
            return;
        }
        System.out.println("ID\tName\t\tTotal Area\tTerrain");
        //loop run from the first to the last element in the list
        for (EastAsiaCountries countries : countryList) {
            countries.display();
            System.out.println("");
        }
    }

    //Display an EastAsiaCountry
    public void display(EastAsiaCountries EAC) {
        if (EAC == null) {
            System.out.println("Country does not exist");
            return;
        }
        System.out.println("ID\tName\t\tTotal Area\tTerrain");
        EAC.display();
    }

    //Check if East Asia Country existed
    public boolean checkDuplicated(EastAsiaCountries eac, ArrayList<EastAsiaCountries> countryList) {
        boolean result = true;
        //loop run from the first to the last element in the list
        for (EastAsiaCountries country : countryList) {
            //check if the paramter's code is duplicated  
            if (eac.getCountryCode().equalsIgnoreCase(country.getCountryCode())) {
                result = false;
                break;
            }
        }
        return result;
    }

    //Check the amount of East Asia Country
    public boolean checkAmount(ArrayList<EastAsiaCountries> countryList) {
        boolean result = true;
        //check size of the list
        if (countryList.size() < 4) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }

}
