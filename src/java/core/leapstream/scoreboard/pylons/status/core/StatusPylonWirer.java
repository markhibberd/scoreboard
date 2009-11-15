package leapstream.scoreboard.pylons.status.core;

import leapstream.scoreboard.core.pylon.PylonView;
import leapstream.scoreboard.pylons.status.ui.core.StatusTile;

public interface StatusPylonWirer {
    PylonView<StatusTile> nu(String name, String url);
}
