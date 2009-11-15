package leapstream.scoreboard.alien.ui.audio.core;

import au.net.netstorm.boost.spider.api.config.mapping.Mapper;
import au.net.netstorm.boost.spider.api.config.web.Web;
import au.net.netstorm.boost.spider.api.config.wire.Wire;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import leapstream.scoreboard.alien.ui.audio.wav.DefaultStreama;
import leapstream.scoreboard.alien.ui.audio.wav.SafeStreama;
import leapstream.scoreboard.alien.ui.audio.wav.Streama;

public class AudioWeb implements Web {
    String scope = "leapstream.scoreboard.alien";
    Mapper mapper;
    Wire wire;
    Nu nu;

    public void web() {
        mapper.prefix("Default", scope);
        wire.cls(SafeStreama.class).to(Streama.class);
        wire.cls(DefaultStreama.class).to(Streama.class, SafeStreama.class);
    }
}
