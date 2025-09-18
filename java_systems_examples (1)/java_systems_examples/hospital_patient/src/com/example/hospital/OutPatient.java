package com.example.hospital;

import java.util.ArrayList;
import java.util.List;

public class OutPatient extends Patient implements MedicalRecord {
    private List<String> records = new ArrayList<>();

    public OutPatient(String id, String name, int age) { super(id, name, age); }

    @Override
    public double calculateBill() {
        return 500 + 200; // consultation + tests
    }

    @Override
    public void addRecord(String record) { records.add(record); }

    @Override
    public String viewRecords() { return String.join(";", records); }
}

