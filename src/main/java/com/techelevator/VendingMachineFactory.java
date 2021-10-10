package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VendingMachineFactory {
    private File vendingMachineFile;
    private List<String> inventoryList;
    private String[] slotLocation;
    private String[] productName;
    private Double[] price;
    private String[] type;
    private int[] stock;
    DecimalFormat newFormat = new DecimalFormat("#.00");

    public VendingMachineFactory(String fileName) {
        vendingMachineFile = new File(fileName);
        inventoryList = new ArrayList<>();

        try (Scanner dataInput = new Scanner(vendingMachineFile)) {

            while (dataInput.hasNextLine()) {
                inventoryList.add(dataInput.nextLine());
            }

        } catch (FileNotFoundException e) {
            System.err.println("File not found. Please try again.");
        }


    }

    public void inventorySeparator() {
        this.slotLocation = new String[inventoryList.size()];
        this.productName = new String[inventoryList.size()];
        this.price = new Double[inventoryList.size()];
        this.type = new String[inventoryList.size()];
        this.stock = new int[inventoryList.size()];


        for (int i = 0; i < inventoryList.size(); i++) {
            String[] pieces = inventoryList.get(i).split("\\|");
            slotLocation[i] = pieces[0];
            productName[i] = pieces[1];
            price[i] = Double.parseDouble(pieces[2]);
            type[i] = pieces[3];
            stock[i] = 5;
        }
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

    public File getVendingMachineFile() {
        return vendingMachineFile;
    }

    public List<String> getInventoryList() {
        return inventoryList;
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




}






