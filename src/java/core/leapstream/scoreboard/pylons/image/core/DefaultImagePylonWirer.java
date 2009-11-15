package leapstream.scoreboard.pylons.image.core;

import au.net.netstorm.boost.gunge.collection.FunctionalCollection;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import leapstream.scoreboard.core.gunge.Imager;
import leapstream.scoreboard.core.model.ImageLocation;
import leapstream.scoreboard.core.model.ImagePack;
import leapstream.scoreboard.core.pylon.PylonView;
import leapstream.scoreboard.pylons.image.ui.core.ImageTile;

import java.util.List;

public class DefaultImagePylonWirer implements ImagePylonWirer {
    ImagePylonWirerFu images;
    Imager imager;
    Nu nu;
    FunctionalCollection fc;

    public PylonView<ImageTile> nu(String url) {
        ImageLocation location = imager.apply(url);
        return images.nu(location);
    }

    public PylonView<ImageTile> nu(long interval, String... urls) {
        List<ImageLocation> list = fc.map(urls, imager);
        ImagePack pack = nu.nu(ImagePack.class, list);
        return images.nu(interval, pack);
    }
}
