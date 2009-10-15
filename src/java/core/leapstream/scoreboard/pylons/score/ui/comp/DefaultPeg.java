package leapstream.scoreboard.pylons.score.ui.comp;

import au.net.netstorm.boost.spider.api.lifecycle.Constructable;
import leapstream.scoreboard.alien.ui.core.Widget;
import leapstream.scoreboard.alien.ui.gunge.border.Borders;
import leapstream.scoreboard.alien.ui.swing.pear.Panel;
import leapstream.scoreboard.pylons.score.ui.lf.Colors;

import javax.swing.JComponent;
import javax.swing.border.Border;
import java.awt.Color;

public final class DefaultPeg implements Peg, Widget<Peg>, Constructable {
    private Color good;
    private Color bad;
    private Color initial;
    Panel panel;
    Colors colors;
    Borders borders;

    public void constructor() {
        good = colors.get("peg.active.good");
        bad = colors.get("peg.active.bad");
        initial = colors.get("peg.active.initial");
        style();
    }

    public Peg control() {
        return this;
    }

    public JComponent ui() {
        return panel;
    }

    public void good(boolean b) {
        Color core = b ? good : bad;
        panel.setBackground(core);
    }

    private void style() {
        background();
        border();
    }

    private void background() {
        panel.setBackground(initial);
    }

    private void border() {
        Border border = borders.border(1, 1);
        panel.setBorder(border);
    }
}
