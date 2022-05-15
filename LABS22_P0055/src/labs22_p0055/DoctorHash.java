/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labs22_p0055;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map;

/**
 *
 * @author Admin
 */
public class DoctorHash implements Serializable {

    public DoctorHash() {

    }

    //Add Doctor
    public boolean addDoctor(Doctor Doctor, HashMap<String, Doctor> doctorHash) throws Exception {
        //Variable of doctor adding status
        getInput getInput = new getInput();
        boolean result = true;
        //Check database
        if (doctorHash == null) {
            result = false;
        } else {

            System.out.println("--------- Add Doctor ---------");

            //input code of doctor
            String code = getInput.StringInput("Enter Code:");
            Doctor.setCode(code);
            //input name of doctor
            String name = getInput.StringInput("Enter Name:");
            Doctor.setName(name);
            //input specialization
            String specialization = getInput.StringInput("Enter Specialization: ");
            Doctor.setSpecialization(specialization);
            //input availability
            int availability = getInput.IntegerInput("Enter Availability: ");
            Doctor.setAvailability(availability);
            boolean checkID = checkDuplicated(Doctor, doctorHash);
            //If the code is not exist. Add the doctor.
            if (!checkID) {
                doctorHash.put(Doctor.getCode(), Doctor);
            } else {
                System.out.println("Doctor code [Code] is duplicate");
                result = false;
            }

        }

        return result;
    }

    //Update Doctor
    public boolean updateDoctor(Doctor UpdatedDoctor, HashMap<String, Doctor> doctorHash) throws Exception {
        //Variable of check database status
        boolean checkExistDBI = true;
        //Variable of update doctor status
        boolean result = false;
        UpdatedDoctor = this.getDoctor(doctorHash);
        getInput getInput = new getInput();
        if (UpdatedDoctor == null) {
            checkExistDBI = false;
        }

        //Check database
        if (checkExistDBI) {

            //check if code exist or not
            if (UpdatedDoctor.getCode().isEmpty()) {
                return result;
            } else {
                System.out.println("--------- Update Doctor ---------");
                //save old data of update doctor
                String oldCode = UpdatedDoctor.getCode();
                String oldName = UpdatedDoctor.getName();
                String oldSpecialization = UpdatedDoctor.getSpecialization();
                int oldAvailability = UpdatedDoctor.getAvailability();
                //input code of doctor
                String code = getInput.StringInput("Enter Code:");
                UpdatedDoctor.setCode(code);
                //input name of doctor
                String name = getInput.StringInput("Enter Name:");
                UpdatedDoctor.setName(name);
                //input specialization
                String specialization = getInput.StringInput("Enter Specialization: ");
                UpdatedDoctor.setSpecialization(specialization);
                //input availability
                int availability = getInput.IntegerInput("Enter Availability: ");
                UpdatedDoctor.setAvailability(availability);
                boolean checkID = checkDuplicated(UpdatedDoctor, doctorHash);
                //If the code is not exist. Add the doctor.
                if (!checkID) {
                    //doctorHash.put(UpdatedDoctor.getCode(), UpdatedDoctor);
                    doctorHash.remove(oldCode);
                    doctorHash.put(UpdatedDoctor.getCode(), UpdatedDoctor);
                    result = true;
                } else {
                    System.out.println("Doctor code [Code] is duplicate");
                    UpdatedDoctor.setCode(oldCode);
                    UpdatedDoctor.setName(oldName);
                    UpdatedDoctor.setSpecialization(oldSpecialization);
                    UpdatedDoctor.setAvailability(oldAvailability);
                    result = false;
                }

            }
        }
        return result;
    }

    //Delete Doctor
    public boolean deleteDoctor(Doctor Doctor, HashMap<String, Doctor> doctorHash) throws Exception {
        boolean checkExistDBI = true;
        boolean result = false;
        Doctor = this.getDoctor(doctorHash);
        if (Doctor == null) {
            checkExistDBI = false;
        }

        if (checkExistDBI) {

            //Check if doctor is exist
            if (Doctor.getCode().isEmpty()) {
                return result;
            } else {
                System.out.println("--------- Delete Doctor ---------");
                //remove Doctor if input and Doctor's code are the same.    
                String code = Doctor.getCode();
                doctorHash.entrySet().removeIf(entry -> entry.getValue().getCode().equalsIgnoreCase(code));
                result = true;
            }

        }
        return result;
    }

