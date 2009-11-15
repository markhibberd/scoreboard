package leapstream.scoreboard.pylons.image.core;

import leapstream.scoreboard.core.pylon.PylonView;
import leapstream.scoreboard.pylons.image.ui.core.ImageTile;

public interface ImagePylonWirer {
    PylonView<ImageTile> nu(String url);
    PylonView<ImageTile> nu(long interval, String... urls);
}
