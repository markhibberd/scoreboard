package leapstream.scoreboard.legacy.edge.javax.net.ssl;

import au.net.netstorm.boost.bullet.scalpel.core.Edge;

public interface SSLContextStatic extends Edge{
    SSLContext getInstance(String type);
}
