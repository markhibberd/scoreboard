package leapstream.scoreboard.legacy.edge.java.io;

import au.net.netstorm.boost.bullet.scalpel.core.Edge;

public interface OutputStream extends Edge, Closeable {
    void close();
}