package com.techreturner;

public class Frame {
    private boolean isStrike = false;
    private boolean isSpare = false;
    private final int totalPin = 10;
    private boolean isFirstRoll = true;
    private int firstRoll = 0;
    private int secondRoll = 0;
    private int firstBonusRoll = 0;
    private int secondBonusroll =0;
    private boolean isFirstBonusRoll = true;
    private int totalScore = 0;
    private int bonusAdded = 0;
    private boolean isClose = false;

    public boolean addRoll(String score){
        switch (score){
            case "X" -> {
                isStrike = true;
                firstRoll = totalPin;
                totalScore = totalPin;
                isClose = true;
            }
            case "-" -> {
                if (isFirstRoll) {
                    firstRoll = 0;
                    totalScore = 0;
                    isFirstRoll = false;
                }else{
                    secondRoll = 0;
                    isClose = true;
                }
            }
            case "/" ->{
                isSpare = true;
                secondRoll = totalPin - firstRoll;
                totalScore = totalPin;
                isClose = true;
            }
            default -> {
                if (isFirstRoll) {
                    firstRoll = Integer.valueOf(score);
                    totalScore = Integer.valueOf(score);
                    isFirstRoll = false;
                }else{
                    secondRoll = Integer.valueOf(score);
                    totalScore += Integer.valueOf(score);
                    isClose = true;
                }
            }
        }
        return isClose;
    }

    public boolean isStrike(){ return isStrike;};
    public boolean isSpare(){ return isSpare;};
    public boolean isClose(){return isClose;};
    public int getFirstRoll(){return firstRoll;};
    public int getSecondRoll(){return secondRoll;};
    public int getTotalScore(){return totalScore;};
    public int getFirstBonusRoll(){return firstBonusRoll;};
    public int getSecondBonusroll(){return secondBonusroll;};
    public void setTotalScore(int totalScore){this.totalScore = totalScore;};

    public void addBonus(String bonus){
        int score = convertToInt(bonus);
        if (isFirstBonusRoll){
            firstBonusRoll = score;
            isFirstBonusRoll = false;
        }else
            secondBonusroll = score;
        bonusAdded += score;
    }

    public int convertToInt(String bonus){
        int result =0;
        switch (bonus){
            case "X" -> result=10;
            case "-" -> result=0;
            default -> result=Integer.valueOf(bonus);
        }
        return result;
    }

}
