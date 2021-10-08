package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class unused_VendingMachineFactory {
    private File vendingMachineFile;
    private List<String> inventoryList = new ArrayList<>();
    private String[] slotLocation;
    private String[] productName;
    private Double[] price;
    private String[] type;
    private int[] stock;

    public unused_VendingMachineFactory(String vendingMachineFile) {
        this.vendingMachineFile = new File(vendingMachineFile);

        try (Scanner dataInput = new Scanner(this.vendingMachineFile)) {

            while(dataInput.hasNextLine()) {
                inventoryList.add(dataInput.nextLine());
            }

        } catch (FileNotFoundException e) {
            System.err.println("File not found. Please try again.");
        }

    }

    public unused_VendingMachineFactory() {

    }

    public void fileDeconstruction() {
        slotLocation = new String[inventoryList.size()];
        productName = new String[inventoryList.size()];
        price = new Double[inventoryList.size()];
        type = new String[inventoryList.size()];
        stock = new int[inventoryList.size()];


        for (int i = 0; i < inventoryList.size(); i++) {
            String[] pieces = inventoryList.get(i).split("\\|");
            slotLocation[i] = pieces[0];
            productName[i] = pieces[1];
            price[i] = Double.parseDouble(pieces[2]);
            type[i] = pieces[3];
            stock[i] = 5;
            System.out.println(slotLocation[i] + "*" + productName[i] + "*" + price[i] + "*" + type[i] + "*" + stock[i]);
        }

    }

    public void DisplayVendingMachineItems() {
        for (int i = 0; i < slotLocation.length; i++) {
            System.out.println(slotLocation[i] + " : " + productName[i] + " : " + price[i] + " : " + type[i]);
        }

    }
}