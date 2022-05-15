/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labs22_p0052;

import java.util.ArrayList;
import java.util.Scanner;


public class LABS22_P0052 {
 
    public static int displayMenuAndOption() throws Exception {
        Scanner sc = new Scanner(System.in);
        int Option = 0;
        boolean checkOption = true;
        while (checkOption) {
            System.out.println("                                       MENU");
            System.out.println("===================================================================================");
            System.out.println("1. Input the information of 11 countries in East Asia");
            System.out.println("2. Display the information of country you've just input");
            System.out.println("3. Search the information of country by user-entered name");
            System.out.println("4. Display the information of countries sorted name in ascending order");
            System.out.println("5. Exit");
            System.out.println("===================================================================================");
            try {
                Option = Integer.parseInt(sc.nextLine());
                if (Option >= 1 && Option <= 5) {
                    checkOption = false;
                } else {
                    System.out.println("The option must be between 1 and 5. Please re-enter your option!");
                }
            } catch (Exception e) {
                System.out.println("The option must be integer. Please re-enter your option!");
            }
        }
        return Option;
    }

    public static void ManageGeographic() throws Exception {

        //STEP 1: Display a menu and ask users to select an option
        int Option = displayMenuAndOption();

        //STEP 2: Perform function based on the selected option
        ManageEastAsiaCountries manageEastAsiaCountries = new ManageEastAsiaCountries();
        ArrayList<EastAsiaCountries> countryList = new ArrayList<>();

        boolean continueProgram = true;
        
        //Loop until user want to stop program
        while (continueProgram) {
            switch (Option) {
                //Option 1: Input the information of 11 countries in East Asia
                case 1:
                    EastAsiaCountries eastAsiaCountries = new EastAsiaCountries();
                    manageEastAsiaCountries.addCountryInformation(eastAsiaCountries,countryList);
                    break;

                //Option 2: Display information of countries you've kist input
                case 2:
                    EastAsiaCountries recentlyCountry = new EastAsiaCountries();
                    recentlyCountry = manageEastAsiaCountries.getRecentlyEnteredInformation(countryList);
                    manageEastAsiaCountries.display(recentlyCountry);
                    break;

                //Option 3: Search information of countries by user-entered name
                case 3:
                    ArrayList<EastAsiaCountries> searchedCountries = new ArrayList<>();
                    String name = null;
                    searchedCountries = manageEastAsiaCountries.searchInformationByName(name,countryList);
                    manageEastAsiaCountries.displayList(searchedCountries);
                    break;

                //Option 4: Display the information of countries sorted name in ascending order
                case 4:
                    ArrayList<EastAsiaCountries> sortedCountries = new ArrayList<>();
                    sortedCountries = manageEastAsiaCountries.sortInformationByAscendingOrder(countryList);
                    manageEastAsiaCountries.displayList(sortedCountries);
                    break;

                //Option 5: Exit program
                case 5:
                    continueProgram= false;
                    break;
            }
            if (continueProgram == true) {
                Option = displayMenuAndOption();
            }
        }
    }


    public static void main(String[] args) throws Exception 
    { 
            ManageGeographic();
    }
    
}
