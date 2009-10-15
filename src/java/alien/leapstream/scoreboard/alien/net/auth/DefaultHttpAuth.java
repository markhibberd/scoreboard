package leapstream.scoreboard.alien.net.auth;

import au.net.netstorm.boost.bullet.incredibles.core.Weaken;
import leapstream.scoreboard.edge.java.net.URLConnection;
import sun.misc.BASE64Encoder;

public final class DefaultHttpAuth implements HttpAuth {
    Weaken weaken;

    public void authenticate(URLConnection connection, String info) {
        if (info == null) return;
        BASE64Encoder encoder = new BASE64Encoder();
        byte[] bytes = info.getBytes();
        String encoded = encoder.encode(bytes);
        connection.setRequestProperty("Authorization", "Basic " + encoded);
    }
}
// SUGGEST: Probably should bite the bullet and do HttpClient. I can already feel the pain.
// FIX MARKH Would recommend BASE64 encode rather than full HttpClient. Maybe a case for it to be implemented in boost?
