package leapstream.scoreboard.pylons.image.pull;

import leapstream.scoreboard.alien.ui.gunge.image.ImageData;
import leapstream.scoreboard.core.images.ImageGrabber;
import leapstream.scoreboard.core.model.ImageLocation;

public final class DefaultImagePuller implements ImagePuller {
    ImageGrabber grabber;
    ImageLocation location;

    public ImageData pull() {
        return grabber.grab(location);
    }
}
