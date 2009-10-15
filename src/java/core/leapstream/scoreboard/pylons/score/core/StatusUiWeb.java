package leapstream.scoreboard.pylons.score.core;

import au.net.netstorm.boost.spider.api.config.web.Web;
import au.net.netstorm.boost.spider.api.config.wire.Wire;
import leapstream.scoreboard.alien.ui.swing.type.FontRatio;
import leapstream.scoreboard.pylons.score.push.ScorePusher;
import leapstream.scoreboard.pylons.score.ui.comp.Dial;
import leapstream.scoreboard.pylons.score.ui.comp.StatusDial;
import leapstream.scoreboard.pylons.status.push.StatusUiScorePusher;

public final class StatusUiWeb implements Web {
    Wire wire;

    public void web() {
        wire.cls(StatusUiScorePusher.class).to(ScorePusher.class, "ui");
        wire.cls(StatusDial.class).to(Dial.class);
        wire.nu(FontRatio.class, .1).to(FontRatio.class);
    }
}
