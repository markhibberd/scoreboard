package leapstream.scoreboard.edge.java.text;

import au.net.netstorm.boost.bullet.scalpel.core.Edge;

import java.util.Date;
import java.util.TimeZone;

public interface DateFormat extends Edge {
    Date parse(String value);

    String format(Date date);

    void setTimeZone(TimeZone zone);
}
