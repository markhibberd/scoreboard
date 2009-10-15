package leapstream.scoreboard.pylons.score.ui.core;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import leapstream.scoreboard.alien.ui.core.Widget;
import leapstream.scoreboard.alien.ui.swing.pear.Panel;
import leapstream.scoreboard.pylons.score.ui.comp.Dial;
import leapstream.scoreboard.pylons.score.ui.comp.Freshness;
import leapstream.scoreboard.pylons.score.ui.comp.Pegs;
import leapstream.scoreboard.pylons.score.ui.comp.Status;
import leapstream.scoreboard.pylons.score.ui.comp.Title;
import leapstream.scoreboard.pylons.score.ui.wire.Layout;

import java.awt.Container;

public final class DefaultScoreTileWidgets implements ScoreTileWidgets {
    Layout layout;
    Nu nu;

    public Widget<ScoreTile> nu() {
        Container c = new Panel();
        ScoreTile tile = create();
        layout.layout(c, tile);
        return nu.nu(Widget.class, tile, c);
    }

    // FIX 381 Ensure this is clean.
    private ScoreTile create() {
        Title title = nu.nu(Title.class);
        Pegs pegs = nu.nu(Pegs.class);
        Status status = nu.nu(Status.class);
        Freshness freshness = nu.nu(Freshness.class);
        Dial dial = nu.nu(Dial.class);
        return nu.nu(ScoreTile.class, title, pegs, dial, status, freshness);
    }
}
