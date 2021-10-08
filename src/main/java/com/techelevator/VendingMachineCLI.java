package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Vending Machine Command Line Interface application
public class VendingMachineCLI {

	public static void main(String[] args) {
		// Make some objects here!

		/*
		(1) Display Vending Machine Items
				Call
		(2) Purchase
			(1) Feed Money
			(2) Select Product
			(3) Finish Transaction

			Current Money Provided: $0.00
		(3) Exit

		--Create a log along the way Log.txt
		 */

		File vendingMachineFile = new File("vendingmachine.csv"); //eager instantiation
		List<String> inventoryList = new ArrayList<>();
		String[] slotLocation;
		String[] productName;
		String[] price;
		String[] type;
		int[] stock;

		try (Scanner dataInput = new Scanner(vendingMachineFile)) {

			while (dataInput.hasNextLine()) {
				inventoryList.add(dataInput.nextLine());
			}

		} catch (FileNotFoundException e) {
			System.err.println("File not found. Please try again.");
		}

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


		public void displayVendingMachineItems() {
			for (int i = 0; i < slotLocation.length; i++) {
				if (stock[i] == 0) {
					System.out.println(slotLocation[i] + " " + productName[i] + " is SOLD OUT.");
				} else {
					System.out.println(slotLocation[i] + "  " + productName[i] + " for $" + price[i]);
				}

			}


	}
}
