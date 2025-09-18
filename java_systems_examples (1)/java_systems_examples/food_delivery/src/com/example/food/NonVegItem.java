package com.example.food;

public class NonVegItem extends FoodItem implements Discountable {
    public NonVegItem(String name, double price, int qty) { super(name, price, qty); }

    @Override
    public double calculateTotalPrice() { return getPrice() * getQuantity() + 30; }

    @Override
    public double applyDiscount() { return calculateTotalPrice() * 0.03; }

    @Override
    public String getDiscountDetails() { return "Non-Veg 3% discount with extra charge"; }
}

