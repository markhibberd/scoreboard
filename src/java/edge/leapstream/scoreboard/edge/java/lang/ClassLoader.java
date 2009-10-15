package leapstream.scoreboard.edge.java.lang;

import au.net.netstorm.boost.bullet.scalpel.core.Edge;
import leapstream.scoreboard.edge.java.net.URL;
import leapstream.scoreboard.edge.java.io.InputStream;

public interface ClassLoader extends Edge {
    URL getResource(String name);

    InputStream getResourceAsStream(String name);
}
