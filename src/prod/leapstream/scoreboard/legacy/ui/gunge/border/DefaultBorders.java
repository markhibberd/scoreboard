package leapstream.scoreboard.legacy.ui.gunge.border;

import javax.swing.BorderFactory;
import javax.swing.border.Border;
import java.awt.Color;
import static java.awt.Color.BLACK;
import static java.awt.Color.WHITE;

public final class DefaultBorders implements Borders {
    public Border border(int o, int i) {
        Border outer = line(WHITE, o);
        Border inner = line(BLACK, i);
        return BorderFactory.createCompoundBorder(outer, inner);
    }

    private Border line(Color color, int thickness) {
        return BorderFactory.createLineBorder(color, thickness);
    }
}
