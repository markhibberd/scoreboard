package leapstream.scoreboard.pylons.score.push;

import leapstream.scoreboard.core.model.Score;

public interface ScorePusher {
    void push(Score score);

}
