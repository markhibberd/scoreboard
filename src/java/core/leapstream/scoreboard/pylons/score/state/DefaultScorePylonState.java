package leapstream.scoreboard.pylons.score.state;

import leapstream.scoreboard.core.model.Score;

// FIX 379 Think about making this generic. So we have PylonState for all pylons.
public final class DefaultScorePylonState implements ScorePylonState {
    private Score current;
    private Score previous;

    public void save(Score score) {
        previous = current;
        current = score;
    }

    public boolean first() {
        return previous == null;
    }

    public Score current() {
        if (current == null) throw new IllegalStateException();
        return current;
    }

    public Score previous() {
        if (previous == null) throw new IllegalStateException();
        return previous;
    }
}
