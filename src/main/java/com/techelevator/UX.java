package com.techelevator;

import java.util.Scanner;

public class UX {

    public UX() {
    }

    Double balance = 0.00;

public void mainMenu() {
    System.out.println("Greetings User!");
    System.out.println("Please make your selection. Please choose 1-3.");
    System.out.println("1.  Display Vending Machine Items");
    System.out.println("2.  Purchase");
    System.out.println("3.  Exit");
    Scanner input = new Scanner(System.in);
    String choice = input.nextLine();

}

public void purchaseMenu() {
    System.out.println("Please make your selection (1-3)");
    System.out.println("1.  Feed Money");
    System.out.println("2.  Select Product");
    System.out.println("3.  Finish Transaction");
    Scanner input = new Scanner(System.in);
    String purchaseChoice = input.nextLine();
}

public void feedMoney() {
    System.out.println("How much money would you like to add?");
    Scanner input = new Scanner(System.in);
    String feed = input.nextLine();
    this.balance = balance + Double.parseDouble(feed);
    System.out.println("Your total balance is now" + balance + ".");
    purchaseMenu();
    // printwriter to append log.txt Feed Money old balance/ new balance
}

public void selectProduct() {



}


}
