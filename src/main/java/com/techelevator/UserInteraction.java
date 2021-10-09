package com.techelevator;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.text.DecimalFormat;


public class UserInteraction {
    private VendingMachineFactory vendingMachineUX = new VendingMachineFactory();
    private Scanner keyboard = new Scanner(System.in);
    private String mainMenuChoice;
    private String paymentMenuChoice;
    private String productSelection;
    LocalDateTime currentDate = LocalDateTime.now();
    DecimalFormat newFormat = new DecimalFormat("#.00");
    private double balance;

    public void mainMenuPrint() {
        System.out.println("\nPlease make your selection. (1, 2, or 3)\n" +
                "1. Display Vending Machine Items\n" +
                "2. Purchase\n" +
                "3. Exit\n");

        mainMenuChoice = keyboard.nextLine();
        mainMenuInteraction(mainMenuChoice);
    }

    public void mainMenuInteraction(String mainMenuChoice) {
        boolean isValidInput = false;
        while (!isValidInput) {
            if (this.mainMenuChoice.equals("1")) {
                isValidInput = true;
                vendingMachineUX.displayVendingMachineItems();
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
                System.err.println("Input invalid. Please try again.");
                mainMenuPrint();
            }
        }
    }


    public void paymentMenuPrint() {
        System.out.println("\nPlease make your selection. (1, 2, or 3)\n" +
                "1. Feed Money\n" +
                "2. Select Product\n" +
                "3. Finish Transaction\n\n" +
                "Current balance is: " + newFormat.format(balance) + "\n");

        paymentMenuChoice = keyboard.nextLine();
        paymentMenuInteraction(paymentMenuChoice);
    }

