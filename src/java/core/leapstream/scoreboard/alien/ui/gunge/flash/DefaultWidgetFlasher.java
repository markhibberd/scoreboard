package leapstream.scoreboard.alien.ui.gunge.flash;

import au.net.netstorm.boost.bullet.repeater.Stopper;
import au.net.netstorm.boost.gunge.optional.NotSetOptional;
import au.net.netstorm.boost.gunge.optional.Optional;
import au.net.netstorm.boost.gunge.optional.SetOptional;
import leapstream.scoreboard.alien.ui.core.Widget;

import java.awt.Color;

public final class DefaultWidgetFlasher implements WidgetFlasher {
    private Optional<Stopper> stopper = new NotSetOptional<Stopper>();
    private final Widget widget;
    private final Color flashbg;
    private final Color badbg;
    FlashBang flasher;

    public DefaultWidgetFlasher(Widget widget, Color flashbg, Color badbg) {
        this.widget = widget;
        this.flashbg = flashbg;
        this.badbg = badbg;
    }

    public synchronized void start() {
        if (stopper.isSet()) return;
        Stopper stopper = flasher.pull(widget, badbg, flashbg);
        this.stopper = new SetOptional<Stopper>(stopper);
    }

    public synchronized void stop() {
        if (!stopper.isSet()) return;
        Stopper s = stopper.get();
        s.stop();
        stopper = new NotSetOptional<Stopper>();
    }
}

