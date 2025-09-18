package com.example.ecommerce;

import java.util.Arrays;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Electronics("E001","Laptop",70000),
            new Clothing("C001","T-Shirt",799),
            new Groceries("G001","Rice",1200)
        );

        for (Product p : products) {
            double tax = (p instanceof Taxable) ? ((Taxable)p).calculateTax() : 0;
            double discount = p.calculateDiscount();
            double finalPrice = p.getPrice() + tax - discount;
            System.out.println(p.getName() + " -> Base: " + p.getPrice() + ", Tax: " + tax + ", Discount: " + discount + ", Final: " + finalPrice);
        }
    }
}

