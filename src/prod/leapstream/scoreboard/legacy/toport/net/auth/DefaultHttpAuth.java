package leapstream.scoreboard.legacy.toport.net.auth;

import leapstream.scoreboard.legacy.edge.java.net.URLConnection;
import org.bouncycastle.util.encoders.Base64;

public final class DefaultHttpAuth implements HttpAuth {
    public void authenticate(URLConnection connection, String info) {
        if (info == null) return;
        byte[] bytes = info.getBytes();
        byte[] result = Base64.encode(bytes);
        connection.setRequestProperty("Authorization", "Basic " + new String(result));
    }
}

