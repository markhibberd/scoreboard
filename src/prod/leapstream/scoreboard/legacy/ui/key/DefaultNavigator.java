package leapstream.scoreboard.legacy.ui.key;

import leapstream.scoreboard.legacy.ui.widgets.NavigableTiles;

public final class DefaultNavigator implements Navigator {
    private boolean activated;
    private int index;
    NavigableTiles tiles;

    public void left() {
        move(-1);
    }

    public void right() {
        move(1);
    }

    public void esc() {
        tiles.reset();
    }

    private void move(int i) {
        index = next(i);
        tiles.select(index);
        activated = true;
    }

    private int next(int i) {
        int n = tiles.num();
        int move = activated ? i : 0;
        return (index + move + n) % n;
    }
}
