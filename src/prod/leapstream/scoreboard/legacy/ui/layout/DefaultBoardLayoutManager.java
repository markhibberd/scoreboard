package leapstream.scoreboard.legacy.ui.layout;

import leapstream.scoreboard.legacy.ui.gunge.layout.DefaultArrangeDude;
import leapstream.scoreboard.legacy.ui.gunge.layout.DefaultLayoutDude;
import leapstream.scoreboard.legacy.ui.core.Ui;
import leapstream.scoreboard.legacy.ui.gunge.layout.BoomLayoutManager;
import leapstream.scoreboard.legacy.ui.gunge.layout.ArrangeDude;
import leapstream.scoreboard.legacy.ui.gunge.layout.LayoutDude;
import leapstream.scoreboard.legacy.ui.gunge.layout.Layout;
import leapstream.scoreboard.legacy.pylon.DefaultPylons;
import leapstream.scoreboard.legacy.pylon.PylonX;
import leapstream.scoreboard.legacy.pylon.Pylons;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.util.List;

public class DefaultBoardLayoutManager extends BoomLayoutManager implements BoardLayoutManager {
    ArrangeDude arrange = new DefaultArrangeDude();
    Dimension preferred = new Dimension(800, 800);
    Dimension aspect = new Dimension(5, 6);
    LayoutDude dude = new DefaultLayoutDude();
    Pylons pylons = new DefaultPylons();
    
    public Pylons pylons() {
        return pylons;
    }

    public Dimension preferredLayoutSize(Container c) {
        return preferred;
    }

    // FIX LIFECYCLE Push PylonX deeper.
    public void layoutContainer(Container c) {
        List<PylonX> mandatory = pylons.mandatory();
        List<PylonX> optional = pylons.optional();
        if (mandatory.size() == 0) return;
        Dimension size = c.getSize();
        Dimension a = aspect;
        Layout layout = dude.layout(size, mandatory.size(), a);
        arrange(mandatory, optional, layout);
    }

    private void arrange(List<PylonX> mandatory, List<PylonX> optional, Layout layout) {
        Component[] ms = components(mandatory);
        Component[] os = components(optional);
        arrange.arrange(layout, ms, os);
    }

    // FIX LIFECYCLE Remove need for this.
    private Component[] components(List<PylonX> pylonXs) {
        Component[] components = new Component[pylonXs.size()];
        for (int i = 0; i < pylonXs.size(); i++) {
            PylonX pylonX = pylonXs.get(i);
            Ui view = pylonX.view();
            components[i] = view.ui();
        }
        return components;
    }
}
