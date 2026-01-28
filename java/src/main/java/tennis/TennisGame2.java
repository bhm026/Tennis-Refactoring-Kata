package tennis;

import tennis.model.Player;

import java.util.HashMap;

public class TennisGame2 implements TennisGame
{

    public String P1res = "";
    public String P2res = "";
    private final Player player1;
    private final Player player2;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);
    }

    public String getScore(){
        int P1point = player1.getPoints();
        int P2point = player2.getPoints();
        String score = "";
        if (P1point == P2point && P1point < 4)
        {
            score = getScoreWhenBothHaveSamePointsAndLessThanMax(P1point);
        }
        if (P1point==P2point && P1point>=3) {
            return "tennis.Deuce";
        }
        if (P1point!=P2point && P1point < 4 && P2point < 4)
        {
            score = getScoreWhenPointsAreNotEqualAndLessThanFour(P1point, P2point);
        }

        if (P1point > P2point && P2point >= 3)
        {
            score = "Advantage player1";
        }

        if (P2point > P1point && P1point >= 3)
        {
            score = "Advantage player2";
        }

        if (P1point>=4 && P2point>=0 && (P1point-P2point)>=2)
        {
            score = "Win for player1";
        }
        if (P2point>=4 && P1point>=0 && (P2point-P1point)>=2)
        {
            score = "Win for player2";
        }
        return score;
    }

    private String getScoreWhenPointsAreNotEqualAndLessThanFour(int P1point, int P2point) {
        return getScoresForPlayers(P1point) + "-" + getScoresForPlayers(P2point);
    }

    private static String getScoresForPlayers(int points) {
        HashMap<Integer, String> scoreMap = new HashMap<>();
        scoreMap.put(0, "Love");
        scoreMap.put(1, "Fifteen");
        scoreMap.put(2, "Thirty");
        scoreMap.put(3, "Forty");
        return scoreMap.get(points);
    }

    private static String getScoreWhenBothHaveSamePointsAndLessThanMax(int P1point) {
        return switch (P1point) {
            case 0 -> "Love";
            case 1 -> "Fifteen";
            case 2 -> "Thirty";
            default -> "";
        } + "-All";
    }

    public void wonPoint(String player) {
        if (player1.getName().equals(player))
            player1.setPoints(player1.getPoints() + 1);
        else
            player2.setPoints(player2.getPoints() + 1);
    }
}