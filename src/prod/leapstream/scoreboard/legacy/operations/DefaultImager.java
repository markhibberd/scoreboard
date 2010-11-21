package leapstream.scoreboard.legacy.operations;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import leapstream.scoreboard.legacy.model.ImageLocation;
import leapstream.scoreboard.legacy.edge.java.net.URL;

public final class DefaultImager implements Imager {
    Nu nu;

    public ImageLocation apply(String url) {
        URL location = nu.nu(URL.class, url);
        return nu.nu(ImageLocation.class, location);
    }
}
