package leapstream.scoreboard.pylons.score.core;

import leapstream.scoreboard.core.pylon.Pylon;
import leapstream.scoreboard.pylons.score.ui.core.ScoreTile;

// FIX 1205 Add magic layer to remove need this - go direct to fu.
public interface ScorePylonWirer {
     Pylon<ScoreTile> nu(String name, String url);
}
