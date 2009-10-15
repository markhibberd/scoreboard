package leapstream.scoreboard.pylons.status.ui.core;

import au.net.netstorm.boost.bullet.incredibles.core.Struct;
import leapstream.scoreboard.alien.ui.core.Widget;
import leapstream.scoreboard.core.ui.tile.Tile;
import leapstream.scoreboard.pylons.score.ui.comp.Dial;

public interface StatusTile extends Tile, Struct {
    Widget<Dial> dial();
}
