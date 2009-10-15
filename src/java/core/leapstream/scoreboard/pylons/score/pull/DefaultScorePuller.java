package leapstream.scoreboard.pylons.score.pull;

import leapstream.scoreboard.alien.net.url.UrlProcessor;
import leapstream.scoreboard.core.model.Build;
import leapstream.scoreboard.core.model.Score;
import leapstream.scoreboard.edge.java.net.URL;

public final class DefaultScorePuller implements ScorePuller {
    ScoreFromInputStream scorer;
    UrlProcessor net;
    Build build;

    public Score pull() {
        URL url = build.url();
        return net.process(url, scorer);
    }
}
