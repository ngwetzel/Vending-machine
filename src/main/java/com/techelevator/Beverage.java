package com.techelevator;

public class Beverage extends Item {

    public Beverage(String name, String price) {
        super(name, price);
    }

    public String getSound() {
        return "\"Glug Glug, Yum!\"";
    }

}