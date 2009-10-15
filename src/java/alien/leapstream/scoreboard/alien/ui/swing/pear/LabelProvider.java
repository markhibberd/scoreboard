package leapstream.scoreboard.alien.ui.swing.pear;

import au.net.netstorm.boost.bullet.incredibles.core.Weaken;
import au.net.netstorm.boost.spider.plugs.provider.core.CleanProvider;

public final class LabelProvider extends CleanProvider<Label> {
    Weaken weaken;

    public Label nu(Object... args) {
        return new _Label(weaken);
    }
}
