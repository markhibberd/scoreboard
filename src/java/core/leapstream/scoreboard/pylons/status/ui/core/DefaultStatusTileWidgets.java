package leapstream.scoreboard.pylons.status.ui.core;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import leapstream.scoreboard.alien.ui.core.Widget;
import leapstream.scoreboard.alien.ui.gunge.border.Borders;
import leapstream.scoreboard.alien.ui.swing.pear.Panel;
import leapstream.scoreboard.pylons.score.ui.comp.Dial;

import javax.swing.JComponent;
import javax.swing.border.Border;
import java.awt.Component;
import java.awt.Container;

public final class DefaultStatusTileWidgets implements StatusTileWidgets {
    Borders borders;
    Nu nu;

    public Widget<StatusTile> nu() {
        Container c = new Panel();
        StatusTile tile = create();
        Widget<Dial> widget = tile.dial();
        Component comp = widget.ui();
        c.add(comp);
        pretty(c);
        return nu.nu(Widget.class, tile, c);
    }

    // FIX 244 Sort this shit. Borders should be free for everyone.
    private void pretty(Container c) {
        Border border = borders.border(2, 1);
        ((JComponent) c).setBorder(border);
    }

    private StatusTile create() {
        Dial dial = nu.nu(Dial.class);
        return nu.nu(StatusTile.class, dial);
    }
}
