package leapstream.scoreboard.legacy.ui.key;

import leapstream.scoreboard.legacy.ui.swing.pear.Frame;

// FIX 1205 Switch key for this. 'h' == help. '??' = this.
public final class HHandler implements Handler {
    Frame frame;

    public void u() {
        frame.top();
    }
}
