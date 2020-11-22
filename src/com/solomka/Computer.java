package com.solomka;

import com.solomka.enums.Age;

public class Computer extends ElectonicsProduct{
    public Computer(String name, double price, int quantity, Age ageRestriction) {
        super(name, price, quantity, ageRestriction);
        super.guaranteePeriod = 24;
    }
}
