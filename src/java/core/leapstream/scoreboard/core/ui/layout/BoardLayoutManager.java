package leapstream.scoreboard.core.ui.layout;

import leapstream.scoreboard.core.pylon.Pylons;

import java.awt.LayoutManager;

public interface BoardLayoutManager extends LayoutManager {
    Pylons pylons();
}
