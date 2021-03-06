package leapstream.scoreboard.alien.ui.gunge.layout;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import leapstream.scoreboard.alien.ui.gunge.fitter.Fitter;
import leapstream.scoreboard.alien.ui.gunge.fitter.Insider;
import leapstream.scoreboard.alien.ui.gunge.invert.Inverter;

import java.awt.Dimension;
import java.awt.Point;

public final class DefaultLayoutDude implements LayoutDude {
    Inverter inverter;
    Insider insider;
    Fitter fitter;
    Tiler tiler;
    Nu nu;

    public Layout layout(Dimension canvas, int count, Dimension aspect) {
        Dimension[] layouts = layouts(count);
        Dimension[] tiles = tiles(canvas, layouts, aspect);
        return biggest(canvas, layouts, tiles);
    }

    private Layout biggest(Dimension canvas, Dimension[] layouts, Dimension[] tiles) {
        Dimension layout = layouts[0];
        Dimension tile = tiles[0];
        for (int i = 1; i < tiles.length; i++) {
            if (tiles[i].width < tile.width) continue;
            layout = layouts[i];
            tile = tiles[i];
        }
        return layout(canvas, layout, tile);
    }

    private Layout layout(Dimension canvas, Dimension layout, Dimension tile) {
        Point offset = fitter.fit(canvas, layout, tile);
        return nu.nu(Layout.class, offset, layout, tile);
    }

    private int max(int tiles) {
        double dmax = Math.sqrt(tiles - 1);
        return (int) dmax + 1;
    }

    private Dimension[] layouts(int tiles) {
        int max = max(tiles);
        Dimension[] result = new Dimension[max * 2];
        for (int i = 0; i < max; i++) {
            layouts(i, result, tiles);
        }
        return result;
    }

    private void layouts(int i, Dimension[] result, int tiles) {
        Dimension d = tiler.tile(i + 1, tiles);
        result[2 * i] = d;
        result[2 * i + 1] = inverter.invert(d);
    }

    private Dimension[] tiles(Dimension canvas, Dimension[] layouts, Dimension aspect) {
        Dimension[] result = new Dimension[layouts.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = insider.inside(canvas, layouts[i], aspect);
        }
        return result;
    }
}
