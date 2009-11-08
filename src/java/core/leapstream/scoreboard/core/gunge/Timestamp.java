package leapstream.scoreboard.core.gunge;

// OK GenericIllegalRegexp {

import au.net.netstorm.boost.bullet.time.core.TimePoint;

import java.util.Calendar;

public interface Timestamp {
    TimePoint now();

    TimePoint then(Calendar calendar);
}
// } OK GenericIllegalRegexp