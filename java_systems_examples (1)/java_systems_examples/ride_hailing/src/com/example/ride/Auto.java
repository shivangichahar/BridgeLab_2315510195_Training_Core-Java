package com.example.ride;

public class Auto extends Vehicle implements GPS {
    private String location = "Unknown";
    public Auto(String id, String driver, double rate) { super(id, driver, rate); }

    @Override
    public double calculateFare(double distance) { return getRatePerKm() * distance * 0.6; }

    @Override
    public String getCurrentLocation() { return location; }

    @Override
    public void updateLocation(String newLoc) { this.location = newLoc; }
}

