package leapstream.scoreboard.pylons.score.job;

import leapstream.scoreboard.alien.resilient.ErrorHandler;
import leapstream.scoreboard.pylons.score.push.ScorePusher;

public class ScoreErrorHandler implements ErrorHandler {
    ScorePusher pusher;

    public void handle(Throwable t) {
        pusher.fail(t);
    }
}
