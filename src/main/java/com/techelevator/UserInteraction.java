package com.techelevator;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class UserInteraction {
    private VendingMachineFactory vendingMachineUX = new VendingMachineFactory();
    private Scanner keyboard = new Scanner(System.in);
    private double balance; //really need this to print out with 2 decimal places
    private String mainMenuChoice;
    private String paymentMenuChoice;
    private String productSelection;



    public void mainMenuPrint() {
        System.out.println("\nPlease make your selection. Please choose 1-3.\n" +
                "1. Display Vending Machine Items\n" +
                "2. Purchase\n"+
                "3. Exit\n");

        mainMenuChoice = keyboard.nextLine();
    }

    public void mainMenuInteraction() {
        boolean isValidInput = false;
        while (!isValidInput) {
            if (this.mainMenuChoice.equals("1")) {
                isValidInput = true;
                vendingMachineUX.DisplayVendingMachineItems(); //Display list of items ----- THIS is causing an error and I can't quite figure out the reason
                System.out.println("INSERT DISPLAY HERE"); //Temporary
                mainMenuPrint(); //Return to main menu screen
            } else if (mainMenuChoice.equals("2")) {
                isValidInput = true;
                paymentMenuPrint(); //Takes you to payment menu
            } else if (mainMenuChoice.equals("3")) {
                isValidInput = true;
                System.out.println("Thank you for using the Vendo-Matic 800. Please vend with us again soon!");
                System.exit(0); //Exits the program completely
            } else {
                isValidInput = false;
                System.err.println("Input invalid. Please choose 1, 2, or 3.\n" +
                        "1. Display Vending Machine Items\n" +
                        "2. Purchase\n"+
                        "3. Exit\n");
                mainMenuChoice = keyboard.nextLine();
            }
        }
    }



    public void paymentMenuPrint() {
        System.out.println("Please make your selection.\n" +
                "1. Feed Money\n" +
                "2. Select Product\n" +
                "3. Finish Transaction\n\n" +
                "Current balance is: " + balance);

        paymentMenuChoice = keyboard.nextLine();

    }

    public void paymentMenuInteraction() {
        boolean isValidInput = false;
        while (!isValidInput) {
            if (this.paymentMenuChoice.equals("1")) {
                feedMoney(); //Goes to feedMoney method
                isValidInput = true;
            } else if (paymentMenuChoice.equals("2")) {
                isValidInput = true;
                selectProduct(); //Method to select the product
            } else if (paymentMenuChoice.equals("3")) {
                isValidInput = true;
                changeMaker(balance);
                mainMenuPrint(); //Takes user to main menu
            } else {
                isValidInput = false;
                System.err.println("Input invalid. Please choose 1, 2, or 3.\n" +
                        "1. Feed Money\n" +
                        "2. Select Product\n" +
                        "3. Finish Transaction\n\n" +
                        "Current balance is: " + balance);
                paymentMenuChoice = keyboard.nextLine();
            }
        }
    }

    public void feedMoney(){
        System.out.println("How much money would you like to add?");
        String feed = keyboard.nextLine();
        balance += Double.parseDouble(feed);

        System.out.println("Your total balance is now: " + balance);

        paymentMenuPrint();
    }

    public void selectProduct() {
        vendingMachineUX.DisplayVendingMachineItems(); //It's weird because this doesn't cause an error, but also doesn't print

        System.out.println("Please select a product based on its slot location: ");
        productSelection = keyboard.nextLine();
        int newBalance = 0;
        try(FileWriter forLog = new FileWriter("Log.txt");
            PrintWriter log = new PrintWriter(forLog)) {
        int index = 0;
        for (int i = 0; i < vendingMachineUX.getSlotLocation().length; i++) {
            if (productSelection.equals(vendingMachineUX.getSlotLocation()[i])) {
                index = i;
                // remove cost vendingMachineUX.getPrice()[index] from balance.
                // vendingMachineUX.stock()[index]--;
                // newBalance = balance - vendingMachineUX.getPrice()[index]
                // log.append(date/time + " " + vendingMachineUX.getProductName()[index] + " " + vendingMachineUX.getSlotLocation()[index] + " / " + balance + " / " + newBalance
                //balance = newBalance;

            }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        int indexNumber;
//
//        for (int i = 0; i < vendingMachineUX.getSlotLocation(); i++) {
//            if (productSelection.equalsIgnoreCase(slotID)) {
//                indexNumber = slotID.;
//
//                System.out.println(vendingMachineUX.getProductName().indexOf());
//            } else {
//                //
//            }
//        }

    }

    public void changeMaker(double remainingBalance) {

        double forInt = remainingBalance * 100;
        String isInt = "" + remainingBalance + "";
        int forChange = Integer.parseInt(isInt);
        int quarters = 0;
        int dimes = 0;
        int nickels = 0;
        int pennies = 0;

        if (forChange == 0) {
            System.out.println("You have a remaining balance of 0.");
        } else if ((forChange / 25) > 1) {
            quarters = (forChange / 25);
            forChange = forChange - (quarters * 25);
        } else if ((forChange / 10) > 1) {
            dimes = (forChange / 10);
            forChange = forChange - (dimes * 10);
        } else if ((forChange / 5) > 1) {
            nickels = forChange / 5;
            forChange = forChange - (nickels * 5);
        } else if (forChange > 0) {
            pennies = forChange;
        }
        System.out.print("Your change is ");
        if (quarters > 0) {
            System.out.print(quarters + "quarters, ");
        } else if (dimes > 0) {
            System.out.print(dimes + "dimes, ");
        } else if (nickels > 0) {
            System.out.print(nickels + "nickels, ");
        } else if (pennies > 0) {
            System.out.println(pennies + "pennies.");
        }
        System.out.println("For " + remainingBalance + ".");


        //Something taking in the remaining balance and determining how much it will be in coins
        balance = 0; //balance reset to 0 at this point

    }

}
