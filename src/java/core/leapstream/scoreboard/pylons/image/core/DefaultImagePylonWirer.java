package leapstream.scoreboard.pylons.image.core;

import au.net.netstorm.boost.gunge.collection.FunctionalCollection;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import leapstream.scoreboard.alien.ui.core.Ui;
import leapstream.scoreboard.core.gunge.Imager;
import leapstream.scoreboard.core.model.ImageLocation;
import leapstream.scoreboard.core.model.ImagePack;

import java.util.List;

public class DefaultImagePylonWirer implements ImagePylonWirer {
    ImagePylonWirerFu images;
    Imager imager;
    Nu nu;
    FunctionalCollection fc;

    public Ui nu(String url) {
        ImageLocation location = imager.apply(url);
        return images.nu(location);
    }

    public Ui nu(long interval, String... urls) {
        List<ImageLocation> list = fc.map(urls, imager);
        ImagePack pack = nu.nu(ImagePack.class, list);
        return images.nu(interval, pack);
    }
}
