/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labs22_p0059;

import java.io.FileWriter;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class manage {

    public manage() {
    }

    // Displays information of the amount entered
    public void getPerson(String path, double money) {
        ArrayList<person> result = new ArrayList<>();
        fileInteract fileInteract = new fileInteract();
        getInput getInput = new getInput();
        //get list from file
        ArrayList<person> inputList = fileInteract.getPeopleList(path);
        if (inputList == null) {
            return;
        } else {
            money = getInput.DoubleInput("Enter Money:", 0, Double.MAX_VALUE);
            //traverse from first element to last of person list
            for (person Person : inputList) {
                //if money of person greater or equal to moneyInput, add to reult
                if (Person.getMoney() >= money) {
                    result.add(Person);
                }
            }
            if (result.isEmpty()) {
                System.out.println("Not found");
            } else {
                person maxPerson = new person();
                person minPerson = result.get(0);
                double min = result.get(0).getMoney();
                double max = 0;
                //traverse from first element to last of person list
                for (person Person : result) {
                    //if money of person is less than min, set this money is new min
                    if (Person.getMoney() < min) {
                        min = Person.getMoney();
                        minPerson = Person;
                    }
                    //if money of person is greater than max, set this money is new max    
                    if (Person.getMoney() > max) {
                        max = Person.getMoney();
                        maxPerson = Person;
                    }
                }
                display Display = new display();
                Display.displayList(result);
                Display.displayPerson("Max", maxPerson);
                Display.displayPerson("Min", minPerson);
            }

        }

    }

    //
    public boolean copyWordOneTimes(String source, String destination) {
        boolean status = true;
        fileInteract fileInteract = new fileInteract();
        getInput getInput = new getInput();
        source = getInput.StringInput("Enter Source file name: ");

        ArrayList<person> inputList = fileInteract.getPeopleList(source);
        //check read input 
        if (inputList == null) {
            status = false;
        } else {
            destination = getInput.StringInput("Enter new file name: ");
            ArrayList<String> outputList = new ArrayList<>();
            //traverse from first to last element of person list
            for (person Person : inputList) {
                //check if their name is single word and not existed
                if (checkWordOneTime(Person.getName(), outputList)) {
                    outputList.add(Person.getName());
                }
                //check if their address is single word and not existed
                if (checkWordOneTime(Person.getAddress(), outputList)) {
                    outputList.add(Person.getAddress());
                }
            }
            //status of copying 
            try {
                status = fileInteract.writeToFile(destination, outputList);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
        return status;
    }

    //check word one time
    public boolean checkWordOneTime(String word, ArrayList<String> wordOneTimeList) {
        boolean result = true;
        //check this word is single word or not
        if (word.contains(" ")) {
            result = false;
        }
        //traverse from first element to last of word list
        for (String wordOneTime : wordOneTimeList) {
            //check if this word is existed or not
            if (wordOneTime.equalsIgnoreCase(word)) {
                result = false;
                break;
            }
        }
        return result;
    }
}
