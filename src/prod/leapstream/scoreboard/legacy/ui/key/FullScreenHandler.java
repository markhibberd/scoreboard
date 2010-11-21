package leapstream.scoreboard.legacy.ui.key;

import leapstream.scoreboard.legacy.ui.swing.pear.Frame;

import static java.awt.Frame.MAXIMIZED_BOTH;
import static java.awt.Frame.NORMAL;

public final class FullScreenHandler implements Handler {
    Frame frame;

    public void u() {
        int target = frame.getExtendedState() == MAXIMIZED_BOTH ? NORMAL : MAXIMIZED_BOTH;
        frame.setExtendedState(target);
    }
}
