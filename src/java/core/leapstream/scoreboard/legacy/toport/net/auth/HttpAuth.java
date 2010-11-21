package leapstream.scoreboard.legacy.toport.net.auth;

import leapstream.scoreboard.legacy.edge.java.net.URLConnection;

public interface HttpAuth {
    void authenticate(URLConnection c, String userinfo);
}
