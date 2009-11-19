package leapstream.scoreboard.pylons.score.job;

import leapstream.scoreboard.alien.net.url.UrlProcessor;
import leapstream.scoreboard.core.model.Build;
import leapstream.scoreboard.core.model.Score;
import leapstream.scoreboard.edge.java.net.URL;
import leapstream.scoreboard.pylons.score.push.ScorePusher;
import leapstream.scoreboard.alien.ui.swing.containers.Failable;

public class ScoreRunnable implements Runnable {
    ScoreFromInputStream scorer;
    ScorePusher pusher;
    Failable failable;
    UrlProcessor net;
    Build build;

    public void run() {
        URL url = build.url();
        Score score = net.process(url, scorer);
        // FIX LIFECYCLE Should be able to put these somewhere safer. 
        pusher.push(score);
        failable.ok();
    }
}
