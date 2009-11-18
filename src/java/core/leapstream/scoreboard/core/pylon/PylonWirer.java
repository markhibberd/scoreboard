package leapstream.scoreboard.core.pylon;

import leapstream.scoreboard.alien.ui.core.Ui;

public interface PylonWirer {
    Pylon nu(String name, Ui tile, boolean mandatory);
}
