package leapstream.scoreboard.core.ui.frob;

import leapstream.scoreboard.alien.ui.swing.pear.Frame;

import static java.awt.Frame.MAXIMIZED_BOTH;

public class DefaultWindowFrobber implements WindowFrobber {
    Frame frame;

    public void title(String title) {
        frame.setTitle(title);
    }

    public void fullscreen() {
        frame.setExtendedState(MAXIMIZED_BOTH);
    }
}
