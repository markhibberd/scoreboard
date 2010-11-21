package leapstream.scoreboard.legacy.edge.java.lang;

import au.net.netstorm.boost.bullet.scalpel.core.Edge;

public interface Thread extends Edge {
    void start();

    void interrupt();

    void join();

    void join(long millis);

    void setDaemon(boolean b);
}
