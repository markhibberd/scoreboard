package leapstream.scoreboard.alien.ui.gunge.flash;

import au.net.netstorm.boost.bullet.repeater.Stopper;
import leapstream.scoreboard.alien.ui.core.Widget;

import java.awt.Color;

public interface FlashBang {
    Stopper pull(Widget widget, Color... sparkles);
}
