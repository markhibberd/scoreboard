package scoreboard.pylons.score.ui.layout;

import leapstream.scoreboard.legacy.ui.gunge.layout.BoomLayoutManager;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Rectangle;

public final class DefaultTileLayoutManager extends BoomLayoutManager implements TileLayoutManager {
    private Component[] parts;
    private LayoutDud dud = new DefaultLayoutDud();

    public void set(Component[] parts) {
        if (parts.length != 5) throw new IllegalArgumentException("Expect exactly 5 parts.");
        this.parts = parts;
    }

    public Dimension preferredLayoutSize(Container container) {
        return new Dimension(50, 50); // FIX 244 Smart ... should be based on initial screen sizing.
    }

    public void layoutContainer(Container container) {
        Dimension canvas = container.getSize();
        Rectangle[] bounds = dud.layout(canvas);
        boundem(bounds);
    }

    private void boundem(Rectangle[] bounds) {
        for (int i = 0; i < parts.length; i++) {
            parts[i].setBounds(bounds[i]);
        }
    }
}
