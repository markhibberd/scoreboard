package leapstream.scoreboard.legacy.ioc;

import au.net.netstorm.boost.bullet.log.LogEngine;
import au.net.netstorm.boost.bullet.log.StandardOutLogEngine;
import au.net.netstorm.boost.spider.api.builder.Spinneret;
import au.net.netstorm.boost.spider.api.config.mapping.Mapper;
import au.net.netstorm.boost.spider.api.config.scope.Scoper;
import au.net.netstorm.boost.spider.api.config.web.Web;
import au.net.netstorm.boost.spider.api.config.wire.Wire;
import leapstream.scoreboard.warts.providers.clobber.core.ClobberWeb;

// OK NCSS {
public final class ScoreboardWeb implements Web {
    Spinneret spinneret;
    Scoper scoper;
    Mapper mapper;
    Wire wire;

    public void web() {
        // FIX 1596 Dec 30, 2008 Revisit. Where how is the best way to declare.
        scoper.scope("leapstream.scoreboard");
        mapper.prefix("Default");
        subwebs();
        logging();
    }

    private void subwebs() {
        spinneret.spin(ClobberWeb.class);
    }

    private void logging() {
        wire.cls(StandardOutLogEngine.class).to(LogEngine.class);
    }

}
// } OK NCSS
