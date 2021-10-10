package com.techelevator;

import java.util.Scanner;

public class User {
    private String input;
    private Scanner keyboard;

    public User() {
        input = "";
        keyboard = new Scanner(System.in);
    }

    public String getUserInput(){
        this.input = keyboard.nextLine();
        return input;
    }

    public String getInput() {
        return input;
    }
}
