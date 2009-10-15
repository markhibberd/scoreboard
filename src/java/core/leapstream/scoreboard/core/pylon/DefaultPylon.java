package leapstream.scoreboard.core.pylon;

import leapstream.scoreboard.core.ui.tile.Tile;
import leapstream.scoreboard.alien.ui.core.Widget;
import au.net.netstorm.boost.gunge.lifecycle.StartStop;

public final class DefaultPylon<T extends Tile> implements Pylon<T> {
    Widget<T> view;
    StartStop ss;

    public DefaultPylon(Widget<T> view, StartStop ss) {
        this.view = view;
        this.ss = ss;
    }

    public Widget<T> view() {
        return view;
    }

    public void start() {
        ss.start();
    }

    public void stop() {
        ss.stop();
    }
}
