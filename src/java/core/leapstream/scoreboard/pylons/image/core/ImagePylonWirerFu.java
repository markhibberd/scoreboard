package leapstream.scoreboard.pylons.image.core;

import leapstream.scoreboard.alien.ui.core.Ui;
import leapstream.scoreboard.core.model.ImageLocation;
import leapstream.scoreboard.core.model.ImagePack;

public interface ImagePylonWirerFu {
    Ui nu(ImageLocation location);
    Ui nu(long interval, ImagePack pack);
}
