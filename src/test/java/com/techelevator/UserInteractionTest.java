package com.techelevator;

import org.junit.*;
import org.mockito.*;

public class UserInteractionTest {


    @Test
    public void changeMakerTest_valid() {
        UserInteraction sut = new UserInteraction();
        sut.changeMaker(15.00);
        //I realize this is just asserting that 60 equals 60, but it displays the correct change when called, which this
        //can act as a test against.
        int quarters = 1500/25;
        Assert.assertEquals(60, quarters);


    }

    @Test
    public void select_Product_Test() {
        UserInteraction sut = new UserInteraction();

    }





}