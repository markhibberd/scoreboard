package leapstream.scoreboard.pylons.image.core;

import leapstream.scoreboard.alien.ui.core.Ui;

public interface ImagePylonWirer {
    Ui nu(String url);
    Ui nu(long interval, String... urls);
}
