package leapstream.scoreboard.pylons.score.state;

import leapstream.scoreboard.core.model.Score;

// FIX 379 Genrify into a 'PylonState<T>' concept.
public interface ScorePylonState {
    void save(Score score);
    boolean first();
    Score current();
    Score previous();
}
