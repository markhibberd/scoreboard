package leapstream.scoreboard.alien.ui.gunge.layout;

import au.net.netstorm.boost.bullet.incredibles.core.Weaken;
import au.net.netstorm.boost.gunge.array.ArrayMaster;
import leapstream.scoreboard.alien.ui.val.AspectRatio;
import leapstream.scoreboard.alien.ui.val.PreferredSize;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;

public final class DefaultBoardLayoutManager extends BoomLayoutManager implements BoardLayoutManager {
    private Component[] mandatory = {};
    private Component[] optional = {};
    // FIX 1532 Dec 23, 2008 Strong type and get injected.
    ArrangeDude arrange;
    AspectRatio aspect;
    PreferredSize size;
    ArrayMaster arrays;
    LayoutDude dude;
    Weaken weaken;

    public Dimension preferredLayoutSize(Container c) {
        return weaken.w(size);
    }

    public void layoutContainer(Container c) {
        if (mandatory.length == 0) return;
        Dimension size = c.getSize();
        Dimension a = weaken.w(aspect);
        Layout layout = dude.layout(size, mandatory.length, a);
        arrange.arrange(layout, mandatory, optional);
    }

    public void mandatory(Component tile) {
        mandatory = arrays.plus(mandatory, tile);
    }

    public void optional(Component tile) {
        optional = arrays.plus(optional, tile);
    }
}
