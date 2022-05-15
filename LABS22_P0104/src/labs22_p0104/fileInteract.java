/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labs22_p0104;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class fileInteract {

    public fileInteract() {
    }

    public File directoryFile(String pathname) {
        getInput getInput = new getInput();
        File file = null;

        file = new File(pathname);

        return file;
    }

    public void searchResult(String pathname, String searchWord) {
        ArrayList<String> foundWord = new ArrayList<>();
        try {
            FileReader filereader = new FileReader(directoryFile(pathname));
            BufferedReader reader = new BufferedReader(filereader);

            String line = "";
            while ((line = reader.readLine()) != null) {
                //split all word by space
                String[] wordArray = line.split(" ");
                //traverse from first to last element in word array
                for (int i = 0; i < wordArray.length; i++) {
                    //if word contain input, add to result list
                    if (wordArray[i].contains(searchWord)) {
                        foundWord.add(wordArray[i]);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("File doesn't exist");
            foundWord = null;
            return;
        }
        //check if can get word contain string input
        if (foundWord.isEmpty()) {
            System.out.println("Not Found");
        } else {
            System.out.println("");
            System.out.println("Search results:");
            //traverse from first to last in found word list
            for (String string : foundWord) {
                System.out.println("     " + string);
            }
            System.out.println("     ...");
        }

    }
}
