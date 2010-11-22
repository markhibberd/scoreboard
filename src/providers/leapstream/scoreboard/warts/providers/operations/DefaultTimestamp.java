package leapstream.scoreboard.warts.providers.operations;


import au.net.netstorm.boost.bullet.time.core.Clock;
import au.net.netstorm.boost.bullet.time.core.TimeFactory;
import au.net.netstorm.boost.bullet.time.core.TimePoint;

import java.util.Calendar;
import java.util.Date;

public final class DefaultTimestamp implements Timestamp {
    TimeFactory times;
    Clock clock;

    public TimePoint now() {
        return clock.now();
    }

    public TimePoint then(Calendar calendar) {
        Date date = calendar.getTime();
        return times.time(date);
    }
}
