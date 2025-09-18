package com.example.library;

import java.util.Arrays;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        List<LibraryItem> items = Arrays.asList(
            new Book("B001","Java Programming","Author A"),
            new Magazine("M001","Tech Monthly","Editor B"),
            new DVD("D001","Inception","Christopher Nolan")
        );

        for (LibraryItem item : items) {
            System.out.println(item.getItemDetails() + " -> Loan days: " + item.getLoanDuration());
            System.out.println("-----");
        }
    }
}

