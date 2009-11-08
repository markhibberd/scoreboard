package leapstream.scoreboard.pylons.score.ui.wire;

import leapstream.scoreboard.pylons.score.ui.core.ScoreTile;

import java.awt.Container;

public interface Layout {
    void layout(Container container, ScoreTile tile);
}
