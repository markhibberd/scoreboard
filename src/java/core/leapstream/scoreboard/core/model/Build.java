package leapstream.scoreboard.core.model;

import au.net.netstorm.boost.bullet.incredibles.core.Struct;
import leapstream.scoreboard.edge.java.net.URL;

public interface Build extends Struct {
    URL url();
    Name name();
}
