package leapstream.scoreboard.legacy.ui.gunge.fitter;

import leapstream.scoreboard.legacy.ui.gunge.aspect.AspectAdjuster;
import leapstream.scoreboard.legacy.ui.gunge.aspect.DefaultAspectAdjuster;

import java.awt.Dimension;

public final class DefaultInsider implements Insider {
    AspectAdjuster aspector = new DefaultAspectAdjuster();

    public Dimension inside(Dimension canvas, Dimension widget, Dimension aspect) {
        int h = canvas.height / widget.height;
        int w = aspector.adjustw(h, aspect);
        if (w * widget.width > canvas.width) return other(canvas, widget, aspect);
        return new Dimension(w, h);
    }

    private Dimension other(Dimension canvas, Dimension widget, Dimension aspect) {
        int w = canvas.width / widget.width;
        int h = aspector.adjusth(w, aspect);
        return new Dimension(w, h);
    }
}
