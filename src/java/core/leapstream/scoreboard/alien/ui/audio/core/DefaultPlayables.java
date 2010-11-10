package leapstream.scoreboard.alien.ui.audio.core;

import au.net.netstorm.boost.spider.api.runtime.Impl;
import leapstream.scoreboard.alien.ui.audio.voice.VoicePlayable;
import leapstream.scoreboard.alien.ui.audio.wav.WavPlayable;
import leapstream.scoreboard.edge.java.net.URL;

public class DefaultPlayables implements Playables {
    Impl impl;

    public Playable say(String msg) {
        return impl.impl(VoicePlayable.class, msg);
    }

    public Playable play(URL wav) {
        return impl.impl(WavPlayable.class, wav);
    }

    public Playable sequential(Playable... playables) {
        return impl.impl(SequentialPlayable.class, playables);
    }
}