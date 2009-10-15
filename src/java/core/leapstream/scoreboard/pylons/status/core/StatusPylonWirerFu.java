package leapstream.scoreboard.pylons.status.core;

import leapstream.scoreboard.core.model.Build;
import leapstream.scoreboard.core.pylon.Pylon;
import leapstream.scoreboard.pylons.status.ui.core.StatusTile;

public interface StatusPylonWirerFu {
    Pylon<StatusTile> nu(Build build);
}
