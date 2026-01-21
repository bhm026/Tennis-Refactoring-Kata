package tennis;

import tennis.model.Player;

import java.util.Objects;

public class TennisGame1 implements TennisGame {
    
    private int playerOneScore = 0;
    private int playerTwoScore = 0;
    private final Player player1;
    private final Player player2;

    public TennisGame1(String player1Name, String player2Name) {
       this.player1= new Player(player1Name);
       this.player2= new Player(player2Name);
    }

    public void wonPoint(String playerName) {
        if (Objects.equals(playerName, "player1"))
            playerOneScore += 1;
        else
            playerTwoScore += 1;
    }

    public String getScore() {
        int scoreOne = player1.getPoints();
        int scoreTwo = player2.getPoints();
        String score = "";
        int tempScore=0;
        if (scoreOne == scoreTwo)
        {
            score = getScoreWhenEqual(scoreOne);
        }
        else if (scoreOne >=4 || scoreTwo >=4)
        {
            int minusResult = scoreOne - scoreTwo;
            if (minusResult==1) score ="Advantage player1";
            else if (minusResult ==-1) score ="Advantage player2";
            else if (minusResult>=2) score = "Win for player1";
            else score ="Win for player2";
        }
        else
        {
            for (int i=1; i<3; i++)
            {
                if (i==1) {
                    tempScore = scoreOne;
                } else {
                    score+="-";
                    tempScore = scoreTwo;}
                switch(tempScore)
                {
                    case 0:
                        score+="Love";
                        break;
                    case 1:
                        score+="Fifteen";
                        break;
                    case 2:
                        score+="Thirty";
                        break;
                    case 3:
                        score+="Forty";
                        break;
                }
            }
        }
        return score;
    }

    private static String getScoreWhenEqual(int scoreOne) {
        return switch (scoreOne) {
            case 0 -> "Love-All";
            case 1 -> "Fifteen-All";
            case 2 -> "Thirty-All";
            default -> "tennis.Deuce";
        };
    }
}
