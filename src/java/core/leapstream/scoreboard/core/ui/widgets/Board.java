package leapstream.scoreboard.core.ui.widgets;

import leapstream.scoreboard.core.pylon.PylonView;

public interface Board {
    void add(PylonView pylon, boolean mandatory);
}
