package leapstream.scoreboard.alien.net.protocol.http;

import leapstream.scoreboard.alien.net.core.SocketMaster;
import leapstream.scoreboard.edge.java.net.URLConnection;

public final class HttpSocketMaster implements SocketMaster {
    public boolean supports(URLConnection c) {
        return false;  // Supported by JDK.
    }

    public void configure(URLConnection c) {
        // Supported by JDK under the hood.
    }
}
