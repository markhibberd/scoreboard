package leapstream.scoreboard.core.pylon;

import au.net.netstorm.boost.gunge.lifecycle.StartStop;
import leapstream.scoreboard.core.ui.tile.Tile;

public interface Pylon<T extends Tile> extends Viewable<T>, StartStop {
}
