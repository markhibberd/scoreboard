package leapstream.scoreboard.core.gunge;

// OK GenericIllegalRegexp {

import java.util.Calendar;
import java.util.Date;

import au.net.netstorm.boost.bullet.time.core.Clock;
import au.net.netstorm.boost.bullet.time.core.TimeFactory;
import au.net.netstorm.boost.bullet.time.core.TimePoint;

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

// } OK GenericIllegalRegexp
