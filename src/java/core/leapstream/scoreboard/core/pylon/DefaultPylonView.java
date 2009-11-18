package leapstream.scoreboard.core.pylon;

import leapstream.scoreboard.alien.ui.core.Widget;
import leapstream.scoreboard.core.ui.tile.Tile;

public final class DefaultPylonView<T extends Tile> implements Viewable<T> {
    Widget<T> view;

    public DefaultPylonView(Widget<T> view) {
        this.view = view;
    }

    public Widget<T> widget() {
        return view;
    }
}
