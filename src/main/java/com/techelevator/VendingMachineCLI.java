package com.techelevator;

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

		VendingMachineFactory vendingMachine = new VendingMachineFactory();
		vendingMachine.fileDeconstruction();

		vendingMachine.DisplayVendingMachineItems();

		UserInteraction userInteraction = new UserInteraction();

		userInteraction.mainMenuPrint();
		userInteraction.mainMenuInteraction();

		userInteraction.paymentMenuInteraction();




	}
}
