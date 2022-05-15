/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labs22_p0055;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

/**
 *
 * @author Admin
 */
public class ObjectInteract {

    public ObjectInteract() {
    }
    //write object to file
    public void writeObject(HashMap<String, Doctor> doctorHashMap,boolean status) {
        if (!status) {
            return;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("doctors.dat");
            ObjectOutputStream getObject = new ObjectOutputStream(fileOutputStream);
            getObject.writeObject(doctorHashMap);
            getObject.close();
            fileOutputStream.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    //read object from file
    public static HashMap<String, Doctor> readObject() {
        HashMap<String, Doctor> doctorHashMap = null;
        try {
            FileInputStream fileInputStream = new FileInputStream("doctors.dat");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            //set value of doctor lists as read object.
            doctorHashMap = (HashMap<String, Doctor>) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
        } catch (Exception e) {
            //if exception happen, mark no database. 
            System.out.println("Database does not exist");
        }
        return doctorHashMap;
    }
}
