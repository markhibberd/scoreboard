package leapstream.scoreboard.legacy.ui.swing.pear;

import javax.swing.*;

// FIX 1531 Tidy up and sort out the jna shite.
public final class Frame extends JFrame {
    float alpha = .9f;
    boolean top;

    {
        // FIX 1531 Dec 5, 2008 Tidy this bollocks.
        // FIX 1531 Dec 5, 2008 Move sideways.
        alpha();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    // FIX 1531 Sort out this obvious dodgy hackery.
    public void up() {
        alpha += .01f;
        if (alpha > 1) alpha = 1;
        alpha();
    }

    public void down() {
        alpha -= .01f;
        if (alpha < .2) alpha = 0.2f;
        alpha();
    }

    private void alpha() {
//        FIX This breaks in same cases.... dropping it until it works.
//        if (WindowUtils.isWindowAlphaSupported()) {
//            Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
//            Rectangle2D.Float rect = new Rectangle2D.Float(0, 0, screen.width, screen.height);
//            Shape mask = new Area(rect);
//            WindowUtils.setWindowMask(this, mask);
//            WindowUtils.setWindowAlpha(this, alpha);
//        }
    }

    public void top() {
        top = !top;
        fudge(top);
    }

    private void fudge(boolean v) {
        setAlwaysOnTop(v);
        // Need to drop the peer.
//        setUndecorated(v);
    }
}
