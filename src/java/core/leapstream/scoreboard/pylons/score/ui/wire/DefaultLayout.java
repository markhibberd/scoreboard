package leapstream.scoreboard.pylons.score.ui.wire;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import leapstream.scoreboard.alien.ui.core.Ui;
import leapstream.scoreboard.alien.ui.gunge.border.Borders;
import leapstream.scoreboard.alien.ui.swing.pear.Panel;
import leapstream.scoreboard.pylons.score.ui.core.ScoreTile;
import leapstream.scoreboard.pylons.score.ui.layout.TileLayoutManager;

import javax.swing.JComponent;
import javax.swing.border.Border;
import java.awt.Component;
import java.awt.Container;

public final class DefaultLayout implements Layout {
    Borders borders;
    Nu nu;

    public void layout(Container c, ScoreTile tile) {
        Component[] parts = parts(tile);
        Panel panel = new Panel();
        c.add(panel);
        Border border = borders.border(2, 1);
        ((JComponent) c).setBorder(border); // FIX 244 Remove or tidy border stuff.
        layout(panel, parts);
        add(panel, parts);
    }

    private void layout(Container c, Component[] parts) {
        TileLayoutManager layout = nu.nu(TileLayoutManager.class);
        layout.set(parts);
        c.setLayout(layout);
    }

    private Component[] parts(ScoreTile tile) {
        Ui title = tile.title();
        Ui pegs = tile.pegs();
        Ui dial = tile.dial();
        Ui status = tile.status();
        Ui freshness = tile.freshness();
        Ui[] uis = {title, pegs, dial, status, freshness};
        return components(uis);
    }

    private void add(Container c, Component[] parts) {
        for (Component part : parts) c.add(part);
    }

    private Component[] components(Ui[] uis) {
        Component[] r = new Component[uis.length];
        for (int i = 0; i < r.length; i++) r[i] = uis[i].ui();
        return r;
    }
}
