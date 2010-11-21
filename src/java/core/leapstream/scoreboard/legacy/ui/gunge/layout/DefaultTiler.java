package leapstream.scoreboard.legacy.ui.gunge.layout;

import java.awt.Dimension;

public final class DefaultTiler implements Tiler {
    public Dimension tile(int h, int tiles) {
        int w = (tiles - 1) / h + 1;
        return new Dimension(w, h);
    }
}
