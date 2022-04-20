package com.techreturner;

import java.util.Arrays;

import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class checkBowlingGameTest {

    BowlingGame aGame = new BowlingGame();


    //First start with testing no strike and no spare
    @Test
    public void checkNoStrikeOrSpareTest() {
        BowlingGame gameA = new BowlingGame();
        gameA.playGame(new String[]{"2", "3", "2", "3", "2", "3", "2", "3", "2", "3", "2", "3", "2", "3", "2", "3", "2", "3", "2", "3"});
        assertEquals("5,5,5,5,5,5,5,5,5,5,", gameA.getEachFrameScore());
        BowlingGame gameB = new BowlingGame();
        gameB.playGame(new String[]{"5", "3", "4", "-", "1", "5", "2", "2", "2", "1", "4", "3", "2", "3", "2", "3", "2", "3", "6", "-"});
        assertEquals("8,4,6,4,3,7,5,5,5,6,", gameB.getEachFrameScore());
    }

    @Test
    public void checkSomeFramesAreStrikeTest() {
        BowlingGame gameC = new BowlingGame();
        gameC.playGame(new String[]{"5", "3", "X", "1", "5", "2", "2", "X", "4", "3", "2", "3", "2", "3", "2", "3", "6", "3"});
        assertEquals("8,16,6,4,17,7,5,5,5,9,", gameC.getEachFrameScore());
    }

    @Test
    public void checkSomeFramesAreSpareTest() {
        BowlingGame gameB = new BowlingGame();
        gameB.playGame(new String[]{"5", "3", "4", "/", "1", "5", "2", "/", "2", "1", "4", "3", "2", "3", "2", "3", "2", "3", "6", "3"});
        assertEquals("8,11,6,12,3,7,5,5,5,9,", gameB.getEachFrameScore());
    }

    @Test
    public void checkStrikeAndSpareMixTest() {
        BowlingGame gameB = new BowlingGame();
        gameB.playGame(new String[]{"5", "3", "4", "/", "X", "2", "/", "2", "1", "4", "3", "2", "3", "2", "3", "2", "3", "6", "3"});
        assertEquals("8,20,20,12,3,7,5,5,5,9,", gameB.getEachFrameScore());
    }

    @Test
    public void checkAllStrikeTest() {
        BowlingGame gameC = new BowlingGame();
        gameC.playGame(new String[]{"X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X"});
        assertEquals("30,30,30,30,30,30,30,30,30,30,", gameC.getEachFrameScore());
    }

    @Test
    public void checkTheLastFrameIsSpareTest(){
        BowlingGame gameD = new BowlingGame();
        gameD.playGame(new String[]{"5", "/", "4", "4", "1", "/", "2", "2", "2", "3", "2", "3", "2", "3", "2", "3", "2", "3", "2", "/", "5"});
        assertEquals("14,8,12,4,5,5,5,5,5,15,", gameD.getEachFrameScore());
    }

    @Test
    public void checkTheLastFrameIsSpareAndBonusRollIsStrikeTest(){
        BowlingGame gameE = new BowlingGame();
        gameE.playGame(new String[]{"5","/","4","4","1","/","2", "2","2", "3","2", "3","2", "3","2", "3","2", "3","2", "/", "X"});
        assertEquals("14,8,12,4,5,5,5,5,5,20,", gameE.getEachFrameScore());

    }
}
