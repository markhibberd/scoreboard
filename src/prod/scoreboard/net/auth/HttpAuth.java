package scoreboard.net.auth;

import leapstream.scoreboard.legacy.edge.java.net.URLConnection;

public interface HttpAuth {
    void authenticate(URLConnection c, String userinfo);
}
