package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VendingMachineFactory {
    private static File vendingMachineFile = new File("vendingmachine.csv"); //eager instantiation
    private List<String> inventoryList = new ArrayList<>();
    private String[] slotLocation;
    private String[] productName;
    private Double[] price;
    private String[] type;
    private int[] stock;
    DecimalFormat newFormat = new DecimalFormat("#.00");

    public VendingMachineFactory() {
        try (Scanner dataInput = new Scanner(vendingMachineFile)) {

            while (dataInput.hasNextLine()) {
                inventoryList.add(dataInput.nextLine());
            }

        } catch (FileNotFoundException e) {
            System.err.println("File not found. Please try again.");
        }

        slotLocation = new String[inventoryList.size()];
        productName = new String[inventoryList.size()];
        price = new Double[inventoryList.size()];
        type = new String[inventoryList.size()];
        stock = new int[inventoryList.size()];


        for (int i = 0; i < inventoryList.size(); i++) {
            String[] pieces = inventoryList.get(i).split("\\|");
            this.slotLocation[i] = pieces[0];
            this.productName[i] = pieces[1];
            this.price[i] = Double.parseDouble(pieces[2]);
            this.type[i] = pieces[3];
            this.stock[i] = 5;
        }
    }

    public String[] getSlotLocation() {
        return slotLocation;
    }

    public String[] getProductName() {
        return productName;
    }

    public Double[] getPrice() {
        return price;
    }

    public String[] getType() {
        return type;
    }

    public int[] getStock() {
        return stock;
    }


    public void displayVendingMachineItems() {
        String productDisplay = "";
        for (int i = 0; i < inventoryList.size(); i++) {
            if (getStock()[i] == 0) {
                productDisplay = slotLocation[i] + " " + productName[i] + " is SOLD OUT.";
                System.out.println(productDisplay);
            } else {
                productDisplay =  slotLocation[i] + " " + productName[i] + " for $" + newFormat.format(price[i]);
                System.out.println(productDisplay);
            }

        }

    }

}






