package leapstream.scoreboard.alien.gunge;

import leapstream.scoreboard.edge.java.io.InputStream;
import leapstream.scoreboard.edge.java.net.URL;

public interface Resources {
    URL url(String name);
    InputStream stream(String name);
}
