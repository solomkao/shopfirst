package com.solomka;

import com.solomka.enums.Age;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        Product milk = new FoodProduct("Burenka", 16.90, 25, Age.None,
                new GregorianCalendar(2020,Calendar.DECEMBER,1));
        Customer elena = new Customer("Elena", 17, 30.00);
        PurchaseManager.processPurchase(milk, elena);
        Product cigarettes = new FoodProduct("Prima", 11.25, 1470, Age.Adult,
                new GregorianCalendar(2021,Calendar.NOVEMBER,22));
        Customer ivan = new Customer("Ivan", 19, 11.04);
        PurchaseManager.processPurchase(cigarettes, ivan);
        Product computer = new Computer("HP", 685, 1500,Age.Teenager);
        Customer oleg = new Customer("Oleg", 27, 1020);
        PurchaseManager.processPurchase(computer, oleg);
        Product dvd = new Appliance("DVD",54,50,Age.Adult);
        PurchaseManager.processPurchase(dvd, oleg);
        PurchaseManager.processPurchase(dvd, oleg);




    }

    static class PurchaseManager {
        static void processPurchase(Product product, Customer customer) {
            if (product.getQuantity() == 0) {
                System.out.println("Sorry, " + product.getName() + " is out of stock ");
                return;
            }
            if (product.getAgeRestriction() == Age.Adult && customer.getAge() < 18) {
                System.out.println("Sorry, you're too young to buy " + product.getName());
                return;
            }
            if (product.getPrice() > customer.getBalance()) {
                System.out.println("Sorry, you don't have enough money to buy " + product.getName());
                return;
            }
            if (product instanceof FoodProduct) {
                Calendar date = ((FoodProduct) product).getExpirationDate();
                Calendar currentDate = new GregorianCalendar();
                long time = date.getTimeInMillis() - currentDate.getTimeInMillis();
                long days = TimeUnit.DAYS.convert(time, TimeUnit.MILLISECONDS);
                if (days < 0) {
                    System.out.println("Sorry, " + product.getName() + " has expired");
                    return;
                } else if (days <= 15) {
                    double newPrice = product.getPrice() * 0.7;
                    customer.pay(newPrice);
                    product.sell();
                    System.out.println(customer.getName()+" has bought "
                            +product.getName()+" for $"+Math.round(newPrice));
                    return;
                }else{
                    customer.pay(product.getPrice());
                    product.sell();
                    System.out.println(customer.getName()+" has bought "
                            +product.getName()+" for $"+product.getPrice());
                    return;
                }
            }
            if (product instanceof Computer) {
                if (product.getQuantity() > 1000) {
                    double newPrice = product.getPrice() * 0.95;
                    customer.pay(newPrice);
                    product.sell();
                    System.out.println(customer.getName()+" has bought "
                            +product.getName()+" for $"+newPrice);
                    return;
                }else{
                    customer.pay(product.getPrice());
                    product.sell();
                    System.out.println(customer.getName()+" has bought "
                            +product.getName()+" for $"+product.getPrice());
                    return;
                }
            }
            if (product instanceof Appliance) {
                if (product.getQuantity() < 50) {
                    double newPrice = product.getPrice() * 1.05;
                    customer.pay(newPrice);
                    product.sell();
                    System.out.println(customer.getName()+" has bought "
                            +product.getName()+" for $"+newPrice);
                }else{
                    customer.pay(product.getPrice());
                    product.sell();
                    System.out.println(customer.getName()+" has bought "
                            +product.getName()+" for $"+product.getPrice());
                }
            }


        }
    }
}
