package leapstream.scoreboard.legacy.ui.gunge.fitter;

import java.awt.Dimension;
import java.awt.Point;

public final class DefaultFitter implements Fitter {
    public Point fit(Dimension canvas, Dimension layout, Dimension widget) {
        int x = (canvas.width - layout.width * widget.width) / 2;
        int y = (canvas.height - layout.height * widget.height) / 2;
        return new Point(x, y);
    }
}
