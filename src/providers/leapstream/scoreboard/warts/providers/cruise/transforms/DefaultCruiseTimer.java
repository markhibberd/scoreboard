package leapstream.scoreboard.warts.providers.cruise.transforms;

import au.net.netstorm.boost.bullet.time.core.TimePoint;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.joda.time.DateTime;

public final class DefaultCruiseTimer implements CruiseTimer {
    Nu nu;

    public TimePoint time(DateTime dodgy) {
        long millis = dodgy.getMillis();
        return nu.nu(TimePoint.class, millis);
    }
}
