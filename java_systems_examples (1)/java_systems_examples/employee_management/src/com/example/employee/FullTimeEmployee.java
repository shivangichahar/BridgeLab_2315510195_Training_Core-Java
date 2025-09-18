package com.example.employee;

public class FullTimeEmployee extends Employee {
    private double fixedAllowance;

    public FullTimeEmployee(String id, String name, double baseSalary, double fixedAllowance) {
        super(id, name, baseSalary);
        this.fixedAllowance = fixedAllowance;
    }

    public double getFixedAllowance() { return fixedAllowance; }
    public void setFixedAllowance(double fixedAllowance) { this.fixedAllowance = fixedAllowance; }

    @Override
    public double calculateSalary() {
        return getBaseSalary() + fixedAllowance;
    }
}

