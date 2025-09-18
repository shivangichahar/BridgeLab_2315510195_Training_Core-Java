package com.example.vehiclerental;

public class Bike extends Vehicle implements Insurable {
    public Bike(String num, double rate) { super(num, "Bike", rate); }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days * 0.8;
    }

    @Override
    public double calculateInsurance() { return 500; }

    @Override
    public String getInsuranceDetails() { return "Third-party Bike Insurance"; }
}

