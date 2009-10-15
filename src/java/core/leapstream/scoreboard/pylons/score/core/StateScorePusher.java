package leapstream.scoreboard.pylons.score.core;

import leapstream.scoreboard.core.model.Score;
import leapstream.scoreboard.pylons.score.push.ScorePusher;
import leapstream.scoreboard.pylons.score.state.ScorePylonState;

public final class StateScorePusher implements ScorePusher {
    ScorePylonState state;

    public void starting() {}

    public void push(Score score) {
        state.save(score);
    }

    public void fail(Throwable t) {}
}
