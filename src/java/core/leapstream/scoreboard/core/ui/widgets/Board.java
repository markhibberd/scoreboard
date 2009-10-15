package leapstream.scoreboard.core.ui.widgets;

import leapstream.scoreboard.core.pylon.Pylon;

public interface Board {
    void add(Pylon pylon, boolean mandatory);
}
