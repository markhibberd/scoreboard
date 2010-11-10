package leapstream.scoreboard.alien.net.url;

import leapstream.scoreboard.edge.java.io.InputStream;
import leapstream.scoreboard.edge.java.net.URL;

public interface UrlGetter {
    InputStream input(URL url);
}
