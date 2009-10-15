package leapstream.scoreboard.core.gunge;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import leapstream.scoreboard.edge.java.net.URL;

public final class DefaultUrler implements Urler {
    Nu nu;

    public URL get(String url) {
        return nu.nu(URL.class, url);
    }

    public URL[] get(String[] urls) {
        URL[] r = new URL[urls.length];
        for (int i = 0; i < r.length; i++) r[i] = get(urls[i]);
        return r;
    }
}
