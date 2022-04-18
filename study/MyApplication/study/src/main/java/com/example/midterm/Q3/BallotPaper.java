package com.example.midterm.Q3;

public class BallotPaper implements Comparable<BallotPaper>
{

    private String firstChoice;
    private String secondChoice;

    BallotPaper(String firstChoice, String secondChoice){
        this.firstChoice = firstChoice;
        this.secondChoice = secondChoice;
    }
    public String getFirstChoice() {
        return firstChoice;
    }

    public String getSecondChoice() {
        return secondChoice;
    }

    public void transferVotes(){
        this.firstChoice = this.getSecondChoice();
        this.secondChoice = null;
    }

    public String toString(){
        return "1:"+getFirstChoice()+" "+"2:"+secondChoice;
    }

    public boolean equals(Object o){
        if (o instanceof BallotPaper){
            BallotPaper o_new = (BallotPaper) o;
            if (o_new.getFirstChoice()==this.firstChoice && o_new.getSecondChoice()==this.secondChoice){
                return true;
            }
        }
        else if (o==this){
            return true;
        }
        return false;
    }

    public int compareTo(BallotPaper b){
        if (this.getFirstChoice().compareTo(b.getFirstChoice())>0){
            return 1;
        }
        else if(this.getFirstChoice()==b.getFirstChoice()){
            return 0;
        }
        else {
            return -1;
        }
    }

}

