package leapstream.scoreboard.legacy.edge.java.net;

import au.net.netstorm.boost.bullet.scalpel.core.Edge;

public interface InetAddressStatic extends Edge {
    InetAddress getByName(String name);

}