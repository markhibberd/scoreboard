package leapstream.scoreboard.alien.ui.gunge.invert;

import java.awt.Dimension;
import java.awt.Point;

public interface Inverter {
    Dimension invert(Dimension d);
    Point invert(Point p);
}
