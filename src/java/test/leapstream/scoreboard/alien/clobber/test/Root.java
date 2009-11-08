package leapstream.scoreboard.alien.clobber.test;

import au.net.netstorm.boost.bullet.incredibles.core.Struct;
import au.net.netstorm.boost.bullet.time.core.TimePoint;

import java.util.List;

public interface Root extends Struct {
    TimePoint time();
    Enumeriffic enumer();
    SingleVal single();
    MultiVal multi();
    List list();
    SingleValList singleList();
}
