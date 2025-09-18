package com.example.ride;

import java.util.Arrays;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        List<Vehicle> fleet = Arrays.asList(
            new Car("CAR001","Rajan",15),
            new Bike("BIKE001","Rohit",8),
            new Auto("AUTO001","Kavita",6)
        );

        for (Vehicle v : fleet) {
            System.out.println(v.getVehicleDetails() + " -> Fare for 10 km: " + v.calculateFare(10));
            if (v instanceof GPS) {
                GPS gps = (GPS)v;
                gps.updateLocation("MG Road");
                System.out.println("Location: " + gps.getCurrentLocation());
            }
            System.out.println("-----");
        }
    }
}

