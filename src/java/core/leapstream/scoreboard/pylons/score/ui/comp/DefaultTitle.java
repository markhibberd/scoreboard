package leapstream.scoreboard.pylons.score.ui.comp;

import au.net.netstorm.boost.bullet.incredibles.core.Weaken;
import au.net.netstorm.boost.spider.api.lifecycle.Constructable;
import leapstream.scoreboard.alien.ui.core.Widget;
import leapstream.scoreboard.alien.ui.swing.pear.Label;
import leapstream.scoreboard.core.model.Name;
import leapstream.scoreboard.pylons.score.ui.lf.Colors;

import javax.swing.JComponent;
import java.awt.Color;

// FIX 244 Package for each "thing"?
public class DefaultTitle implements Widget<Title>, Title, Constructable {
    Label label;
    Colors colors;
    Weaken weaken;

    public void constructor() {
        Color fg = colors.get("title.active.fg");
        Color bg = colors.get("title.active.bg");
        colors(fg, bg);
    }

    public Title control() {
        return this;
    }

    public JComponent ui() {
        return label.ui();
    }

    public void title(Name name) {
        String s = weaken.w(name);
        label.text(s);
    }

    private void colors(Color fg, Color bg) {
        label.fg(fg);
        label.bg(bg);
    }
}
