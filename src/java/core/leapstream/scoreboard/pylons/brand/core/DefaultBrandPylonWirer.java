package leapstream.scoreboard.pylons.brand.core;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import leapstream.scoreboard.core.images.Images;
import leapstream.scoreboard.core.model.ImageLocation;
import leapstream.scoreboard.core.model.ImagePack;
import leapstream.scoreboard.core.pylon.Pylon;
import leapstream.scoreboard.edge.java.net.URL;
import leapstream.scoreboard.pylons.image.core.ImagePylonWirerFu;
import leapstream.scoreboard.pylons.image.ui.core.ImageTile;

import java.util.List;

public final class DefaultBrandPylonWirer implements BrandPylonWirer {
    ImagePylonWirerFu wirer;
    Images images;
    Nu nu;

    public Pylon<ImageTile> nu() {
        List locations = nu.nu(List.class);
        add(locations);
        ImagePack pack = nu.nu(ImagePack.class, locations);
        return wirer.nu(300000, pack);
    }

    private void add(List locations) {
        add(locations, "white.png");
        add(locations, "black.png");
    }

    private void add(List locations, String name) {
        ImageLocation location = location(name);
        locations.add(location);
    }

    private ImageLocation location(String name) {
        URL url = images.get(name);
        return nu.nu(ImageLocation.class, url);
    }
}
