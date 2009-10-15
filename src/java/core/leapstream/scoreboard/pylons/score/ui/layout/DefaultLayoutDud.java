package leapstream.scoreboard.pylons.score.ui.layout;

import java.awt.Dimension;
import java.awt.Rectangle;

public final class DefaultLayoutDud implements LayoutDud {
    Spacings x = spacings(1.0, .1, .2, .7);
    Spacings y = spacings(1.2, .2, .2, .5, .15, .15);

    public Rectangle[] layout(Dimension canvas) {
        int[] px = morph(x, canvas.width);
        int[] py = morph(y, canvas.height);
        return rectangles(px, py);
    }

    private Rectangle[] rectangles(int[] px, int[] py) {
        Rectangle[] result = new Rectangle[5];
        result[0] = rectangle(px, py, 0, 0, 3, 1);
        result[1] = rectangle(px, py, 0, 1, 1, 3);
        result[2] = rectangle(px, py, 1, 1, 3, 3);
        result[3] = rectangle(px, py, 0, 3, 3, 4);
        result[4] = rectangle(px, py, 0, 4, 3, 5);
        return result;
    }

    private Rectangle rectangle(int[] px, int[] py, int ix1, int iy1, int ix2, int iy2) {
        int x1 = px[ix1];
        int x2 = px[ix2];
        int y1 = py[iy1];
        int y2 = py[iy2];
        return new Rectangle(x1, y1, x2 - x1, y2 - y1);
    }

    private int[] morph(Spacings spacings, int len) {
        Double[] s = spacings.abs();
        int[] result = new int[s.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = (int) (s[i] * len);
        }
        return result;
    }

    private Spacings spacings(Double total, Double... spacings) {
        return new DefaultSpacings(total, spacings);
    }
}
