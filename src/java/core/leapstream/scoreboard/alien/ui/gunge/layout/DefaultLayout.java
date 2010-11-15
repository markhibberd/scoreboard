package leapstream.scoreboard.alien.ui.gunge.layout;

import java.awt.Dimension;
import java.awt.Point;

public class DefaultLayout implements Layout {
    private final Point offset;
    private final Dimension layout;
    private final Dimension tile;

    public DefaultLayout(Point offset, Dimension layout, Dimension tile) {
        this.offset = offset;
        this.layout = layout;
        this.tile = tile;
    }

    public Point offset() {
        return offset;
    }

    public Dimension layout() {
        return layout;
    }

    public Dimension tile() {
        return tile;
    }
}
