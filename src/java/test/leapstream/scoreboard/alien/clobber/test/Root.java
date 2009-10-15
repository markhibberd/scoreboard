package leapstream.scoreboard.alien.clobber.test;

import java.util.List;

import au.net.netstorm.boost.bullet.time.core.TimePoint;
import au.net.netstorm.boost.bullet.incredibles.core.Struct;

public interface Root extends Struct {
    TimePoint time();
    Enumeriffic enumer();
    SingleVal single();
    MultiVal multi();
    List list();
    SingleValList singleList();
}
