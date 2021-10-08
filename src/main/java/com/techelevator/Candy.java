package com.techelevator;

public class Candy extends Item {

    public Candy(String name, String price) {
        super(name, price);
    }

    public String getSound() {
        return "\"Munch Munch, Yum!\"";
    }

}