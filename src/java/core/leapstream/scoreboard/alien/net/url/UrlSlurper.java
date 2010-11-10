package leapstream.scoreboard.alien.net.url;

import leapstream.scoreboard.edge.java.net.URL;

public interface UrlSlurper<T> {
    T slurp(URL url);

    T slurp(String url);
}
