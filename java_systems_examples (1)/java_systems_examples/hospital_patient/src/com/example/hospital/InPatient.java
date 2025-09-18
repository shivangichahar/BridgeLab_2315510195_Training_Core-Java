package com.example.hospital;

import java.util.ArrayList;
import java.util.List;

public class InPatient extends Patient implements MedicalRecord {
    private int daysAdmitted;
    private List<String> records = new ArrayList<>();

    public InPatient(String id, String name, int age, int days) { super(id, name, age); this.daysAdmitted = days; }

    @Override
    public double calculateBill() {
        return daysAdmitted * 2000 + 5000; // room + fixed charges
    }

    @Override
    public void addRecord(String record) { records.add(record); }

    @Override
    public String viewRecords() { return String.join(";", records); }
}

