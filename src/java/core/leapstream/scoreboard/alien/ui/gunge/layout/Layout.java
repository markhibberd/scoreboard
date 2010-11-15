package leapstream.scoreboard.alien.ui.gunge.layout;

import au.net.netstorm.boost.bullet.incredibles.core.Struct;

import java.awt.Dimension;
import java.awt.Point;

public interface Layout {
    Point offset();
    Dimension layout();
    Dimension tile();
}
