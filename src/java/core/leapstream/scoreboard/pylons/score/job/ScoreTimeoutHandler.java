package leapstream.scoreboard.pylons.score.job;

import leapstream.scoreboard.alien.resilient.TimeoutHandler;
import leapstream.scoreboard.pylons.score.push.ScorePusher;

public class ScoreTimeoutHandler implements TimeoutHandler {
    ScorePusher pusher;

    public void timeout() {
        pusher.fail(new RuntimeException());
    }
}
