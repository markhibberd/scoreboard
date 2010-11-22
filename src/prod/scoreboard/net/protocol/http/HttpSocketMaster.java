package scoreboard.net.protocol.http;

import scoreboard.net.core.SocketMaster;
import leapstream.scoreboard.legacy.edge.java.net.URLConnection;

public final class HttpSocketMaster implements SocketMaster {
    public boolean supports(URLConnection c) {
        return false;  // Supported by JDK.
    }

    public void configure(URLConnection c) {
        // Supported by JDK under the hood.
    }
}
