package leapstream.scoreboard.legacy.operations;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import leapstream.scoreboard.legacy.edge.java.net.URL;

public final class DefaultUrler implements Urler {
    Nu nu;

    public URL get(String url) {
        String defaulted = url.contains(":") ? url : "file:" + url;
        return nu.nu(URL.class, defaulted);
    }

    public URL[] get(String[] urls) {
        URL[] r = new URL[urls.length];
        for (int i = 0; i < r.length; i++) r[i] = get(urls[i]);
        return r;
    }
}
