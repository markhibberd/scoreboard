package leapstream.scoreboard.pylons.score.job;

import au.net.netstorm.boost.bullet.log.Log;
import leapstream.scoreboard.alien.resilient.TimeoutHandler;
import leapstream.scoreboard.alien.ui.swing.containers.Failable;
import leapstream.scoreboard.core.model.Build;

public class ScoreTimeoutHandler implements TimeoutHandler {
    Failable failable;
    Build build;
    Log log;

    public void timeout() {
        log.error("Timed out... " + build);
        failable.fail();
    }
}
