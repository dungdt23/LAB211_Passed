/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labs22_p0055;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Doctor implements Comparable<Doctor>, Serializable {

    private String Code;
    private String Name;
    private String Specialization;
    private int Availability;

    public Doctor() {
    }

    public Doctor(String Code, String Name, String Specialization, int Availability) {
        this.Code = Code;
        this.Name = Name;
        this.Specialization = Specialization;
        this.Availability = Availability;
    }

    public String getCode() {
        return Code;
    }

    public String getName() {
        return Name;
    }

    public String getSpecialization() {
        return Specialization;
    }

    public int getAvailability() {
        return Availability;
    }

    public void setCode(String Code) {
        this.Code = Code;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setSpecialization(String Specialization) {
        this.Specialization = Specialization;
    }

    public void setAvailability(int Availability) {
        this.Availability = Availability;
    }

    @Override
    public String toString() {
        return "Doctor{" + "Code=" + Code + ", Name=" + Name + ", Specialization=" + Specialization + ", Availability=" + Availability + '}';
    }

    @Override
    public int compareTo(Doctor dr) {
        return this.getCode().compareTo(dr.getCode());
    }
}
