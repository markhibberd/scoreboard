package leapstream.scoreboard.core.config.exposed;

import au.net.netstorm.boost.bullet.incredibles.core.Struct;

// FIX CONFIG use or lose, expose configuration as a set of functions.
public interface Seed extends Struct {
    String[] _ = {"key", "doc", "applicator"};
    String key();
    String doc();
    Applicator applicator();
}