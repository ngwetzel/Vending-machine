package com.techelevator;

import java.io.File;

// Vending Machine Command Line Interface application
public class VendingMachineCLI {

	public static void main(String[] args) {

		VendingMachineFactory vendingMachine = new VendingMachineFactory();
		UserInteraction userInteraction = new UserInteraction();

		vendingMachine.displayVendingMachineItems();

		userInteraction.mainMenuPrint();
		userInteraction.paymentMenuPrint();

		}
	}


