package tennis;

import tennis.model.Player;

import java.util.Objects;

public class TennisGame1 implements TennisGame {

    private int playerOneScore = 0;
    private int playerTwoScore = 0;
    private final Player player1;
    private final Player player2;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);
    }

    public void wonPoint(String playerName) {
        if (player1.getName().equals(playerName)) {
            player1.setPoints(++playerOneScore);
        } else {
            player2.setPoints(++playerTwoScore);
        }
    }

    public String getScore() {
        int scoreOne = player1.getPoints();
        int scoreTwo = player2.getPoints();
        if (scoreOne == scoreTwo) {
            return getScoreWhenEqual(scoreOne);
        } else if (scoreOne >= 4 || scoreTwo >= 4) {
            return getAdvantageOrWin(player1, player2, scoreOne - scoreTwo);
        }
        return getResultWhenScoreIsLessThanThree(scoreOne, scoreTwo);
    }

    private static String getResultWhenScoreIsLessThanThree(int scoreOne, int scoreTwo) {
        String score = "";
        int tempScore;
        for (int i = 1; i < 3; i++) {
            if (i == 1) {
                tempScore = scoreOne;
            } else {
                score += "-";
                tempScore = scoreTwo;
            }
            switch (tempScore) {
                case 0:
                    score += "Love";
                    break;
                case 1:
                    score += "Fifteen";
                    break;
                case 2:
                    score += "Thirty";
                    break;
                case 3:
                    score += "Forty";
                    break;
            }
        }
        return score;
    }

    private static String getAdvantageOrWin(Player player1, Player player2, int differenceBetweenScore) {
        return switch (differenceBetweenScore) {
            case 1 -> "Advantage " + player1.getName();
            case -1 -> "Advantage " + player2.getName();
            default -> differenceBetweenScore >= 2 ? "Win for " + player1.getName() : "Win for " + player2.getName();
        };
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
