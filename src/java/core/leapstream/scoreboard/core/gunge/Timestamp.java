package leapstream.scoreboard.core.gunge;

// OK GenericIllegalRegexp {

import java.util.Calendar;

import au.net.netstorm.boost.bullet.time.core.TimePoint;

public interface Timestamp {
    TimePoint now();

    TimePoint then(Calendar calendar);
}
// } OK GenericIllegalRegexp