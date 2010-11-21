package leapstream.scoreboard.legacy.ui.gunge.layout;

import java.awt.Component;
import java.awt.Dimension;

public final class DefaultScraps implements Scraps {
    // FIX 707 Trying this out. Clean this up.
    public Component[] tiles(Component[] mandatory, Component[] optional, Dimension layout) {
        int extra = extra(mandatory, optional, layout);
        return optionals(mandatory, optional, extra);
    }

    private int extra(Component[] mandatory, Component[] optional, Dimension layout) {
        int expected = layout.width * layout.height;
        int actual = mandatory.length;
        int extra = expected - actual;
        if (extra > optional.length) extra = optional.length;
        return extra;
    }

    private Component[] optionals(Component[] mandatory, Component[] optional, int extra) {
        Component[] result = new Component[mandatory.length + extra];
        System.arraycopy(mandatory, 0, result, 0, mandatory.length);
        System.arraycopy(optional, 0, result, mandatory.length, extra);
        visibility(optional, extra);
        return result;
    }

    private void visibility(Component[] optional, int extra) {
        for (int i = 0; i < optional.length; ++i) {
            if (i < extra) optional[i].setVisible(true);
            else optional[i].setVisible(false);
        }
    }
}
