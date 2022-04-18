package com.example.midterm.Q3;



import java.util.ArrayList;
import java.util.Collections;

public class CountBallotBox {

    private ArrayList<BallotPaper> ballots;

    CountBallotBox(){
        ballots = new ArrayList<BallotPaper>();
    }

    public void addBallot(BallotPaper b){
        ballots.add(b);
    }

    public int getVotesFor(String Candidate){
        int result = 0;
        for (BallotPaper b:ballots){
            if (b.getFirstChoice()==Candidate){
                result = result+1;
            }
        }
        return result;
    }


    public void sortBallots(){
        Collections.sort(ballots);
    }

    public void eliminateCandidate(String candidate){
        for (BallotPaper b:ballots){
            if (b.getFirstChoice()==candidate){
                b.transferVotes();
            }
        }
    }

    public void transferCandidate(BallotPaper sampleBallotPaper, int numberOfVotes){
        int count=0;
        for (BallotPaper b:ballots){
            if (b.equals(sampleBallotPaper)){
                if (count<numberOfVotes){
                    b.transferVotes();
                    count=count+1;
                }
            }
        }
    }

    @Override
    public String toString(){
        this.sortBallots();
        String result = "";
        for (BallotPaper b:ballots){
            result = result + b.toString() + "\n";
        }
        return result;
    }

}
