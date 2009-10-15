package leapstream.scoreboard.pylons.status.core;

import leapstream.scoreboard.core.pylon.Pylon;
import leapstream.scoreboard.pylons.status.ui.core.StatusTile;

public interface StatusPylonWirer {
    Pylon<StatusTile> nu(String name, String url);
}
