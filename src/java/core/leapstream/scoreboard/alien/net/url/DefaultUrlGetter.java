package leapstream.scoreboard.alien.net.url;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import leapstream.scoreboard.alien.net.auth.HttpAuth;
import leapstream.scoreboard.alien.net.core.SocketMaster;
import leapstream.scoreboard.edge.java.io.InputStream;
import leapstream.scoreboard.edge.java.net.URL;
import leapstream.scoreboard.edge.java.net.URLConnection;

public final class DefaultUrlGetter implements UrlGetter {
    SocketMaster https;
    SocketMaster http;
    HttpAuth auth;
    Nu nu;

    public InputStream input(URL url) {
        URLConnection connection = url.openConnection();
        String info = url.getUserInfo();
        return input(connection, info);
    }

    private InputStream input(URLConnection c, String info) {
        configure(c);
        auth.authenticate(c, info);
        return c.getInputStream();
    }

    private void configure(URLConnection c) {
        // FIX MARKH Be careful of this. Want to catch self signed not all HTTPS.
        // FIX MARKH Self-signed certs should still be checked. Naive* was POC, at least in my view.
        if (https.supports(c)) https.configure(c);
        // FIX MARKH Why HTTP here? No addition gumf required.
        // FIX MARKH If for completeness, what about jar:,file: and the x number of other protocols.
        if (http.supports(c)) http.configure(c);
    }
}
