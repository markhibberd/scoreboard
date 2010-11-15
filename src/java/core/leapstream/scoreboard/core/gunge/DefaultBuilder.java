package leapstream.scoreboard.core.gunge;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import leapstream.scoreboard.legacy.model.Build;
import leapstream.scoreboard.legacy.model.Name;
import leapstream.scoreboard.edge.java.net.URL;

public final class DefaultBuilder implements Builder {
    Urler urler;
    Nu nu;

    public Build get(String name, String url) {
        Name n = nu.nu(Name.class, name);
        URL u = urler.get(url);
        return nu.nu(Build.class, n, u);
    }
}
