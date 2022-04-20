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
        //feed the score into each frame
        for(int i=0; i< frameList.length;i++){
            while (!frameList[i].isClose()){
                frameList[i].addRoll(scores[scoreIndex]);
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

        //calculate total score of each frame
        for(int i=0; i< frameList.length;i++){
            calculateSingleFrameScore(i);
        }
    }

    public String getEachFrameScore(){
        String result = "";
        for (int i=0; i< frameList.length; i++)
            result += frameList[i].getTotalScore() + ",";
        return result;
    }



    private void calculateSingleFrameScore(int frameIndex){
        if(!frameList[frameIndex].isSpare() && !frameList[frameIndex].isStrike())
            frameList[frameIndex].setTotalScore(frameList[frameIndex].getFirstRoll() + frameList[frameIndex].getSecondRoll());
        else if (frameList[frameIndex].isSpare()){
            if (frameIndex + 1 < frameList.length)
                frameList[frameIndex].setTotalScore(10 + frameList[frameIndex + 1].getFirstRoll());
            else
                frameList[frameIndex].setTotalScore(10 + frameList[frameIndex].getFirstBonusRoll());
        }else if (frameList[frameIndex].isStrike()){
            if (frameIndex + 2 < frameList.length) {
                if(!frameList[frameIndex + 1].isStrike())
                    frameList[frameIndex].setTotalScore(10 + frameList[frameIndex + 1].getFirstRoll() + frameList[frameIndex + 1].getSecondRoll());
                else
                    frameList[frameIndex].setTotalScore(20 + frameList[frameIndex + 2].getFirstRoll());
            }else if (frameIndex + 1 < frameList.length) {
                if(!frameList[frameIndex + 1].isStrike())
                    frameList[frameIndex].setTotalScore(10 + frameList[frameIndex + 1].getFirstRoll() + frameList[frameIndex + 1].getSecondRoll());
                else
                    frameList[frameIndex].setTotalScore(20 + frameList[frameIndex + 1].getFirstRoll());
            }else
                frameList[frameIndex].setTotalScore(10 + frameList[frameIndex].getFirstBonusRoll() + frameList[frameIndex].getSecondBonusroll());
        }
    }

    public static void main(String[] args) {
        BowlingGame aGame = new BowlingGame();
//        aGame.playGame(new String[]{"X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X"});
        aGame.playGame(new String[]{"3", "5", "1", "4", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X"});
        System.out.println(aGame.getEachFrameScore());
    }

}






































