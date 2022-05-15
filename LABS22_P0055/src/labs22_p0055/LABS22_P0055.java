/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labs22_p0055;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Admin
 */
public class LABS22_P0055 {

    public static void displayStatus(boolean Status) {
        if (Status) {
            System.out.println("Successfully");
        } else {
            System.out.println("Unsuccessfully");
        }
    }

    public static void writeObject(HashMap<String, Doctor> doctorHashMap) {
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

    public static int displayGUI() throws Exception {
        Scanner sc = new Scanner(System.in);
        int Option = 0;
        boolean checkOption = true;
        while (checkOption) {
            System.out.println("========= Doctor Management =========");
            System.out.println(".       Add Doctor");
            System.out.println(".       Update Doctor");
            System.out.println(".       Delete Doctor");
            System.out.println(".       Search Doctor");
            System.out.println(".       Exit");
            System.out.println("");
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

    public static void DoctorManagement() throws Exception {
        //STEP 1: Display GUI and Input Data
        int Option = displayGUI();

        //STEP 2: Perform function based on the selected option
        HashMap<String, Doctor> doctorHashMap = new HashMap<>();
        writeObject(doctorHashMap);
        ObjectInteract objectInteract = new ObjectInteract();
        DoctorHash doctorsHash = new DoctorHash();
        boolean continueProgram = true;
        while (continueProgram) {
            switch (Option) {

                //OPTION 1: Add Doctor
                case 1:
                    HashMap<String, Doctor> DoctorHashMap1 = objectInteract.readObject();
                    Doctor addDoctor = new Doctor();
                    boolean addedStatus = doctorsHash.addDoctor(addDoctor, DoctorHashMap1);
                    objectInteract.writeObject(DoctorHashMap1,addedStatus);
                    displayStatus(addedStatus);
                    break;

                //OPTION 2: Update Doctor
                case 2:
                    HashMap<String, Doctor> DoctorHashMap2 = objectInteract.readObject();
                    Doctor updatedDoctor = new Doctor();
                    boolean updatedStatus = doctorsHash.updateDoctor(updatedDoctor, DoctorHashMap2);
                    objectInteract.writeObject(DoctorHashMap2,updatedStatus);
                    displayStatus(updatedStatus);
                    break;

                //OPTION 3: Delete Doctor
                case 3:
                    HashMap<String, Doctor> DoctorHashMap3 = objectInteract.readObject();
                    Doctor deletedDoctor = new Doctor();
                    boolean deletedStatus = doctorsHash.deleteDoctor(deletedDoctor, DoctorHashMap3);
                    objectInteract.writeObject(DoctorHashMap3,deletedStatus);
                    displayStatus(deletedStatus);
                    break;

                //OPTION 4: Search Doctor
                case 4:
                    HashMap<String, Doctor> DoctorHashMap4 = objectInteract.readObject();
                    String text = null;
                    HashMap<String, Doctor> searchDoctor = new HashMap<>();
                    searchDoctor = doctorsHash.searchDoctor(text, DoctorHashMap4);
                    doctorsHash.traverse(searchDoctor);
                    //objectInteract.writeObject(DoctorHashMap4,addedStatus);
                    break;

                //OPTION 5: Exit the program
                case 5:
                    continueProgram = false;
                    break;
            }
            if (continueProgram == true) {
                Option = displayGUI();
            }
        }

    }

    public static void main(String[] args) throws Exception {

        DoctorManagement();
    }
}
