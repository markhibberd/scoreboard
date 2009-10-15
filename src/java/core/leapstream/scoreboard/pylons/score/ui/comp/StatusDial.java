package leapstream.scoreboard.pylons.score.ui.comp;

import au.net.netstorm.boost.bullet.incredibles.core.Weaken;
import au.net.netstorm.boost.spider.api.lifecycle.Constructable;
import leapstream.scoreboard.alien.ui.core.Widget;
import leapstream.scoreboard.alien.ui.swing.pear.Label;
import leapstream.scoreboard.alien.ui.swing.type.FontRatio;
import leapstream.scoreboard.core.gunge.Historian;
import leapstream.scoreboard.core.gunge.Statistician;
import leapstream.scoreboard.core.model.History;
import leapstream.scoreboard.core.model.Name;
import leapstream.scoreboard.core.model.Stati;
import leapstream.scoreboard.core.model.Status;

import javax.swing.JComponent;
import java.awt.Color;
import static java.awt.Color.BLACK;
import static java.awt.Color.GRAY;

public final class StatusDial implements Widget<Dial>, Dial, Constructable {
    Statistician statistician;
    FontRatio ratio;
    Historian historian;
    DialColors colors;
    Weaken weaken;
    Label l;

    public void constructor() {
        l.font(ratio);
        set("[ --- ]");
    }

    public JComponent ui() {
        return l.ui();
    }

    public Dial control() {
        return this;
    }

    public void name(Name name) {
        text(name);
    }

    public void dial(History history, Status status) {
        if (disabled(status)) set(GRAY, BLACK);
        else normal(history, status);
    }

    private void normal(History history, Status status) {
        fg(status);
        bg(history);
    }

    public void bomb(Throwable t) {
        // FIX 1915 Dec 24, 2008 Different message (ie "[DUDDED])"
        set(BLACK, GRAY);
    }

    private void text(Name n) {
        String s = weaken.w(n);
        set(s);
    }

    private void fg(Status status) {
        Color c = statistician.building(status) ? colors.buildingfg() : colors.quietfg();
        l.fg(c);
    }

    private void bg(History h) {
        boolean good = historian.good(h);
        Color c = good ? colors.goodbg() : colors.badbg();
        l.bg(c);
    }

    private boolean disabled(Status s) {
        Stati stati = s.is();
        return stati == Stati.DISABLED;
    }

    private void set(String text) {
        l.text(text);
    }

    private void set(Color fg, Color bg) {
        l.fg(fg);
        l.bg(bg);
    }
}
