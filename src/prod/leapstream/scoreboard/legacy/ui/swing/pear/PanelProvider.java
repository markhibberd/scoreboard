package leapstream.scoreboard.legacy.ui.swing.pear;

import au.net.netstorm.boost.spider.plugs.provider.core.CleanProvider;
// FIX 244 Genericise this concept of a default constructor without injection.

// FIX 244 Add swing factory.
public final class PanelProvider extends CleanProvider<Panel> {
    public Panel nu(Object... args) {
        return new Panel();
    }
}
