package com.techreturner;

public class BowlingGame {
    private final int maximumFrame = 10;
    private int currentFrame = 1;
    private Frame [] frameList = new Frame[maximumFrame];

    public BowlingGame(){
        for (int i=0; i< maximumFrame; i++)
            frameList[i] = new Frame();
    }

    public void playGame(String [] scores){
        int scoreIndex =0;
        for(int i=0; i< frameList.length;i++){
            while (!frameList[i].isClose()){
                frameList[i].addRow(scores[scoreIndex]);
                scoreIndex += 1;
            }
//            System.out.println("Frame number is " + scoreIndex);
//            System.out.println(frameList[i].getTotalScore());
            if (i == maximumFrame-1 && frameList[i].isStrike()){
                frameList[i].addBonus(scores[scoreIndex]);
                frameList[i].addBonus(scores[scoreIndex+1]);
            }else if (i == maximumFrame-1 && frameList[i].isSpare())
                frameList[i].addBonus(scores[scoreIndex]);
        }
    }

    public String getEachFrameScore(){
        String result = "";
        for (int i=0; i< frameList.length; i++)
            result += frameList[i].getTotalScore() + ",";
        return result;
    }

    public void calculateFinalScore(){

    }

    public static void main(String[] args) {
        BowlingGame aGame = new BowlingGame();
        aGame.playGame(new String[]{"X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X"});
    }

}
