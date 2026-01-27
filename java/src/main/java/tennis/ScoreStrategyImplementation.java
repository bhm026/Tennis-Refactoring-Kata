package tennis;

import tennis.model.Player;

import java.util.HashMap;

public class ScoreStrategyImplementation implements ScoreStrategy {
    private String getResultWhenScoreIsLessThanThree(int scoreOne, int scoreTwo) {
        HashMap<Integer, String> scoreMap = getScoreMap();
        return scoreMap.get(scoreOne) + "-" + scoreMap.get(scoreTwo);

    }

    private static HashMap<Integer, String> getScoreMap() {
        HashMap<Integer, String> scoreMap = new HashMap<>();
        scoreMap.put(0, "Love");
        scoreMap.put(1, "Fifteen");
        scoreMap.put(2, "Thirty");
        scoreMap.put(3, "Forty");
        return scoreMap;
    }

    private String getAdvantageOrWin(Player player1, Player player2, int differenceBetweenScore) {
        return switch (differenceBetweenScore) {
            case 1 -> "Advantage " + player1.getName();
            case -1 -> "Advantage " + player2.getName();
            default -> differenceBetweenScore >= 2 ? "Win for " + player1.getName() : "Win for " + player2.getName();
        };
    }

    private String getScoreWhenEqual(int scoreOne) {
        return switch (scoreOne) {
            case 0 -> "Love-All";
            case 1 -> "Fifteen-All";
            case 2 -> "Thirty-All";
            default -> "tennis.Deuce";
        };
    }

    @Override
    public String getScoreBasedOnStrategy(Player player1, Player player2) {
        int scoreOne = player1.getPoints();
        int scoreTwo = player2.getPoints();
        if (scoreOne == scoreTwo) {
            return getScoreWhenEqual(scoreOne);
        } else if (scoreOne >= 4 || scoreTwo >= 4) {
            return getAdvantageOrWin(player1, player2, scoreOne - scoreTwo);
        }
        return getResultWhenScoreIsLessThanThree(scoreOne, scoreTwo);
    }
}
