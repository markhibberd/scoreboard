package leapstream.scoreboard.edge.java.text;

import java.util.Date;
import java.util.TimeZone;

import au.net.netstorm.boost.bullet.scalpel.core.Edge;

public interface DateFormat extends Edge {
    Date parse(String value);

    String format(Date date);

    void setTimeZone(TimeZone zone);
}
