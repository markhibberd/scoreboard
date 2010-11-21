package leapstream.scoreboard.legacy.clobber.core;

import au.net.netstorm.boost.spider.api.config.mapping.Mapper;
import au.net.netstorm.boost.spider.api.config.web.Web;

public final class ClobberWeb implements Web {
    String scope = "leapstream.scoreboard";
    Mapper mapper;

    public void web() {
        mapper.prefix("Default", scope);
    }
}
