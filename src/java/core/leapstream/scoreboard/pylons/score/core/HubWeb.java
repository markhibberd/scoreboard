package leapstream.scoreboard.pylons.score.core;

import au.net.netstorm.boost.spider.api.config.web.Web;
import au.net.netstorm.boost.spider.api.config.wire.Wire;
import au.net.netstorm.boost.spider.api.runtime.Resolver;
import leapstream.scoreboard.core.sounds.Sounds;
import leapstream.scoreboard.edge.java.net.URL;
import leapstream.scoreboard.pylons.score.push.AudioScorePusher;
import leapstream.scoreboard.pylons.score.push.HubScorePusher;
import leapstream.scoreboard.pylons.score.push.LogScorePusher;
import leapstream.scoreboard.pylons.score.push.ScorePusher;
import leapstream.scoreboard.pylons.score.state.ScorePylonState;

// FIX 1915 Dec 23, 2008 I believe this is the Push (or Hub) Web.
public final class HubWeb implements Web {
    Resolver resolver;
    Wire wire;

    // FIX 244 Split this out into some sub-webs.
    public void web() {
        bindings();
        sounds();
    }

    private void bindings() {
        wire.nu(ScorePylonState.class).to(ScorePylonState.class);
        wire.cls(HubScorePusher.class).to(ScorePusher.class);
        wire.cls(StateScorePusher.class).to(ScorePusher.class, "state");
        wire.cls(AudioScorePusher.class).to(ScorePusher.class, "audio");
        wire.cls(LogScorePusher.class).to(ScorePusher.class, "log");
    }

    private void sounds() {
        // FIX 936 This should be externalized / configurable.
        sound("happy.wav", "fixed");
        sound("crash.wav", "broken");
    }

    private void sound(String wav, String field) {
        // FIX 1596 Dec 29, 2008 Is there a reason this is not injected?
        Sounds sounds = resolver.resolve(Sounds.class);
        URL broken = sounds.get(wav);
        wire.ref(broken).to(URL.class, AudioScorePusher.class, field);
    }
}
