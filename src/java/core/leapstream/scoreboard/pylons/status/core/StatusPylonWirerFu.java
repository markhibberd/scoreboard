package leapstream.scoreboard.pylons.status.core;

import leapstream.scoreboard.core.model.Build;
import leapstream.scoreboard.core.pylon.PylonView;
import leapstream.scoreboard.pylons.status.ui.core.StatusTile;

public interface StatusPylonWirerFu {
    PylonView<StatusTile> nu(Build build);
}
