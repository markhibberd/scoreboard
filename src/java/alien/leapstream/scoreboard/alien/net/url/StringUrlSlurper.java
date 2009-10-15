package leapstream.scoreboard.alien.net.url;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import leapstream.scoreboard.alien.gunge.StringSlurper;
import leapstream.scoreboard.edge.java.io.InputStream;
import leapstream.scoreboard.edge.java.net.URL;

public final class StringUrlSlurper implements UrlSlurper<String> {
    StringSlurper slurper;
    UrlGetter getter;
    Nu nu;

    public String slurp(URL url) {
        InputStream is = getter.input(url);
        return slurper.slurp(is);
    }

    public String slurp(String url) {
        URL u = nu.nu(URL.class, url);
        return slurp(u);
    }
}
