package leapstream.scoreboard.warts.providers.model;

import au.net.netstorm.boost.bullet.incredibles.core.Struct;
import au.net.netstorm.boost.bullet.time.core.TimePoint;

public interface Status extends Struct {
    Stati is();
    TimePoint since();
}
