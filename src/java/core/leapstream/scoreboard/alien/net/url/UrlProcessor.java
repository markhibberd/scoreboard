package leapstream.scoreboard.alien.net.url;

import leapstream.scoreboard.alien.io.stream.FromInputStream;
import leapstream.scoreboard.edge.java.net.URL;

public interface UrlProcessor {
    <T> T process(URL url, FromInputStream<T> action);
}
