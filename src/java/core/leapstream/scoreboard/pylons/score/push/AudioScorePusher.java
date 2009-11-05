package leapstream.scoreboard.pylons.score.push;

import leapstream.scoreboard.alien.ui.audio.Talker;
import leapstream.scoreboard.alien.ui.audio.WavPlayer;
import leapstream.scoreboard.core.model.Name;
import leapstream.scoreboard.core.model.Score;
import leapstream.scoreboard.edge.java.net.URL;
import leapstream.scoreboard.pylons.score.state.ScoreDelta;
import leapstream.scoreboard.pylons.score.state.ScorePylonState;
import au.net.netstorm.boost.bullet.incredibles.core.Weaken;

public final class AudioScorePusher implements ScorePusher {
    ScorePylonState state;
    ScoreDelta delta;
    WavPlayer player;
    Weaken weaken;
    Talker talker;
    // FIX CONFIG push to config facade.
    URL fixed;
    URL broken;

    public void fail(Throwable t) {}

    public void starting() {}

    public void push(Score score) {
        if (state.first()) return;
        if (delta.fixed()) fixed(score);
        if (delta.broke()) broken(score);
    }

    private void broken(Score score) {
        audio(score, " is broken", broken);
    }

    private void fixed(Score score) {
        audio(score, " has been fixed", fixed);
    }

    private void audio(Score score, String suffix, URL wav) {
        String name = name(score);
        player.play(wav);
        talker.say(name + suffix);
    }

    private String name(Score score) {
        Name name = score.name();
        return weaken.w(name);
    }
}
