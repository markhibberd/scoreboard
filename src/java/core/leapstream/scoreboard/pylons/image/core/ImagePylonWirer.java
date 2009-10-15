package leapstream.scoreboard.pylons.image.core;

import leapstream.scoreboard.core.pylon.Pylon;
import leapstream.scoreboard.pylons.image.ui.core.ImageTile;

public interface ImagePylonWirer {
    Pylon<ImageTile> nu(String url);
    Pylon<ImageTile> nu(long interval, String... urls);
}
