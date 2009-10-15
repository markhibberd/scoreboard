package leapstream.scoreboard.alien.clobber.test;

import au.net.netstorm.boost.bullet.incredibles.core.Struct;

public interface MultiVal extends Struct {
    String[] _ = {"x", "y"};
    String x();
    String y();
}
