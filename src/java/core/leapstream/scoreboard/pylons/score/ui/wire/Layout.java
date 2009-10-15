package leapstream.scoreboard.pylons.score.ui.wire;

import java.awt.Container;

import leapstream.scoreboard.pylons.score.ui.core.ScoreTile;

public interface Layout {
    void layout(Container container, ScoreTile tile);
}
