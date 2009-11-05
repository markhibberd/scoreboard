package leapstream.scoreboard.core.pylon;

import leapstream.scoreboard.core.ui.tile.Tile;
import leapstream.scoreboard.alien.ui.core.Widget;
import au.net.netstorm.boost.gunge.lifecycle.StartStop;

public final class DefaultPylon<T extends Tile> implements Pylon<T> {
    Widget<T> view;

    public DefaultPylon(Widget<T> view) {
        this.view = view;
    }

    public Widget<T> view() {
        return view;
    }
}
