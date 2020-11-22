package com.solomka;

import com.solomka.enums.Age;

public class ElectonicsProduct extends Product{
    protected short  guaranteePeriod;
    public ElectonicsProduct(String name, double price, int quantity, Age ageRestriction) {
        super(name, price, quantity, ageRestriction);
    }

    public short getGuaranteePeriod() {
        return guaranteePeriod;
    }
}
