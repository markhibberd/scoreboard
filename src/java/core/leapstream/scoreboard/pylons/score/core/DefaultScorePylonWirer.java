package leapstream.scoreboard.pylons.score.core;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import leapstream.scoreboard.alien.ui.core.Ui;
import leapstream.scoreboard.core.gunge.Builder;
import leapstream.scoreboard.core.model.Build;

// FIX 1205 Add magic layer to remove need this - go direct to fu.
public final class DefaultScorePylonWirer implements ScorePylonWirer {
    ScorePylonWirerFu scores;
    Builder builder;
    Nu nu;

    public Ui nu(String name, String url) {
        Build build = builder.get(name, url);
        return scores.nu(build);
    }
}
