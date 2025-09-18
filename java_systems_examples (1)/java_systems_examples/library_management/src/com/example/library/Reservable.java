package com.example.library;

public interface Reservable {
    boolean reserveItem(String userId);
    boolean checkAvailability();
}

