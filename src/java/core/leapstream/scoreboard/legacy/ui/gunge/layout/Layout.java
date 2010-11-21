package leapstream.scoreboard.legacy.ui.gunge.layout;

import java.awt.Dimension;
import java.awt.Point;

public interface Layout {
    Point offset();
    Dimension layout();
    Dimension tile();
}
