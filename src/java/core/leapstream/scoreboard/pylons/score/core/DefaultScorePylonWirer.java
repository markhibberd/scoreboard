package leapstream.scoreboard.pylons.score.core;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import leapstream.scoreboard.core.gunge.Builder;
import leapstream.scoreboard.core.model.Build;
import leapstream.scoreboard.core.pylon.PylonView;
import leapstream.scoreboard.pylons.score.ui.core.ScoreTile;

// FIX 1205 Add magic layer to remove need this - go direct to fu.
public final class DefaultScorePylonWirer implements ScorePylonWirer {
    ScorePylonWirerFu scores;
    Builder builder;
    Nu nu;

    public PylonView<ScoreTile> nu(String name, String url) {
        Build build = builder.get(name, url);
        return scores.nu(build);
    }
}