    //Function return Doctor according ID requirement
    public Doctor getDoctor(HashMap<String, Doctor> doctorHash) throws Exception {
        getInput getInput = new getInput();
        Doctor doctor = null;
        //check if database is null 
        if (doctorHash == null) {
            return doctor;
        } else {
            doctor = new Doctor();
            boolean checkExist = false;
            String code = getInput.StringInput("Enter Code:");
            //Loop : Access all elements of hashmap     
            for (Map.Entry<String, Doctor> entry : doctorHash.entrySet()) {
                //If the doctor is found. Break the loop       
                if (entry.getKey().equalsIgnoreCase(code)) {
                    doctor = entry.getValue();
                    checkExist = true;
                    break;
                }
            }
            //check if the code is exist or not
            if (checkExist == false) {
                doctor = new Doctor();
                doctor.setCode("");
                System.out.println("Doctor code doesn’t exist");
            }
        }
        return doctor;
    }

    //Search Doctor.
    public HashMap<String, Doctor> searchDoctor(String input, HashMap<String, Doctor> doctorHash) throws Exception {

        HashMap<String, Doctor> searchDoctor = new HashMap<>();
        //Check database
        if (doctorHash == null) {
            //System.out.println("Database does not exist3");
            searchDoctor = null;
        } else {
            System.out.println("--------- Search ---------");
            Scanner sc = new Scanner(System.in);
            //Enter the required text
            System.out.print("Enter text: ");
            input = sc.nextLine();
            input = input.toLowerCase();

            //Loop run through all elements in the hashmap. After this, we get required doctor.  
            for (Map.Entry<String, Doctor> entry : doctorHash.entrySet()) {
                //Find according to Code
                if (entry.getValue().getCode().toLowerCase().contains(input)) {
                    searchDoctor.put(entry.getKey(), entry.getValue());
                }
                //Find according to Specialization
                if (entry.getValue().getSpecialization().toLowerCase().contains(input)) {
                    searchDoctor.put(entry.getKey(), entry.getValue());
                }
                //Find according to Name
                if (entry.getValue().getName().toLowerCase().contains(input)) {
                    searchDoctor.put(entry.getKey(), entry.getValue());
                }
            }
            if (searchDoctor.isEmpty()) {
                System.out.println("Not found!");
            }

        }

        return searchDoctor;
    }

    public boolean checkDuplicated(Doctor dr, HashMap<String, Doctor> doctorHash) {
        boolean result = false;
        //Loop access all elements in hashmap.
        for (Map.Entry<String, Doctor> entry : doctorHash.entrySet()) {
            //If the doctor is found. Break the loop       
            if (entry.getKey().equalsIgnoreCase(dr.getCode()) && entry.getValue() != dr) {
                result = true;
                break;
            }
        }
        return result;
    }

    //traverse
    public void traverse(HashMap<String, Doctor> doctorHash) {

        if (doctorHash == null) {
            System.out.println("Unsuccessfully");
            return;
        } else {
            if (!doctorHash.isEmpty()) {

                //Sorting HashMap 
                TreeMap<String, Doctor> sorted = new TreeMap<String, Doctor>(doctorHash);
                System.out.println("--------- Result ---------");
                System.out.println("Code\tName\t\tSpecialization\t\tAvailability");

                //Loop : Run from the first to the last element of HashMap
                for (Map.Entry<String, Doctor> entry : sorted.entrySet()) {

                    //Display attributes of Doctors according to format       
                    System.out.print(entry.getValue().getCode() + "\t");
                    System.out.print(entry.getValue().getName() + "\t\t");
                    System.out.print(entry.getValue().getSpecialization() + "\t\t       ");
                    System.out.print(entry.getValue().getAvailability());
                    System.out.println("");
                }
            }

        }

    }
}
