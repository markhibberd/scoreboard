package leapstream.scoreboard.core.model;

import au.net.netstorm.boost.bullet.incredibles.core.Struct;
import au.net.netstorm.boost.bullet.time.core.TimePoint;

public interface Score extends Struct {
    Name name();

    Status status();

    TimePoint timestamp();

    History history();
}
