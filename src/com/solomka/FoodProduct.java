package com.solomka;

import com.solomka.enums.Age;
import com.solomka.interfaces.Expirable;

import java.util.Calendar;

public class FoodProduct extends Product implements Expirable {
    private Calendar expiryDate;

    public FoodProduct(String name, double price, int quantity, Age ageRestriction, Calendar expiryDate) {
        super(name, price, quantity, ageRestriction);
        this.expiryDate = expiryDate;
    }

    @Override
    public Calendar getExpirationDate() {
        return expiryDate;
    }
}
