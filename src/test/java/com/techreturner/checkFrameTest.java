package com.techreturner;

import org.junit.Test;

import static org.junit.Assert.*;

public class checkFrameTest {



    @Test
    public void checkStrikeTest(){
        Frame aFrame = new Frame();
        aFrame.addRow("X");
        assertTrue("It is strike", aFrame.isStrike());
        assertFalse("It is not spare.", aFrame.isSpare());
        assertTrue("Frame is close", aFrame.isClose());
        assertEquals(10, aFrame.getFirstRow());
        assertEquals(0, aFrame.getSecondRow());
        assertEquals(10, aFrame.getTotalScore());
    }

    @Test
    public void checkSpareTest(){
        Frame aFrame = new Frame();
        aFrame.addRow("5");
        aFrame.addRow("/");
        assertFalse("It is strike", aFrame.isStrike());
        assertTrue("It is not spare.", aFrame.isSpare());
        assertTrue("Frame is close", aFrame.isClose());
        assertEquals(5, aFrame.getFirstRow());
        assertEquals(5, aFrame.getSecondRow());
        assertEquals(10, aFrame.getTotalScore());
    }

    @Test
    public void checkTwoRowsTest(){
        Frame aFrame = new Frame();
        aFrame.addRow("2");
        aFrame.addRow("3");
        assertFalse("It is strike", aFrame.isStrike());
        assertFalse("It is not spare.", aFrame.isSpare());
        assertTrue("Frame is close", aFrame.isClose());
        assertEquals(2, aFrame.getFirstRow());
        assertEquals(3, aFrame.getSecondRow());
        assertEquals(5, aFrame.getTotalScore());
    }

    @Test
    public void checkOneRowsTest(){
        Frame aFrame = new Frame();
        aFrame.addRow("9");
        assertFalse("It is strike", aFrame.isStrike());
        assertFalse("It is not spare.", aFrame.isSpare());
        assertFalse("Frame is close", aFrame.isClose());
        assertEquals(9, aFrame.getFirstRow());
        assertEquals(0, aFrame.getSecondRow());
        assertEquals(9, aFrame.getTotalScore());
    }

    @Test
    public void checkMissOneRowTest(){
        Frame aFrame = new Frame();
        aFrame.addRow("-");
        aFrame.addRow("9");
        assertFalse("It is strike", aFrame.isStrike());
        assertFalse("It is not spare.", aFrame.isSpare());
        assertTrue("Frame is close", aFrame.isClose());
        assertEquals(0, aFrame.getFirstRow());
        assertEquals(9, aFrame.getSecondRow());
        assertEquals(9, aFrame.getTotalScore());
    }

    @Test
    public void checkMissTwoRowsTest(){
        Frame aFrame = new Frame();
        aFrame.addRow("-");
        aFrame.addRow("-");
        assertFalse("It is strike", aFrame.isStrike());
        assertFalse("It is not spare.", aFrame.isSpare());
        assertTrue("Frame is close", aFrame.isClose());
        assertEquals(0, aFrame.getFirstRow());
        assertEquals(0, aFrame.getSecondRow());
        assertEquals(0, aFrame.getTotalScore());
    }

}
