package leapstream.scoreboard.alien.ui.gunge.flash;

import au.net.netstorm.boost.bullet.repeater.Repeater;
import au.net.netstorm.boost.bullet.repeater.Stopper;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import leapstream.scoreboard.alien.ui.core.Widget;

import javax.swing.JComponent;
import java.awt.Color;

public final class DefaultFlashBang implements FlashBang {
    private static final Long PERIOD = 500L;
    Repeater repeater;
    Nu nu;

    public Stopper pull(Widget widget, Color... sparkles) {
        JComponent ui = widget.ui();
        Flasher flasher = nu.nu(Flasher.class, ui, sparkles);
        return repeater.repeat(flasher, PERIOD);
    }
}
