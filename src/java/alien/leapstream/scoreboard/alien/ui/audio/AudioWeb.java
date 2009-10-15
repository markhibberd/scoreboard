package leapstream.scoreboard.alien.ui.audio;

import au.net.netstorm.boost.gunge.async.AsynchronousLayer;
import au.net.netstorm.boost.spider.api.config.aspect.Aspector;
import au.net.netstorm.boost.spider.api.config.mapping.Mapper;
import au.net.netstorm.boost.spider.api.config.web.Web;
import au.net.netstorm.boost.spider.api.config.wire.Wire;

public class AudioWeb implements Web {
    // FIX 1531 Feb 17, 2009 Why isn't this "leapstream.scoreboard.alien.ui.audio".
    String scope = "leapstream.scoreboard";
    Aspector aspector;
    Mapper mapper;
    Wire wire;

    public void web() {
        mapper.prefix("Default", "leapstream.scoreboard.alien.ui.audio");
        aspector.cut(DefaultWavPlayer.class, AsynchronousLayer.class);
        aspector.cut(DefaultTalker.class, AsynchronousLayer.class);
        wire.cls(SafeStreama.class).to(Streama.class);
        wire.cls(DefaultStreama.class).to(Streama.class, SafeStreama.class);
    }
}
