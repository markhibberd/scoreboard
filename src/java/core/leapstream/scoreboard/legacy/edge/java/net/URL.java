package leapstream.scoreboard.legacy.edge.java.net;

import au.net.netstorm.boost.bullet.scalpel.core.Edge;

public interface URL extends Edge {
    URLConnection openConnection();

    String getAuthority();

    String getUserInfo();

    String getPath();
}
