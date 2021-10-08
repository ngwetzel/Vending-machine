package com.techelevator;



import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;


public abstract class Item {
    private String name;
    private String price;

    public Item(String name, String price) {
        this.name = name;
        this.price = price;
    }

    public TreeMap<String, String> fileReaderForInventory() {

    }

    public abstract String getSound();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
