package leapstream.scoreboard.pylons.score.push;

import au.net.netstorm.boost.bullet.incredibles.core.Weaken;
import leapstream.scoreboard.core.model.Build;
import leapstream.scoreboard.core.model.Name;
import leapstream.scoreboard.core.model.Score;
import leapstream.scoreboard.edge.java.net.URL;
import leapstream.scoreboard.pylons.score.state.ScoreDelta;
import leapstream.scoreboard.pylons.score.state.ScorePylonState;
import leapstream.scoreboard.pylons.score.ui.audio.Gong;

public final class AudioScorePusher implements ScorePusher {
    ScorePylonState state;
    ScoreDelta delta;
    Weaken weaken;
    Build build;
    URL broken;
    // FIX CONFIG push to config facade.
    URL fixed;
    Gong gong;

    public void push(Score score) {
        if (state.first()) return;
        if (delta.fixed()) fixed();
        if (delta.broke()) broken();
    }

    private void broken() {
        audio(" is broken", broken);
    }

    private void fixed() {
        audio(" has been fixed", fixed);
    }

    private void audio(String suffix, URL wav) {
        Name name = build.name();
        String weak = weaken.w(name);
        gong.bang(wav, weak + suffix);
    }
}
