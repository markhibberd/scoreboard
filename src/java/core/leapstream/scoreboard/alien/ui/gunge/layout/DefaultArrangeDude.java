package leapstream.scoreboard.alien.ui.gunge.layout;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;

public final class DefaultArrangeDude implements ArrangeDude {
    Scraps scraps;

    public void arrange(Layout layout, Component[] mandatory, Component[] optional) {
        Dimension board = layout.layout();
        Point offset = layout.offset();
        Dimension tile = layout.tile();
        Component[] tiles = scraps.tiles(mandatory, optional, board);
        layout(tiles, board, offset, tile);
    }

    // FIX 382 Spin this out into delegate. This manager should just be coordinating.
    private void layout(Component[] tiles, Dimension layout, Point offset, Dimension size) {
        int w = layout.width;
        for (int i = 0; i < tiles.length; ++i) {
            int x = i % w;
            int y = i / w;
            layout(offset, size, tiles[i], x, y);
        }
    }

    private void layout(Point offset, Dimension size, Component tile, int x, int y) {
        int xx = offset.x + x * size.width;
        int yy = offset.y + y * size.height;
        tile.setBounds(xx, yy, size.width, size.height);
    }
}
