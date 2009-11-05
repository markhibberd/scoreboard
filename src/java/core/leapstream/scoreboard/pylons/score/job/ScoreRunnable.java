package leapstream.scoreboard.pylons.score.job;

import leapstream.scoreboard.pylons.score.job.ScoreFromInputStream;
import leapstream.scoreboard.pylons.score.push.ScorePusher;
import leapstream.scoreboard.alien.net.url.UrlProcessor;
import leapstream.scoreboard.core.model.Build;
import leapstream.scoreboard.core.model.Score;
import leapstream.scoreboard.edge.java.net.URL;

public class ScoreRunnable implements Runnable {
    ScoreFromInputStream scorer;
    ScorePusher pusher;
    UrlProcessor net;
    Build build;

    public void run() {
        pusher.starting();
        URL url = build.url();
        Score score = net.process(url, scorer);
        pusher.push(score);
    }
}