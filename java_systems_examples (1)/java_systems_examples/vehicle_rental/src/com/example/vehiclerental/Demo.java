package com.example.vehiclerental;

import java.util.Arrays;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        List<Vehicle> vehicles = Arrays.asList(
            new Car("KA01AB1234", 2500),
            new Bike("KA02BC5678", 600),
            new Truck("KA03CD9012", 5000)
        );

        for (Vehicle v : vehicles) {
            System.out.println("Vehicle: " + v.getVehicleNumber() + " (" + v.getType() + ")");
            System.out.println("Rental for 3 days: " + v.calculateRentalCost(3));
            if (v instanceof Insurable) {
                Insurable ins = (Insurable) v;
                System.out.println("Insurance: " + ins.calculateInsurance() + " -> " + ins.getInsuranceDetails());
            }
            System.out.println("-----");
        }
    }
}

