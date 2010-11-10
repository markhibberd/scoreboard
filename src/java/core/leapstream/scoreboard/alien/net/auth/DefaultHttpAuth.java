package leapstream.scoreboard.alien.net.auth;

import au.net.netstorm.boost.bullet.incredibles.core.Weaken;
import leapstream.scoreboard.edge.java.net.URLConnection;
import org.bouncycastle.util.encoders.Base64;

public final class DefaultHttpAuth implements HttpAuth {
    Weaken weaken;

    public void authenticate(URLConnection connection, String info) {
        if (info == null) return;
        byte[] bytes = info.getBytes();
        byte[] result = Base64.encode(bytes);
        connection.setRequestProperty("Authorization", "Basic " + new String(result));
    }
}
