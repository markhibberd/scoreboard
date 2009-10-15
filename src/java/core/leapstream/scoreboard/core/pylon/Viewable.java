package leapstream.scoreboard.core.pylon;

import leapstream.scoreboard.alien.ui.core.Widget;

public interface Viewable<T> {
    Widget<T> view();
}
