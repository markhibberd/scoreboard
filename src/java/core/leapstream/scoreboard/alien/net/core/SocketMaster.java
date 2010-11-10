package leapstream.scoreboard.alien.net.core;

import leapstream.scoreboard.edge.java.net.URLConnection;

public interface SocketMaster {
    boolean supports(URLConnection c);
    void configure(URLConnection c);
}
