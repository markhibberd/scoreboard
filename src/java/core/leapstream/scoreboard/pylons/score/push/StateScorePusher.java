package leapstream.scoreboard.pylons.score.push;

import leapstream.scoreboard.core.model.Score;
import leapstream.scoreboard.pylons.score.state.ScorePylonState;

public final class StateScorePusher implements ScorePusher {
    ScorePylonState state;

    public void push(Score score) {
        state.save(score);
    }
}
