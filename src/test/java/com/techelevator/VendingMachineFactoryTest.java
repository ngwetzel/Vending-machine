package com.techelevator;
import org.junit.*;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class VendingMachineFactoryTest {

    @Test
    public void fileReader_withFile() {
        VendingMachineFactory testMachine = new VendingMachineFactory("vendingmachine.csv");

        try (Scanner fileInput = new Scanner(testMachine.getVendingMachineFile())) {
            int lineNumber = 0;
            while (fileInput.hasNextLine()) {
                String lineOfInput = fileInput.nextLine();
                Assert.assertEquals(lineOfInput, testMachine.getInventoryList().get(lineNumber));
                lineNumber++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }


    }

    @Test
    public void fileReader_withNotFile() {
        VendingMachineFactory testMachine = new VendingMachineFactory("vendingmachine.csv");

        boolean isNotFile = true;
        if (testMachine.getVendingMachineFile().isFile()) {
            isNotFile = false;
        }

        Assert.assertEquals(!testMachine.getVendingMachineFile().isFile(), isNotFile);
    }

    @Test
    public void fileReader_SlotBreakdown() {
        VendingMachineFactory testMachine = new VendingMachineFactory("vendingmachine.csv");
        testMachine.inventorySeparator();

        String[] testArray = new String[] {"A1", "A2", "A3", "A4",
                "B1", "B2", "B3", "B4",
                "C1", "C2", "C3", "C4",
                "D1", "D2", "D3", "D4"};

        Assert.assertArrayEquals(testArray, testMachine.getSlotLocation());
    }


//    @Test
//    public void displaySlotTest() {
//        VendingMachineFactory sut = new VendingMachineFactory();
//        sut.displayVendingMachineItems();
//        Assert.assertEquals("A1", sut.getSlotLocation()[0]);
//    }

//    @Test
//    public void displayPriceTest() {
//        VendingMachineFactory sut = new VendingMachineFactory();
//        sut.displayVendingMachineItems();
//        double test = 3.65;
//        double testValue = sut.getPrice()[3];
//        Assert.assertEquals(test, testValue, 0.0);
//    }
//
//    @Test
//    public void display_sold_out_Test() {
//        VendingMachineFactory sut = new VendingMachineFactory();
//        sut.getStock()[1] = 0;
//        sut.displayVendingMachineItems();
//        Assert.assertEquals("A2 Stackers is SOLD OUT.", sut.getSlotLocation()[1] + " " + sut.getProductName()[1] + " is SOLD OUT.");
//    }
}