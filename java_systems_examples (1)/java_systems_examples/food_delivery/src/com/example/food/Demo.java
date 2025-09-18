package com.example.food;

import java.util.Arrays;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        List<FoodItem> order = Arrays.asList(
            new VegItem("Paneer Butter Masala",200,2),
            new NonVegItem("Chicken Biryani",250,1)
        );

        double total = 0;
        for (FoodItem f : order) {
            double price = f.calculateTotalPrice();
            double discount = (f instanceof Discountable) ? ((Discountable)f).applyDiscount() : 0;
            System.out.println(f.getItemDetails() + ", Price: " + price + ", Discount: " + discount);
            total += price - discount;
        }
        System.out.println("Order Total: " + total);
    }
}

