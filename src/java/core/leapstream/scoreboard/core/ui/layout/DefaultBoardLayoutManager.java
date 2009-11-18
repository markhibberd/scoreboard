package leapstream.scoreboard.core.ui.layout;

import au.net.netstorm.boost.bullet.incredibles.core.Weaken;
import au.net.netstorm.boost.gunge.array.ArrayMaster;
import leapstream.scoreboard.alien.ui.val.AspectRatio;
import leapstream.scoreboard.alien.ui.val.PreferredSize;
import leapstream.scoreboard.alien.ui.core.Ui;
import leapstream.scoreboard.alien.ui.gunge.layout.BoomLayoutManager;
import leapstream.scoreboard.alien.ui.gunge.layout.ArrangeDude;
import leapstream.scoreboard.alien.ui.gunge.layout.LayoutDude;
import leapstream.scoreboard.alien.ui.gunge.layout.Layout;
import leapstream.scoreboard.core.pylon.Pylon;
import leapstream.scoreboard.core.pylon.Pylons;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.util.List;

public class DefaultBoardLayoutManager extends BoomLayoutManager implements BoardLayoutManager {
    ArrangeDude arrange;
    AspectRatio aspect;
    PreferredSize size;
    ArrayMaster arrays;
    LayoutDude dude;
    Weaken weaken;
    // FIX LIFECYCLE Constructorize this??? 
    Pylons pylons;

    public Dimension preferredLayoutSize(Container c) {
        return weaken.w(size);
    }

    // FIX LIFECYCLE Push Pylon deeper. 
    public void layoutContainer(Container c) {
        List<Pylon> mandatory = pylons.mandatory();
        List<Pylon> optional = pylons.optional();
        if (mandatory.size() == 0) return;
        Dimension size = c.getSize();
        Dimension a = weaken.w(aspect);
        Layout layout = dude.layout(size, mandatory.size(), a);
        arrange(mandatory, optional, layout);
    }

    private void arrange(List<Pylon> mandatory, List<Pylon> optional, Layout layout) {
        Component[] ms = components(mandatory);
        Component[] os = components(optional);
        arrange.arrange(layout, ms, os);
    }

    // FIX LIFECYCLE Remove need for this.
    private Component[] components(List<Pylon> pylons) {
        Component[] components = new Component[pylons.size()];
        for (int i = 0; i < pylons.size(); i++) {
            Pylon pylon = pylons.get(i);
            Ui view = pylon.view();
            components[i] = view.ui();
        }
        return components;
    }
}
