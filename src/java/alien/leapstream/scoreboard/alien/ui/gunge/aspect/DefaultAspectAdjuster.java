package leapstream.scoreboard.alien.ui.gunge.aspect;

import java.awt.Dimension;

public final class DefaultAspectAdjuster implements AspectAdjuster {
    public Dimension adjustw(Dimension v, Dimension aspect) {
        int w = adjustw(v.width, aspect);
        return new Dimension(w, v.height);
    }

    public Dimension adjusth(Dimension v, Dimension aspect) {
        int h = adjusth(v.height, aspect);
        return new Dimension(v.width, h);
    }

    public Integer adjustw(int w, Dimension aspect) {
        return (w * aspect.width) / aspect.height;
    }

    public Integer adjusth(int h, Dimension aspect) {
        return (h * aspect.height) / aspect.width;
    }
}
