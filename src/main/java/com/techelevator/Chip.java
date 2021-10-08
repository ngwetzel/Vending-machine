package com.techelevator;

public class Chip extends Item {

    public Chip(String name, String price) {
        super(name, price);
    }

    public String getSound() {
        return "\"Crunch Crunch, Yum!\"";
    }

}
