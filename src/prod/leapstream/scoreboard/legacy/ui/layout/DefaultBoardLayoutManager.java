package leapstream.scoreboard.legacy.ui.layout;

import leapstream.scoreboard.legacy.ui.gunge.layout.DefaultArrangeDude;
import leapstream.scoreboard.legacy.ui.gunge.layout.DefaultLayoutDude;
import leapstream.scoreboard.legacy.ui.gunge.layout.BoomLayoutManager;
import leapstream.scoreboard.legacy.ui.gunge.layout.ArrangeDude;
import leapstream.scoreboard.legacy.ui.gunge.layout.LayoutDude;
import leapstream.scoreboard.legacy.ui.gunge.layout.Layout;

import javax.swing.JComponent;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.util.List;

public class DefaultBoardLayoutManager extends BoomLayoutManager implements BoardLayoutManager {
    ArrangeDude arrange = new DefaultArrangeDude();
    Dimension preferred = new Dimension(800, 800);
    Dimension aspect = new Dimension(5, 6);
    LayoutDude dude = new DefaultLayoutDude();
    private List<JComponent> mandatory;
    private List<JComponent> optional;


    public DefaultBoardLayoutManager(List<JComponent> mandatory, List<JComponent> optional) {
        this.mandatory = mandatory;
        this.optional = optional;
    }

    public Dimension preferredLayoutSize(Container c) {
        return preferred;
    }

    public void layoutContainer(Container c) {
        if (mandatory.size() == 0) return;
        Dimension size = c.getSize();
        Dimension a = aspect;
        Layout layout = dude.layout(size, mandatory.size(), a);
        arrange(mandatory, optional, layout);
    }

    private void arrange(List<JComponent> mandatory, List<JComponent> optional, Layout layout) {
        Component[] ms = components(mandatory);
        Component[] os = components(optional);
        arrange.arrange(layout, ms, os);
    }

    // FIX LIFECYCLE Remove need for this.
    private Component[] components(List<JComponent> cs) {
        Component[] components = new Component[cs.size()];
        for (int i = 0; i < cs.size(); i++) {
            components[i] = cs.get(i);
        }
        return components;
    }
}
