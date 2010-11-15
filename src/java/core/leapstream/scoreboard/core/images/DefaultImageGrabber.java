package leapstream.scoreboard.core.images;

import au.net.netstorm.boost.bullet.incredibles.core.Weaken;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import leapstream.scoreboard.alien.io.stream.BytesFromInputStream;
import leapstream.scoreboard.alien.net.url.UrlProcessor;
import leapstream.scoreboard.alien.ui.gunge.image.ImageData;
import leapstream.scoreboard.legacy.model.ImageLocation;
import leapstream.scoreboard.edge.java.net.URL;

public final class DefaultImageGrabber implements ImageGrabber {
    BytesFromInputStream byter;
    UrlProcessor net;
    Weaken weaken;
    Nu nu;

    public ImageData grab(ImageLocation location) {
        URL url = weaken.w(location);
        byte[] bytes = net.process(url, byter);
        return nu.nu(ImageData.class, (Object) bytes);
    }
}
