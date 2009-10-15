package leapstream.scoreboard.alien.net.auth;

import leapstream.scoreboard.edge.java.net.URLConnection;

public interface HttpAuth {
    void authenticate(URLConnection c, String userinfo);
}
