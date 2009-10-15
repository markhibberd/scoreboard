package leapstream.scoreboard.core.gunge;

import au.net.netstorm.boost.bullet.scalpel.core.Edges;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import leapstream.scoreboard.core.model.ImageLocation;
import leapstream.scoreboard.edge.java.net.URL;

public final class DefaultImager implements Imager {
    Nu nu;
    Edges edges;

    public ImageLocation apply(String url) {
        URL location = nu.nu(URL.class, url);
        return nu.nu(ImageLocation.class, location);
    }
}
