package leapstream.scoreboard.pylons.score.push;

import au.net.netstorm.boost.bullet.log.Log;
import leapstream.scoreboard.core.model.Build;
import leapstream.scoreboard.core.model.Score;

public final class LogScorePusher implements ScorePusher {
    Build build;
    Log log;

    public void push(Score score) {
        log.info("Grabbed: " + score);
    }

    public void fail(Throwable t) {
        log.error("Failed... " + build, t);
    }
}
