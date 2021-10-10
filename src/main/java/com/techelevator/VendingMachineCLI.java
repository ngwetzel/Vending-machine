package com.techelevator;

import java.io.File;

// Vending Machine Command Line Interface application
public class VendingMachineCLI {

	public static void main(String[] args) {

		VendingMachineFactory vendomatic800 = new VendingMachineFactory("vendingmachine.csv"); //Creating new vending machine
		UserInteraction userInteraction = new UserInteraction(vendomatic800);

		vendomatic800.displayVendingMachineItems();

		userInteraction.mainMenuPrint();
		userInteraction.paymentMenuPrint();

		}
	}


