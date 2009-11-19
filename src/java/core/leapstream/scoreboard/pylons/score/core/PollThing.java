package leapstream.scoreboard.pylons.score.core;

import au.net.netstorm.boost.spider.api.runtime.Spider;
import leapstream.scoreboard.core.poll.Poller;

// FIX LIFECYCLE Temporary shim to kill some dupe, before the pylon wiring is pulled apart.
public interface PollThing {
    void poll(Spider spider, Poller poller);
}