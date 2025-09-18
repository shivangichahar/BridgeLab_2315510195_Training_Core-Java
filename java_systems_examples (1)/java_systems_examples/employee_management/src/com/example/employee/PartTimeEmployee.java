package com.example.employee;

public class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String id, String name, double baseSalary, int hoursWorked, double hourlyRate) {
        super(id, name, baseSalary);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    public int getHoursWorked() { return hoursWorked; }
    public void setHoursWorked(int hoursWorked) { this.hoursWorked = hoursWorked; }

    @Override
    public double calculateSalary() {
        return getBaseSalary() + hoursWorked * hourlyRate;
    }
}

