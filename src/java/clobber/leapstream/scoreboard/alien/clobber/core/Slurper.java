package leapstream.scoreboard.alien.clobber.core;

import leapstream.scoreboard.edge.java.io.InputStream;

// FIX 1202 Jan 14, 2009 Delete once boost clobber is complete.
public interface Slurper {
    <T> T slurp(Class<T> type, InputStream input);
}
