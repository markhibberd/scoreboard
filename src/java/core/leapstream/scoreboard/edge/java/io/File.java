package leapstream.scoreboard.edge.java.io;

import au.net.netstorm.boost.bullet.scalpel.core.Edge;

public interface File extends Edge {
    boolean isDirectory();

    File[] listFiles();

    void delete();
}
