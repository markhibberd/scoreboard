package leapstream.scoreboard.alien.ui.gunge.layout;

import au.net.netstorm.boost.bullet.incredibles.core.Struct;

import java.awt.Dimension;
import java.awt.Point;

public interface Layout extends Struct {
    String[] _ = {"offset", "layout", "tile"};
    Point offset();
    Dimension layout();
    Dimension tile();
}
