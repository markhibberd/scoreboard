package leapstream.scoreboard.pylons.score.core;

import leapstream.scoreboard.core.model.Build;
import leapstream.scoreboard.core.pylon.Pylon;
import leapstream.scoreboard.pylons.score.ui.core.ScoreTile;

public interface ScorePylonWirerFu {
    Pylon<ScoreTile> nu(Build build);
}
