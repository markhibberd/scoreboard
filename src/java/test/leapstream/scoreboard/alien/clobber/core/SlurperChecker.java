package leapstream.scoreboard.alien.clobber.core;

import leapstream.scoreboard.edge.java.io.InputStream;

public interface SlurperChecker {
    void check(Slurper subject, InputStream stream);
}
