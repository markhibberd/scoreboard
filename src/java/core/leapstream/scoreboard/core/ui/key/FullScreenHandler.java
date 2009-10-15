package leapstream.scoreboard.core.ui.key;

import static java.awt.Frame.MAXIMIZED_BOTH;
import static java.awt.Frame.NORMAL;

import leapstream.scoreboard.alien.ui.swing.pear.Frame;

public final class FullScreenHandler implements Handler {
    Frame frame;

    public void u() {
        int target = frame.getExtendedState() == MAXIMIZED_BOTH ? NORMAL : MAXIMIZED_BOTH;
        frame.setExtendedState(target);
    }
}
