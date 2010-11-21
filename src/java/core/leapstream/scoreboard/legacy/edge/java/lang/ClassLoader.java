package leapstream.scoreboard.legacy.edge.java.lang;

import au.net.netstorm.boost.bullet.scalpel.core.Edge;
import leapstream.scoreboard.legacy.edge.java.io.InputStream;
import leapstream.scoreboard.legacy.edge.java.net.URL;

public interface ClassLoader extends Edge {
    URL getResource(String name);

    InputStream getResourceAsStream(String name);
}
