package leapstream.scoreboard.pylons.score.state;

import leapstream.scoreboard.core.gunge.Historian;
import leapstream.scoreboard.core.model.History;
import leapstream.scoreboard.core.model.Id;
import leapstream.scoreboard.core.model.Score;

public final class DefaultScoreDelta implements ScoreDelta {
    ScorePylonState state;
    Historian historian;

    public boolean hasChanged() {
        if (state.first()) return true;
        Id current = current();
        Id previous = previous();
        return !current.equals(previous);
    }

    public boolean fixed() {
        return justChanged() && switchedTo(true);
    }

    public boolean broke() {
        return switchedTo(false);
    }

    private boolean switchedTo(boolean expected) {
        History history = history();
        if (!hasChanged()) return false;
        return historian.good(history) == expected;
    }

    private Id previous() {
        Score score = state.previous();
        return id(score);
    }

    private Id current() {
        Score score = state.current();
        return id(score);
    }

    private Id id(Score score) {
        History history = score.history();
        return historian.last(history);
    }

    private History history() {
        Score score = state.current();
        return score.history();
    }

    private boolean justChanged() {
        History history = history();
        return historian.count(history) == 1;
    }
}
