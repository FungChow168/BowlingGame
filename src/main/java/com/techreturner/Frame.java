package com.techreturner;

public class Frame {
    private boolean isStrike = false;
    private boolean isSpare = false;
    private final int totalPin = 10;
    private boolean isFirstRow = true;
    private int firstRow = 0;
    private int secondRow = 0;
    private int firstBonusRow = 0;
    private int secondBonusrow =0;
    private boolean isFirstBonusRow = true;
    private int totalScore = 0;
    private int bonusAdded = 0;
    private boolean isClose = false;

    public boolean addRow(String score){
        switch (score){
            case "X" -> {
                isStrike = true;
                firstRow = totalPin;
                totalScore = totalPin;
                isClose = true;
            }
            case "-" -> {
                if (isFirstRow) {
                    firstRow = 0;
                    totalScore = 0;
                    isFirstRow = false;
                }else{
                    secondRow = 0;
                    isClose = true;
                }
            }
            case "/" ->{
                isSpare = true;
                secondRow = totalPin - firstRow;
                totalScore = totalPin;
                isClose = true;
            }
            default -> {
                if (isFirstRow) {
                    firstRow = Integer.valueOf(score);
                    totalScore = Integer.valueOf(score);
                    isFirstRow = false;
                }else{
                    secondRow = Integer.valueOf(score);
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
    public int getFirstRow(){return firstRow;};
    public int getSecondRow(){return secondRow;};
    public int getTotalScore(){return totalScore;};
    public int getFirstBonusRow(){return firstBonusRow;};
    public int getSecondBonusrow(){return secondBonusrow;};

    public void addBonus(String bonus){
        int score = convertToInt(bonus);
        if (isFirstBonusRow){
            firstBonusRow = score;
            isFirstBonusRow = false;
        }else
            secondBonusrow = score;
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
