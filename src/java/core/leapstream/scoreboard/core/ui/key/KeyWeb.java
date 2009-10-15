package leapstream.scoreboard.core.ui.key;

import au.net.netstorm.boost.spider.api.config.web.Web;
import au.net.netstorm.boost.spider.api.config.wire.Wire;

import java.awt.event.KeyListener;

public final class KeyWeb implements Web {
    Wire wire;

    public void web() {
        listeners();
        keys();
    }

    private void listeners() {
        wire.cls(PumpingKeyListener.class).to(KeyListener.class);
    }

    private void keys() {
        // FIX 1205 I think the nameing pattern is wrong here.
        // FIX 1205 Impls should be named after what they do.
        // FIX 1205 Leave name as key.
        // FIX 1205 This way it actually reads as binding "h" to HelpHandler. Much nicer :)
        bind("space", SpaceHandler.class);
        bind("fullscreener", FullScreenHandler.class);
        bind("esc", EscHandler.class);
        bind("up", UpHandler.class);
        bind("down", DownHandler.class);
        bind("left", LeftHandler.class);
        bind("right", RightHandler.class);
        // FIX 1205 Switch key for this. 'h' == help. '??' = this.
        bind("h", HHandler.class);
        bind("c", CHandler.class);
    }

    private void bind(String name, Class<? extends Handler> c) {
        wire.cls(c).to(Handler.class, name);
    }
}
