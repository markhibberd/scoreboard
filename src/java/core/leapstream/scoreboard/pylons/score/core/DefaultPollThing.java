package leapstream.scoreboard.pylons.score.core;

import au.net.netstorm.boost.spider.api.runtime.Spider;
import leapstream.scoreboard.pylons.score.job.ScoreRunnable;
import leapstream.scoreboard.pylons.score.job.ScoreTimeoutHandler;
import leapstream.scoreboard.pylons.score.job.ScoreErrorHandler;
import leapstream.scoreboard.alien.resilient.TimeoutHandler;
import leapstream.scoreboard.alien.resilient.ErrorHandler;
import leapstream.scoreboard.alien.resilient.ResilientRunnables;
import leapstream.scoreboard.core.poll.Times;
import leapstream.scoreboard.core.poll.Poller;

public class DefaultPollThing implements PollThing {
    ResilientRunnables resilient;

    public void poll(Spider spider, Poller poller) {
        Runnable runnable = spider.impl(ScoreRunnable.class);
        TimeoutHandler times = spider.impl(ScoreTimeoutHandler.class);
        ErrorHandler errors = spider.impl(ScoreErrorHandler.class);
        Runnable imbued = resilient.imbune(runnable, errors, times, Times.STATUS_POLL);
        poller.poll(imbued, Times.STATUS_POLL);
    }
}
