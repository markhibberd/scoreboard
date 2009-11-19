package leapstream.scoreboard.pylons.score.push;

import leapstream.scoreboard.core.model.Score;

// FIX AQUEDUCT Rip out farmer gumf.
public interface ScorePusher {
    void push(Score score);

    void fail(Throwable throwable);
}
