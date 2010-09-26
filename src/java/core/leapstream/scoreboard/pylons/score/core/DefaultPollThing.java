package leapstream.scoreboard.pylons.score.core;

import au.net.netstorm.boost.spider.api.runtime.Spider;
import leapstream.scoreboard.alien.resilient.ErrorHandler;
import leapstream.scoreboard.alien.resilient.ResilientRunnables;
import leapstream.scoreboard.alien.resilient.TimeoutHandler;
import leapstream.scoreboard.core.poll.Poller;
import leapstream.scoreboard.pylons.score.job.ScoreErrorHandler;
import leapstream.scoreboard.pylons.score.job.ScoreRunnable;
import leapstream.scoreboard.pylons.score.job.ScoreTimeoutHandler;

public class DefaultPollThing implements PollThing {
    ResilientRunnables resilient;

    public void poll(Spider spider, Poller poller, int period) {
        Runnable runnable = spider.impl(ScoreRunnable.class);
        TimeoutHandler times = spider.impl(ScoreTimeoutHandler.class);
        ErrorHandler errors = spider.impl(ScoreErrorHandler.class);
        Runnable imbued = resilient.imbune(runnable, errors, times, period);
        poller.poll(imbued, period);
    }
}
