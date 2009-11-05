package leapstream.scoreboard.core.poll;

import leapstream.scoreboard.alien.aqueduct.Job;
import au.net.netstorm.boost.spider.api.runtime.Impl;
import au.net.netstorm.boost.bullet.repeater.Repeater;

public class DefaultPoller implements Poller {
    Repeater repeater;
    Impl impl;

    public void poll(Job job, Long period) {
        Poll poll = impl.impl(Poll.class, job);
        repeater.repeat(poll, period);
    }
}
