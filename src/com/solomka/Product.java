package com.solomka;

import com.solomka.enums.Age;
import com.solomka.interfaces.Buyable;

public class Product implements Buyable {
    private String name;
    private double price;
    private int quantity;
    private Age ageRestriction;

    public Product(String name, double price, int quantity, Age ageRestriction) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.ageRestriction = ageRestriction;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public Age getAgeRestriction() {
        return ageRestriction;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public void sell() {
        this.quantity--;
    }
}
