package leapstream.scoreboard.legacy.toport.net.protocol.https;

import au.net.netstorm.boost.bullet.scalpel.core.Edges;
import leapstream.scoreboard.legacy.toport.net.core.SocketMaster;
import leapstream.scoreboard.legacy.edge.java.net.URLConnection;
import leapstream.scoreboard.legacy.edge.javax.net.ssl.HttpsURLConnection;
import leapstream.scoreboard.legacy.edge.javax.net.ssl.SSLContext;
import leapstream.scoreboard.legacy.edge.javax.net.ssl.SSLContextStatic;
import leapstream.scoreboard.legacy.edge.javax.net.ssl.SSLSocketFactory;

import javax.net.ssl.KeyManager;
import javax.net.ssl.TrustManager;
import java.security.SecureRandom;

public final class HttpsSocketMaster implements SocketMaster {
    SSLContextStatic contexts;
    TrustManager naive;
    Edges edges;

    public boolean supports(URLConnection c) {
        return edges.is(c, HttpsURLConnection.class);
    }

    public void configure(URLConnection c) {
        SSLSocketFactory factory = factory();
        set(c, factory);
    }

    private void set(URLConnection c, SSLSocketFactory factory) {
        HttpsURLConnection https = edges.cast(HttpsURLConnection.class, c);
        https.setSSLSocketFactory(factory);
    }

    private SSLSocketFactory factory() {
        TrustManager[] tm = new TrustManager[]{naive};
        SSLContext context = contexts.getInstance("SSL");
        SecureRandom random = new SecureRandom();
        KeyManager[] managers = new KeyManager[0];
        context.init(managers, tm, random);
        return context.getSocketFactory();
    }
}
