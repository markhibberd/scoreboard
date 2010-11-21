package leapstream.scoreboard.alien.clobber.core;

import au.net.netstorm.boost.spider.api.config.mapping.Mapper;
import au.net.netstorm.boost.spider.api.config.web.Web;
import au.net.netstorm.boost.spider.api.config.wire.Wire;
import au.net.netstorm.boost.spider.api.runtime.Nu;

// FIX 1202 Jan 14, 2009 Delete once boost clobber is complete.
public final class ClobberWeb implements Web {
    String scope = "leapstream.scoreboard";
    Mapper mapper;

    public void web() {
        // FIX 1596 Dec 30, 2008 Revisit. Pattern for declaring this.
        mapper.prefix("Default", "leapstream.scoreboard.alien.clobber");
        // FIX 1596 Dec 30, 2008 Should not be here. Move out and kill this.
        mapper.prefix("Default", "leapstream.scoreboard.alien");
    }
}
