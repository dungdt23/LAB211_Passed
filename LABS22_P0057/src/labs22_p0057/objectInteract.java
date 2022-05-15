/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labs22_p0057;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Admin
 */
public class objectInteract {

    public objectInteract() {
    }

    //write object to file
    public void writeObject(ArrayList<account> accountList) {
        if (accountList == null) {
            return;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("user.dat");
            ObjectOutputStream getObject = new ObjectOutputStream(fileOutputStream);
            //read object accountList from object
            getObject.writeObject(accountList);
            getObject.close();
            fileOutputStream.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    //read object from file
    public ArrayList<account> readObject() {
        ArrayList<account> accountList = null;
        try {
            FileInputStream fileInputStream = new FileInputStream("user.dat");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            //set value of account lists as read object.
            accountList = (ArrayList<account>) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
        } catch (Exception e) {
            System.out.println("Database does not exist");
        }
        return accountList;
    }
}
