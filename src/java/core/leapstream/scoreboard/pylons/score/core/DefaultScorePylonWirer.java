package leapstream.scoreboard.pylons.score.core;

import leapstream.scoreboard.alien.ui.core.Ui;
import leapstream.scoreboard.core.gunge.Builder;
import leapstream.scoreboard.core.model.Build;
import leapstream.scoreboard.core.poll.Times;

// FIX 1205 Add magic layer to remove need this - go direct to fu.
public final class DefaultScorePylonWirer implements ScorePylonWirer {
    ScorePylonWirerFu scores;
    Builder builder;

    public Ui nu(String name, String url, int poll) {
        Build build = builder.get(name, url);
        return scores.nu(build, poll);
    }

    public Ui nu(String name, String url) {
        return nu(name, url, Times.SCORE_POLL);        
    }
}
