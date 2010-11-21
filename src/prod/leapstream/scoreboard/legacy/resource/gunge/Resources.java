package leapstream.scoreboard.legacy.resource.gunge;

import leapstream.scoreboard.legacy.edge.java.io.InputStream;
import leapstream.scoreboard.legacy.edge.java.net.URL;

public interface Resources {
    URL url(String name);
    InputStream stream(String name);
}
