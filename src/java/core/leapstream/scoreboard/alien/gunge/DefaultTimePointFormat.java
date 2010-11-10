package leapstream.scoreboard.alien.gunge;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import leapstream.scoreboard.edge.java.text.DateFormat;
import leapstream.scoreboard.edge.java.text.SimpleDateFormat;

import java.util.TimeZone;
// FIX 375 Use or lose. Wire into custom output, to make it more pretty:)

// FIX 375 belongs in boost.
public final class DefaultTimePointFormat implements TimePointFormat {
    Nu nu;

    public DateFormat nu() {
        // FIX 375 this is a pretty dirty hack to come up with an iso8601 timestamp, relies on forcing UTC
        TimeZone utc = TimeZone.getTimeZone("UTC");
        SimpleDateFormat iso8601 = nu.nu(SimpleDateFormat.class, "yyyy-MM-dd'T'HH:mm:ss'Z'");
        iso8601.setTimeZone(utc);
        return iso8601;
    }
}
