package leapstream.scoreboard.legacy.script;

import au.net.netstorm.boost.bullet.incredibles.core.Struct;

public interface Arg extends Struct {
    String[] _ = {"name", "value"};
    String name();
    Object value();
}
