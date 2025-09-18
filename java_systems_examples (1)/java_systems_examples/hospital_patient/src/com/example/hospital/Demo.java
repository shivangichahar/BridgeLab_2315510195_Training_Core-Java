package com.example.hospital;

import java.util.Arrays;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        List<Patient> patients = Arrays.asList(
            new InPatient("P001","Sita",30,5),
            new OutPatient("P002","Gopal",40)
        );

        for (Patient p : patients) {
            System.out.println(p.getPatientDetails() + " -> Bill: " + p.calculateBill());
            if (p instanceof MedicalRecord) {
                MedicalRecord mr = (MedicalRecord)p;
                mr.addRecord("Checked on " + java.time.LocalDate.now());
                System.out.println("Records: " + mr.viewRecords());
            }
            System.out.println("-----");
        }
    }
}

