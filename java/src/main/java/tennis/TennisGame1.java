package tennis;

import tennis.model.Player;

public class TennisGame1 implements TennisGame {

    private int playerOneScore = 0;
    private int playerTwoScore = 0;
    private final Player player1;
    private final Player player2;
    private final ScoreStrategy scoreStrategy;

    public TennisGame1(String player1Name, String player2Name) {
        this(player1Name,player2Name, new ScoreStrategyImplementation());
    }

    public TennisGame1(String player1Name, String player2Name, ScoreStrategy scoreStrategy) {
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);
        this.scoreStrategy = scoreStrategy;
    }

    public void wonPoint(String playerName) {
        if (player1.getName().equals(playerName)) {
            player1.setPoints(++playerOneScore);
        } else {
            player2.setPoints(++playerTwoScore);
        }
    }

    public String getScore() {
        return scoreStrategy.getScoreBasedOnStrategy(player1, player2);
    }



}
