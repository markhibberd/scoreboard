package leapstream.scoreboard.pylons.score.ui.layout;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Rectangle;

import leapstream.scoreboard.alien.ui.gunge.layout.BoomLayoutManager;

public final class DefaultTileLayoutManager extends BoomLayoutManager implements TileLayoutManager {
    private Component[] parts;
    LayoutDud dud;

    public void set(Component[] parts) {
        if (parts.length != 5) throw new IllegalArgumentException("Expect exactly 5 parts.");
        this.parts = parts;
    }

    public Dimension preferredLayoutSize(Container container) {
        return new Dimension(0, 0); // FIX 244 Smart ... should be based on initial screen sizing.
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
