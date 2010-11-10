package leapstream.scoreboard.alien.gunge;

import au.net.netstorm.boost.bullet.time.core.TimeFactory;
import au.net.netstorm.boost.bullet.time.core.TimePoint;
import au.net.netstorm.boost.spider.api.runtime.Impl;
import leapstream.scoreboard.edge.java.text.DateFormat;

import java.util.Date;
// FIX 375 Use or lose. Wire into custom output, to make it more pretty:)

// FIX 375 belongs in boost.
public final class DefaultTimePointFormatter implements TimePointFormatter {
    TimeFactory times;
    TimePointFormat formats;
    Impl impl;

    public TimePoint parse(String value) {
        DateFormat format = formats.nu();
        Date date = format.parse(value);
        return times.time(date);
    }

    // OK GenericIllegalRegexp {
    public String emit(TimePoint time) {
        DateFormat format = formats.nu();
        Long millis = time.getMillis();
        Date date = new Date(millis);
        return format.format(date);
    }
    // } OK GenericIllegalRegexp
}
