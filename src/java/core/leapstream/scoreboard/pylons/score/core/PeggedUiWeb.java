package leapstream.scoreboard.pylons.score.core;

import au.net.netstorm.boost.spider.api.config.web.Web;
import au.net.netstorm.boost.spider.api.config.wire.Wire;
import leapstream.scoreboard.alien.ui.swing.type.FontRatio;
import leapstream.scoreboard.alien.ui.swing.type.FontSpec;
import leapstream.scoreboard.pylons.score.push.PeggedUiScorePusher;
import leapstream.scoreboard.pylons.score.push.ScorePusher;
import leapstream.scoreboard.pylons.score.ui.comp.Dial;
import leapstream.scoreboard.pylons.score.ui.comp.PeggedDial;

import static java.awt.Font.PLAIN;

public final class PeggedUiWeb implements Web {
    Wire wire;

    public void web() {
        wire.cls(PeggedUiScorePusher.class).to(ScorePusher.class, "ui");
        wire.cls(PeggedDial.class).to(Dial.class);
        wire.nu(FontRatio.class, 0.67).to(FontRatio.class);
        wire.nu(FontSpec.class, "Robotron", PLAIN).to(FontSpec.class);
    }
}
