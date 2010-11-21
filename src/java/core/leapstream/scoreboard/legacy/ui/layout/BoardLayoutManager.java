package leapstream.scoreboard.legacy.ui.layout;

import leapstream.scoreboard.legacy.pylon.Pylons;

import java.awt.LayoutManager;

public interface BoardLayoutManager extends LayoutManager {
    Pylons pylons();
}
