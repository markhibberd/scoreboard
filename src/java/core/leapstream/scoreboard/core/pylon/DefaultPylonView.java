package leapstream.scoreboard.core.pylon;

import leapstream.scoreboard.alien.ui.core.Widget;
import leapstream.scoreboard.core.ui.tile.Tile;

public final class DefaultPylonView<T extends Tile> implements PylonView<T> {
    Widget<T> view;

    public DefaultPylonView(Widget<T> view) {
        this.view = view;
    }

    public Widget<T> view() {
        return view;
    }
}
