package leapstream.scoreboard.test.framework.ioc;

import au.net.netstorm.boost.sniper.lifecycle.BoostTestLifecycleBlocks;
import au.net.netstorm.boost.sniper.lifecycle.TestLifecycleBlocks;
import au.net.netstorm.boost.spider.api.config.web.Web;
import au.net.netstorm.boost.spider.api.config.wire.Wire;

public final class ScoreboardTestWeb implements Web {
    Wire wire;

    public void web() {
        wire.cls(BoostTestLifecycleBlocks.class).to(TestLifecycleBlocks.class);
    }
}
