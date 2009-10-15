package leapstream.scoreboard.pylons.image.ui.core;

import au.net.netstorm.boost.bullet.incredibles.core.Struct;
import leapstream.scoreboard.alien.ui.core.Widget;
import leapstream.scoreboard.alien.ui.gunge.image.Image;
import leapstream.scoreboard.core.ui.tile.Tile;

public interface ImageTile extends Tile, Struct {
    Widget<Image> image();
}
