package leapstream.scoreboard.pylons.score.job;

import au.net.netstorm.boost.bullet.log.Log;
import leapstream.scoreboard.alien.resilient.ErrorHandler;
import leapstream.scoreboard.alien.ui.swing.containers.Failable;
import leapstream.scoreboard.core.model.Build;

public class ScoreErrorHandler implements ErrorHandler {
    Failable failable;
    Build build;
    Log log;

    public void handle(Throwable t) {
        log.error("Failed... " + build, t);
        failable.fail();
    }
}
