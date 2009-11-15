package leapstream.scoreboard.pylons.image.core;

import leapstream.scoreboard.core.model.ImageLocation;
import leapstream.scoreboard.core.model.ImagePack;
import leapstream.scoreboard.core.pylon.PylonView;
import leapstream.scoreboard.pylons.image.ui.core.ImageTile;

public interface ImagePylonWirerFu {
    PylonView<ImageTile> nu(ImageLocation location);
    PylonView<ImageTile> nu(long interval, ImagePack pack);
}
