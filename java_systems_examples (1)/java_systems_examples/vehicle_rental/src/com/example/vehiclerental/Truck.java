package com.example.vehiclerental;

public class Truck extends Vehicle implements Insurable {
    public Truck(String num, double rate) { super(num, "Truck", rate); }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days * 1.5;
    }

    @Override
    public double calculateInsurance() { return 3000; }

    @Override
    public String getInsuranceDetails() { return "Heavy Vehicle Insurance"; }
}

