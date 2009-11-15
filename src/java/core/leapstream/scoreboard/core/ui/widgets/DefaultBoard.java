package leapstream.scoreboard.core.ui.widgets;

import au.net.netstorm.boost.spider.api.lifecycle.Constructable;
import leapstream.scoreboard.alien.ui.core.Widget;
import leapstream.scoreboard.alien.ui.gunge.layout.BoardLayoutManager;
import leapstream.scoreboard.alien.ui.swing.pear.Panel;
import leapstream.scoreboard.core.pylon.PylonView;

import javax.swing.JComponent;

public final class DefaultBoard implements Board, Widget<Board>, Constructable {
    BoardLayoutManager layout;
    NavigableTiles navigator;
    Panel panel;

    public void constructor() {
        panel.setLayout(layout);
    }

    public Board control() {
        return this;
    }

    public JComponent ui() {
        return panel;
    }

    public void add(PylonView pylon, boolean mandatory) {
        Widget widget = pylon.view();
        JComponent c = widget.ui();
        // FIX 1531 Dec 4, 2008 SPIKE.
        JComponent n = navigator.wrap(c);
        panel.add(n);
        layout(n, mandatory);
    }

    private void layout(JComponent c, boolean mandatory) {
        if (mandatory) layout.mandatory(c);
        else layout.optional(c);
    }
}
