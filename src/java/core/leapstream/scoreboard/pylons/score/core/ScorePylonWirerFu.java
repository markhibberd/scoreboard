package leapstream.scoreboard.pylons.score.core;

import leapstream.scoreboard.core.model.Build;
import leapstream.scoreboard.core.pylon.PylonView;
import leapstream.scoreboard.pylons.score.ui.core.ScoreTile;

public interface ScorePylonWirerFu {
    PylonView<ScoreTile> nu(Build build);
}
