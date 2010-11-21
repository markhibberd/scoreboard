package leapstream.scoreboard.legacy.model;

import au.net.netstorm.boost.bullet.incredibles.core.Struct;
import leapstream.scoreboard.legacy.edge.java.net.URL;

public interface Build extends Struct {
    URL url();
    Name name();
}
