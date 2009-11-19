package leapstream.scoreboard.pylons.score.push;

import au.net.netstorm.boost.bullet.log.Log;
import leapstream.scoreboard.core.model.Score;

public final class LogScorePusher implements ScorePusher {
    Log log;

    public void push(Score score) {
        log.info("Grabbed: " + score);
    }
}
