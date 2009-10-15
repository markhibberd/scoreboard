package leapstream.scoreboard.core.model;

import au.net.netstorm.boost.bullet.time.core.TimePoint;
import au.net.netstorm.boost.bullet.incredibles.core.Struct;

public interface Status extends Struct {
    Stati is();
    TimePoint since();
}
