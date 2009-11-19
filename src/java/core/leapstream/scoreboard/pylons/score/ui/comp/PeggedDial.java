package leapstream.scoreboard.pylons.score.ui.comp;

import au.net.netstorm.boost.spider.api.lifecycle.Constructable;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import leapstream.scoreboard.alien.ui.core.Widget;
import leapstream.scoreboard.alien.ui.gunge.flash.WidgetFlasher;
import leapstream.scoreboard.alien.ui.swing.pear.Label;
import leapstream.scoreboard.alien.ui.swing.type.FontRatio;
import leapstream.scoreboard.alien.ui.swing.type.FontSpec;
import leapstream.scoreboard.core.gunge.Historian;
import leapstream.scoreboard.core.gunge.Statistician;
import leapstream.scoreboard.core.model.History;
import leapstream.scoreboard.core.model.Status;

import javax.swing.JComponent;
import java.awt.Color;

public final class PeggedDial implements Widget<Dial>, Dial, Constructable {
    private WidgetFlasher flasher;
    Statistician statistician;
    Historian historian;
    DialColors colors;
    FontRatio ratio;
    FontSpec spec;
    Label l;
    Nu nu;

    public void constructor() {
        flasher = nu.nu(WidgetFlasher.class, this, flashbg(), badbg());
        l.font(ratio);
        l.font(spec);
    }

    public Dial control() {
        return this;
    }

    public JComponent ui() {
        return l.ui();
    }

    public void dial(History history, Status status) {
        number(history);
        bg(history);
        fg(status);
    }

    private void number(History history) {
        int count = historian.count(history);
        l.text("" + count);
    }

    private void fg(Status status) {
        Color color = statistician.building(status) ? buildingfg() : quietfg();
        l.fg(color);
    }

    // FIX 244 Tidy.
    private void bg(History history) {
        boolean good = historian.good(history);
        if (good) good();
        else bad(history);
    }

    private void good() {
        flasher.stop();
        bg(goodbg());
    }

    private void bad(History history) {
        bg(badbg());
        flash(history);
    }

    private void bg(Color bg) {
        // FIX 1915 Dec 23, 2008 Why does this need to be here?
        if (l.bg() != bg) l.bg(bg);
    }

    private void flash(History history) {
        int count = historian.count(history);
        if (count < 3) return;
        flasher.start();
    }

    private Color buildingfg() {
        return colors.buildingfg();
    }

    private Color flashbg() {
        return colors.flashbg();
    }

    private Color quietfg() {
        return colors.quietfg();
    }

    private Color goodbg() {
        return colors.goodbg();
    }

    private Color badbg() {
        return colors.badbg();
    }
}