    public void paymentMenuInteraction(String paymentMenuChoice) {
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
                System.err.println("Input invalid. Please try again.");
                paymentMenuPrint();
            }
        }
    }

    public void feedMoney() {
        System.out.println("How much money would you like to add?");
        String feed = keyboard.nextLine();
        double newBalance = 0.0;
        try {
            if (Integer.parseInt(feed) > 0) {
                newBalance = balance + Integer.parseInt(feed);
            } else {
                System.err.println("Invalid payment. Please pay in a whole dollar amount.");
                paymentMenuPrint();
            }
        } catch (NumberFormatException e) {
            System.err.println("Invalid payment. Please pay in a whole dollar amount.");
            paymentMenuPrint();
        }

        //Logs to file
        try (FileWriter forLog = new FileWriter("Log.txt", true);
             PrintWriter log = new PrintWriter(forLog)) {
            log.append(currentDate + " FEED MONEY " + " \\ " + newFormat.format(balance) + " \\ " + newFormat.format(newBalance) + ".").println();
        } catch (IOException e) {
            e.printStackTrace();
        }
        balance = newBalance;
        System.out.println("Your total balance is now: " + newFormat.format(balance));
        paymentMenuPrint();
    }

    public void selectProduct() {
        vendingMachineUX.displayVendingMachineItems();

        System.out.println("Please select a product based on its slot location: ");
        productSelection = keyboard.nextLine();
        double newBalance = 0;
        int index = 0;

        //Loops through to see if input equals any of the slot locations,
        // if it reaches last one and does not equal any up to the last one it outputs an invalid entry error
        for (int i = 0; i < vendingMachineUX.getSlotLocation().length; i++) {

            if (productSelection.equals(vendingMachineUX.getSlotLocation()[i])) {
                index = i;
                if (balance < vendingMachineUX.getPrice()[i]) { //Catches insufficient funds
                    System.err.println("Insufficient funds. Please feed money and try again.");
                    break;
                } else if (vendingMachineUX.getStock()[i] == 0) { //Catches if someone tries to get something out of stock
                    System.err.println("Insufficient stock. Please try another item or come back later.");
                    break;
                }

                vendingMachineUX.getStock()[i] = vendingMachineUX.getStock()[i] - 1; //Decrements stock
                newBalance = balance - vendingMachineUX.getPrice()[index]; //Establishes new balance in machine

                if (vendingMachineUX.getType()[index].equals("Chip")) {
                    System.out.println("Crunch Crunch, Yum!");
                } else if (vendingMachineUX.getType()[index].equals("Candy")) {
                    System.out.println("Munch Munch, Yum!");
                } else if (vendingMachineUX.getType()[index].equals("Drink")) {
                    System.out.println("Glug Glug, Yum!");
                } else if (vendingMachineUX.getType()[index].equals("Gum")) {
                    System.out.println("Chew Chew, Yum!");
                }
                break;

            } else if (!productSelection.equals(vendingMachineUX.getSlotLocation()[i]) && (i == vendingMachineUX.getSlotLocation().length - 1)) {
                System.err.println("Invalid slot location. Please try again with a valid slot location.");
                break;
            }
        }

        try (FileWriter forLog = new FileWriter("Log.txt", true);
             PrintWriter log = new PrintWriter(forLog)) {
            //Logs a Get Product action in the Log.txt
            log.append(currentDate + " " + vendingMachineUX.getProductName()[index] + " " +
                    vendingMachineUX.getSlotLocation()[index] +
                    " \\ " + newFormat.format(balance) + " \\ " + newFormat.format(newBalance)).println();

            //Sets total balance to equal new balance after logged
            balance = newBalance;
        } catch (IOException e) {
            e.printStackTrace();
        }

        paymentMenuPrint();
    }

    public void changeMaker(double remainingBalance) {
        double precision = Math.round(remainingBalance * 100) / 100;
        double forInt = precision * 100;
        int forChange = ((int) forInt);
        int quarters = 0;
        int dimes = 0;
        int nickels = 0;
        int pennies = 0;

        //Determines number of coins to be given
        if (forChange == 0) {
            System.out.println("You have a remaining balance of 0.");
        }

        if ((forChange / 25) >= 1) {
            quarters = (forChange / 25);
            forChange = forChange - (quarters * 25);
        }
        if ((forChange / 10) >= 1) {
            dimes = (forChange / 10);
            forChange = forChange - (dimes * 10);
        }
        if ((forChange / 5) >= 1) {
            nickels = (forChange / 5);
            forChange = forChange - (nickels * 5);
        }
        if (forChange >= 0) {
            pennies = forChange;
        }

        //Prints our respect
        System.out.print("Your change is ");
        if (quarters > 0) {
            System.out.print(quarters + " quarter(s) ");
        }
        if (dimes > 0) {
            System.out.print(dimes + " dime(s) ");
        }
        if (nickels > 0) {
            System.out.print(nickels + " nickel(s) ");
        }
        if (pennies > 0) {
            System.out.println(pennies + " pennie(s) ");
        }

        System.out.println("for $" + newFormat.format(remainingBalance) + ".");

        //Logs to file
        try (FileWriter forLog = new FileWriter("Log.txt", true);
             PrintWriter log = new PrintWriter(forLog)
        ) {
            Scanner openFile = new Scanner("Log.txt");
            log.append(currentDate + " GIVE CHANGE: " + newFormat.format(balance) + " $0.00.\n\\`\\`\\`\n");

        } catch (IOException e) {
            e.printStackTrace();
        }

        this.balance = 0; //balance reset to 0 at end of transaction
    }

    public String getMainMenuChoice() {
        return mainMenuChoice;
    }

    public void setMainMenuChoice(String mainMenuChoice) {
        this.mainMenuChoice = mainMenuChoice;
    }

    public String getPaymentMenuChoice() {
        return paymentMenuChoice;
    }

    public void setPaymentMenuChoice(String paymentMenuChoice) {
        this.paymentMenuChoice = paymentMenuChoice;
    }

    public String getProductSelection() {
        return productSelection;
    }

    public void setProductSelection(String productSelection) {
        this.productSelection = productSelection;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

}