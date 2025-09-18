package com.example.vehiclerental;

public class Car extends Vehicle implements Insurable {
    public Car(String num, double rate) { super(num, "Car", rate); }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() { return 1500; }

    @Override
    public String getInsuranceDetails() { return "Comprehensive Car Insurance"; }
}

