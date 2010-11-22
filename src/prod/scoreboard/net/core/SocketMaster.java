package scoreboard.net.core;

import leapstream.scoreboard.legacy.edge.java.net.URLConnection;

public interface SocketMaster {
    boolean supports(URLConnection c);
    void configure(URLConnection c);
}
