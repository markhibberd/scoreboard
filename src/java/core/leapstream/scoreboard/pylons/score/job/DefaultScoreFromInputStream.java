package leapstream.scoreboard.pylons.score.job;

import leapstream.scoreboard.alien.clobber.core.Slurper;
import leapstream.scoreboard.core.model.Score;
import leapstream.scoreboard.edge.java.io.InputStream;

public class DefaultScoreFromInputStream implements ScoreFromInputStream {
    Slurper slurper;

    public Score run(InputStream in) {
        return slurper.slurp(Score.class, in);
    }
}
