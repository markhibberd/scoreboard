package leapstream.scoreboard.edge.java.net;

import au.net.netstorm.boost.bullet.scalpel.core.Edge;

public interface InetAddress extends Edge {
    boolean isReachable(int timeout);
}
