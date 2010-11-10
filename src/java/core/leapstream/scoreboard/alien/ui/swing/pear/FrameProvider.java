package leapstream.scoreboard.alien.ui.swing.pear;

import au.net.netstorm.boost.spider.plugs.provider.core.CleanProvider;

// FIX 244 Tidy this up. Think about making it a SwingProvider, or even a SwingFactory/Provider pair.
public final class FrameProvider extends CleanProvider<Frame> {
    public Frame nu(Object... args) {
        return new Frame();
    }
}
