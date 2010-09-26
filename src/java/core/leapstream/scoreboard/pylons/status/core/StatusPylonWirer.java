package leapstream.scoreboard.pylons.status.core;

import leapstream.scoreboard.alien.ui.core.Ui;

public interface StatusPylonWirer {
    Ui nu(String name, String url, int poll);
    Ui nu(String name, String url);
}
