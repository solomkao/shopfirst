package com.solomka;

import com.solomka.enums.Age;

public class Appliance extends ElectonicsProduct{
    public Appliance(String name, double price, int quantity, Age ageRestriction) {
        super(name, price, quantity, ageRestriction);
        super.guaranteePeriod = 6;
    }
}
