package com.techreturner;

import org.junit.Test;

import static org.junit.Assert.*;

public class checkFrameTest {



    @Test
    public void checkStrikeTest(){
        Frame aFrame = new Frame();
        aFrame.addRoll("X");
        assertTrue("It is strike", aFrame.isStrike());
        assertFalse("It is not spare.", aFrame.isSpare());
        assertTrue("Frame is close", aFrame.isClose());
        assertEquals(10, aFrame.getFirstRoll());
        assertEquals(0, aFrame.getSecondRoll());
        assertEquals(10, aFrame.getTotalScore());
    }

    @Test
    public void checkSpareTest(){
        Frame aFrame = new Frame();
        aFrame.addRoll("5");
        aFrame.addRoll("/");
        assertFalse("It is strike", aFrame.isStrike());
        assertTrue("It is not spare.", aFrame.isSpare());
        assertTrue("Frame is close", aFrame.isClose());
        assertEquals(5, aFrame.getFirstRoll());
        assertEquals(5, aFrame.getSecondRoll());
        assertEquals(10, aFrame.getTotalScore());
    }

    @Test
    public void checkTwoRowsTest(){
        Frame aFrame = new Frame();
        aFrame.addRoll("2");
        aFrame.addRoll("3");
        assertFalse("It is strike", aFrame.isStrike());
        assertFalse("It is not spare.", aFrame.isSpare());
        assertTrue("Frame is close", aFrame.isClose());
        assertEquals(2, aFrame.getFirstRoll());
        assertEquals(3, aFrame.getSecondRoll());
        assertEquals(5, aFrame.getTotalScore());
    }

    @Test
    public void checkOneRowsTest(){
        Frame aFrame = new Frame();
        aFrame.addRoll("9");
        assertFalse("It is strike", aFrame.isStrike());
        assertFalse("It is not spare.", aFrame.isSpare());
        assertFalse("Frame is close", aFrame.isClose());
        assertEquals(9, aFrame.getFirstRoll());
        assertEquals(0, aFrame.getSecondRoll());
        assertEquals(9, aFrame.getTotalScore());
    }

    @Test
    public void checkMissOneRowTest(){
        Frame aFrame = new Frame();
        aFrame.addRoll("-");
        aFrame.addRoll("9");
        assertFalse("It is strike", aFrame.isStrike());
        assertFalse("It is not spare.", aFrame.isSpare());
        assertTrue("Frame is close", aFrame.isClose());
        assertEquals(0, aFrame.getFirstRoll());
        assertEquals(9, aFrame.getSecondRoll());
        assertEquals(9, aFrame.getTotalScore());
    }

    @Test
    public void checkMissTwoRowsTest(){
        Frame aFrame = new Frame();
        aFrame.addRoll("-");
        aFrame.addRoll("-");
        assertFalse("It is strike", aFrame.isStrike());
        assertFalse("It is not spare.", aFrame.isSpare());
        assertTrue("Frame is close", aFrame.isClose());
        assertEquals(0, aFrame.getFirstRoll());
        assertEquals(0, aFrame.getSecondRoll());
        assertEquals(0, aFrame.getTotalScore());
    }

}
