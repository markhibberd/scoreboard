package leapstream.scoreboard.pylons.score.ui.core;

import au.net.netstorm.boost.bullet.incredibles.core.Struct;
import leapstream.scoreboard.alien.ui.core.Widget;
import leapstream.scoreboard.core.ui.tile.Tile;
import leapstream.scoreboard.pylons.score.ui.comp.Dial;
import leapstream.scoreboard.pylons.score.ui.comp.Freshness;
import leapstream.scoreboard.pylons.score.ui.comp.Pegs;
import leapstream.scoreboard.pylons.score.ui.comp.Status;
import leapstream.scoreboard.pylons.score.ui.comp.Title;

public interface ScoreTile extends Tile, Struct {
    // FIX 381 This has to be sorted.  The ordering changes and HURTS!!!
    String[] _ = {"title", "pegs", "dial", "status", "freshness"};

    Widget<Title> title();

    Widget<Pegs> pegs();

    Widget<Dial> dial();

    Widget<Status> status();

    Widget<Freshness> freshness();
}
