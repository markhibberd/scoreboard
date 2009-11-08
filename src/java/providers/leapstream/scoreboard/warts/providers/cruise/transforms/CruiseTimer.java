package leapstream.scoreboard.warts.providers.cruise.transforms;

import au.net.netstorm.boost.bullet.time.core.TimePoint;
import org.joda.time.DateTime;

public interface CruiseTimer {
    TimePoint time(DateTime dodgy);
}
