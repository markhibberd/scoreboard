package leapstream.scoreboard.warts.providers.cruise.transforms;

import org.joda.time.DateTime;
import au.net.netstorm.boost.bullet.time.core.TimePoint;

public interface CruiseTimer {
    TimePoint time(DateTime dodgy);
}
