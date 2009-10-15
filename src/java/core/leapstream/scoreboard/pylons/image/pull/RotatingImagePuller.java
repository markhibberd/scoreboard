package leapstream.scoreboard.pylons.image.pull;

import au.net.netstorm.boost.bullet.incredibles.core.Weaken;
import leapstream.scoreboard.alien.ui.gunge.image.ImageData;
import leapstream.scoreboard.core.images.ImageGrabber;
import leapstream.scoreboard.core.model.ImageLocation;
import leapstream.scoreboard.core.model.ImagePack;

import java.util.List;

public final class RotatingImagePuller implements ImagePuller {
    int index = 0;
    ImageGrabber grabber;
    ImagePack pack;
    Weaken weaken;

    public ImageData pull() {
        List<ImageLocation> locations = weaken.w(pack);
        index = (index + 1) % locations.size();
        ImageLocation location = locations.get(index);
        return grabber.grab(location);
    }
}
