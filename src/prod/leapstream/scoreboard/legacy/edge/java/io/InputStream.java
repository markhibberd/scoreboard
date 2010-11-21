package leapstream.scoreboard.legacy.edge.java.io;

import au.net.netstorm.boost.bullet.scalpel.core.Edge;

public interface InputStream extends Edge, Closeable {
    int read(byte[] bytes, int offset, int length);

    void close();
}
