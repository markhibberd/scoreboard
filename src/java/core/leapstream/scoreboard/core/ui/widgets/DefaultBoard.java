package leapstream.scoreboard.core.ui.widgets;

import au.net.netstorm.boost.spider.api.lifecycle.Constructable;
import au.net.netstorm.boost.spider.api.runtime.Impl;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import leapstream.scoreboard.alien.ui.core.Ui;
import leapstream.scoreboard.alien.ui.core.Widget;
import leapstream.scoreboard.core.ui.layout.BoardLayoutManager;
import leapstream.scoreboard.alien.ui.swing.pear.Panel;
import leapstream.scoreboard.core.pylon.Pylon;
import leapstream.scoreboard.core.pylon.Pylons;
import leapstream.scoreboard.core.pylon.WrappedPylon;

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

    public void add(Pylon pylon) {
        Ui view = pylon.view();
        JComponent c = view.ui();
        // FIX 1531 Dec 4, 2008 SPIKE.
        Ui n = navigator.wrap(c);
        Pylon wrapped = impl.impl(WrappedPylon.class, pylon, n);
        panel.add(n.ui());
        pylons.add(wrapped);
    }
}
