package leapstream.scoreboard.core.images;

import leapstream.scoreboard.alien.ui.gunge.image.ImageData;
import leapstream.scoreboard.legacy.model.ImageLocation;

public interface ImageGrabber {
    ImageData grab(ImageLocation location);
}
