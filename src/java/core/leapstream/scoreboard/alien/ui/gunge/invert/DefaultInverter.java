package leapstream.scoreboard.alien.ui.gunge.invert;

import java.awt.Dimension;
import java.awt.Point;

public final class DefaultInverter implements Inverter {
    public Dimension invert(Dimension d) {
        return new Dimension(d.height, d.width);
    }

    public Point invert(Point p) {
        return new Point(p.y, p.x);
    }
}
