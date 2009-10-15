package leapstream.scoreboard.pylons.image.core;

import leapstream.scoreboard.core.model.ImageLocation;
import leapstream.scoreboard.core.model.ImagePack;
import leapstream.scoreboard.core.pylon.Pylon;
import leapstream.scoreboard.pylons.image.ui.core.ImageTile;

public interface ImagePylonWirerFu {
    Pylon<ImageTile> nu(ImageLocation location);
    Pylon<ImageTile> nu(long interval, ImagePack pack);
}
