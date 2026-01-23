package tennis;

import tennis.model.Player;

public interface ScoreStrategy {
    String getScoreBasedOnStrategy(Player scoreOne, Player scoreTwo);
}
