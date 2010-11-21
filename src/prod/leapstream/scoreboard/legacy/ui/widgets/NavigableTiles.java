package leapstream.scoreboard.legacy.ui.widgets;

import javax.swing.JComponent;

// FIX 1531 Dec 4, 2008 Move
public interface NavigableTiles {
    NavigableTile wrap(JComponent c);

    // FIX 1531 Dec 5, 2008 Merge these into separate interface.
    void select(int x);

    void reset();

    int num();
}
