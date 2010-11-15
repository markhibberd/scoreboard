package leapstream.scoreboard.core.ui.widgets;

import au.net.netstorm.boost.spider.api.lifecycle.Constructable;
import au.net.netstorm.boost.spider.api.runtime.Impl;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import leapstream.scoreboard.alien.ui.core.Ui;
import leapstream.scoreboard.alien.ui.core.Widget;
import leapstream.scoreboard.core.pylon.PylonX;
import leapstream.scoreboard.core.pylon.WrappedPylonX;
import leapstream.scoreboard.core.ui.layout.BoardLayoutManager;
import leapstream.scoreboard.alien.ui.swing.pear.Panel;
import leapstream.scoreboard.core.pylon.Pylons;

import javax.swing.JComponent;

public final class DefaultBoard implements Board, Widget<Board>, Constructable {
    BoardLayoutManager layout;
    NavigableTiles navigator;
    Pylons pylons;
    Panel panel;
    Impl impl;
    Nu nu;

    public void constructor() {
        panel.setLayout(layout);
    }

    public Board control() {
        return this;
    }

    public JComponent ui() {
        return panel;
    }

    public void add(PylonX pylonX) {
        Ui view = pylonX.view();
        JComponent c = view.ui();
        // FIX 1531 Dec 4, 2008 SPIKE.
        Ui n = navigator.wrap(c);
        PylonX wrapped = impl.impl(WrappedPylonX.class, pylonX, n);
        panel.add(n.ui());
        pylons.add(wrapped);
    }
}
