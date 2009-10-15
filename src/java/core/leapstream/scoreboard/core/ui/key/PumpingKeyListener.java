package leapstream.scoreboard.core.ui.key;

import au.net.netstorm.boost.gunge.collection.StrictMap;
import au.net.netstorm.boost.spider.api.lifecycle.Constructable;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public final class PumpingKeyListener implements KeyListener, Constructable {
    StrictMap<Integer, Handler> codes;
    // FIX 1205 smells - should be 'f'
    Handler fullscreener;
    Handler esc;
    Handler up;
    Handler down;
    Handler left;
    Handler right;
    Handler space;
    Handler h;
    Handler c;

    public void constructor() {
        // FIX 1205 Why not bind(' ', space) but still have only one backing map?
        codes(32, space);
        codes(70, fullscreener);
        codes(27, esc);
        codes(38, up);
        codes(39, right);
        codes(40, down);
        codes(37, left);
        codes(72, h);
        codes(67, c);
    }

    public void keyTyped(KeyEvent e) {
        System.err.println("typed = " + e.getKeyCode());
    }

    public void keyPressed(KeyEvent e) {
        System.err.println("pressed = " + e.getKeyCode());
        process(e);
    }

    public void keyReleased(KeyEvent e) {
        System.err.println("released = " + e.getKeyCode());
    }

    private void codes(int i, Handler h) {
        codes.put(i, h);
    }

    private void process(KeyEvent e) {
        Integer code = e.getKeyCode();
        if (codes.exists(code)) go(code);
            // FIX 1530 Dec 15, 2008 Something a little nicer...
        else System.err.println("unbound key press: " + code);
    }

    private void go(Integer code) {
        Handler h = codes.get(code);
        h.u();
    }
}
