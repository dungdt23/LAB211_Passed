/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labs22_p0059;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class fileInteract {

    public fileInteract() {

    }

    //check if string is numberic
    public boolean isNumeric(String str) {
        //traverse from first character to last character of string input
        for (char c : str.toCharArray()) {
            //check if character is digit or not
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public ArrayList<person> getPeopleList(String filename) {
        boolean filenameStatus = true;
        ArrayList<person> list = new ArrayList<>();
        boolean readStatus = true;
        try {
            FileReader filereader = new FileReader(filename);
            BufferedReader reader = new BufferedReader(filereader);
            String line = "";
            //Loop until read a line get result is null
            while ((line = reader.readLine()) != null) {
                //divine string to array by comma
                String[] a = line.split(",");
                //check if the file is correct format
                if (a.length != 3) {
                    readStatus = false;
                    list = null;
                    break;
                } else {
                    person p = new person();
                    p.setName(a[0]);
                    p.setAddress((a[1]));
                    //check if money is valid or not
                    if (isNumeric(a[2])) {
                        p.setMoney(Double.valueOf(a[2]));
                    } else {
                        p.setMoney(0);
                    }
                    list.add(p);

                }

            }
        } catch (Exception e) {
            System.out.println("Source filename doesn't exist");
            list = null;
            filenameStatus = false;
        }
        if (list == null && filenameStatus) {
            System.out.println("Can't read source file");
        }
        return list;
    }

    public boolean writeToFile(String pathname, ArrayList<String> list) throws IOException {
        getInput getInput = new getInput();
        int index = 0;
        boolean writeStatus = true;
        File file = new File(pathname);
        int choice = 0;
        //check if file is exist
        if (file.exists()) {
            choice = getInput.IntegerInput("Do you want to write on this file? 1.Yes   2.No   ", 1, 2);
        }
        //if user not want to write on existed file, break
        if (choice == 2) {
            writeStatus = false;
            return writeStatus;
        } else {
            //Loop until nothing in list to write
            while (true) {

                try {
                    FileWriter fw = new FileWriter(pathname, true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    //string to write one time word
                    String data = "";
                    //if last word, not add comma later
                    if (index == list.size() - 1) {
                        data += list.get(index);
                    } else {
                        data += list.get(index) + ", ";
                    }
                    bw.write(data);
                    bw.close();
                } catch (Exception e) {
                    System.out.println("Can't write a new file to copy");
                    writeStatus = false;
                    break;
                }
                index++;
                if (index == list.size()) {
                    break;
                }

            }
        }

        return writeStatus;
    }
}
