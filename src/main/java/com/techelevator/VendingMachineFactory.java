package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VendingMachineFactory {
    private File vendingMachineFile = new File("vendingmachine.csv"); //eager instantiation
    private List<String> inventoryList = new ArrayList<>();
    private String[] slotLocation;
    private String[] productName;
    private String[] price;
    private String[] type;
    private int[] stock;

    public VendingMachineFactory() {
        try (Scanner dataInput = new Scanner(vendingMachineFile)) {

            while (dataInput.hasNextLine()) {
                inventoryList.add(dataInput.nextLine());
            }

        } catch (FileNotFoundException e) {
            System.err.println("File not found. Please try again.");
        }

    }

    public void fileDeconstruction() {
        slotLocation = new String[inventoryList.size()];
        productName = new String[inventoryList.size()];
        price = new String[inventoryList.size()];
        type = new String[inventoryList.size()];
        stock = new int[inventoryList.size()];


        for (int i = 0; i < inventoryList.size(); i++) {
            String[] pieces = inventoryList.get(i).split("\\|");
            slotLocation[i] = pieces[0];
            productName[i] = pieces[1];
            price[i] = pieces[2];
            type[i] = pieces[3];
            stock[i] = 5;
        }
//        for (int i = 0; i < inventoryList.size(); i++) {
//            if (stock[i] == 0) {
//                System.out.println(slotLocation[i] + " " + productName[i] + " is SOLD OUT.");
//            } else {
//                System.out.println(slotLocation[i] + "  " + productName[i] + " for $" + price[i]);
//            }

        }



    public String[] getSlotLocation() {
        return slotLocation;
    }

    public String[] getProductName() {
        return productName;
    }

    public String[] getPrice() {
        return price;
    }

    public String[] getType() {
        return type;
    }

    public int[] getStock() {
        return stock;
    }

    public void DisplayVendingMachineItems() {
        for (int i = 0; i < inventoryList.size(); i++) {
            if (getStock()[i] == 0) {
                System.out.println(getSlotLocation()[i] + " " + getProductName()[i] + " is SOLD OUT.");
            } else {
                System.out.println(getSlotLocation()[i] + "  " + getProductName()[i] + " for $" + getPrice()[i]);
            }

        }


    }
    }



