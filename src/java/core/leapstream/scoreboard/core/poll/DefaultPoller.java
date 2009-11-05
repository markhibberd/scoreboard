package leapstream.scoreboard.core.poll;

import au.net.netstorm.boost.spider.api.runtime.Impl;
import au.net.netstorm.boost.bullet.repeater.Repeater;

public class DefaultPoller implements Poller {
    Repeater repeater;
    Impl impl;

    public void poll(Runnable r, int period) {
        Poll poll = impl.impl(Poll.class, r);
        repeater.repeat(poll, (long) period);
    }
}
