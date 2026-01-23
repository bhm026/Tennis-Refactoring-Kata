package tennis;

import tennis.model.Player;

public interface ScoreStrategy {
    String getScoreBasedOnStrategy(Player player1, Player player2);
}
