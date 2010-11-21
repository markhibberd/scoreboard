package leapstream.scoreboard.legacy.ui.gunge.fitter;

import java.awt.Dimension;
import java.awt.Point;

public interface Fitter {
    Point fit(Dimension canvas, Dimension layout, Dimension widget);
}
