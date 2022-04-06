package com.techreturner;

import java.util.Arrays;

import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class checkBowlingGameTest {

    BowlingGame aGame = new BowlingGame();


    //First start with testing no strike and no spare
    @Test
    public void checkAllStrikeTest(){
        BowlingGame gameA = new BowlingGame();
        gameA.playGame(new String[]{"2", "3","2", "3","2", "3","2", "3","2", "3","2", "3","2", "3","2", "3","2", "3","2", "3","2", "3","2", "3","2", "3","2", "3",});
        assertEquals("5,5,5,5,5,5,5,5,5,5,", gameA.getEachFrameScore());
        BowlingGame gameB = new BowlingGame();
        gameB.playGame(new String[]{"5","3","4","4","1","5","2", "2","2", "3","2", "3","2", "3","2", "3","2", "3","2", "3","2", "3","2", "3","2", "3","2", "3",});
        assertEquals("8,8,6,4,5,5,5,5,5,5,", gameB.getEachFrameScore());
        BowlingGame gameC = new BowlingGame();
        gameC.playGame(new String[]{"X","X","X","X","X","X","X","X","X","X","X","X",});
        assertEquals("10,10,10,10,10,10,10,10,10,10,", gameC.getEachFrameScore());
        BowlingGame gameD = new BowlingGame();
        gameD.playGame(new String[]{"5","/","4","4","1","/","2", "2","2", "3","2", "3","2", "3","2", "3","2", "3","2", "3","2", "3","2", "3","2", "3","2", "3",});
        assertEquals("10,8,10,4,5,5,5,5,5,5,", gameD.getEachFrameScore());
    }
}
