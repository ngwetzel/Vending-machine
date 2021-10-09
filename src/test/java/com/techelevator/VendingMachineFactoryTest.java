package com.techelevator;
import org.junit.*;

import java.util.Scanner;

public class VendingMachineFactoryTest {



    @Test
    public void displaySlotTest() {
        VendingMachineFactory sut = new VendingMachineFactory();
        sut.displayVendingMachineItems();
        Assert.assertEquals("A1", sut.getSlotLocation()[0]);
    }

    @Test
    public void displayPriceTest() {
        VendingMachineFactory sut = new VendingMachineFactory();
        sut.displayVendingMachineItems();
        double test = 3.65;
        double testValue = sut.getPrice()[3];
        Assert.assertEquals(test, testValue, 0.0);
    }

    @Test
    public void display_sold_out_Test() {
        VendingMachineFactory sut = new VendingMachineFactory();
        sut.getStock()[1] = 0;
        sut.displayVendingMachineItems();
        Assert.assertEquals("A2 Stackers is SOLD OUT.", sut.getSlotLocation()[1] + " " + sut.getProductName()[1] + " is SOLD OUT.");
    }
}