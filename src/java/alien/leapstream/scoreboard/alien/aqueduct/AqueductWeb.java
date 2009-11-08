package leapstream.scoreboard.alien.aqueduct;

import au.net.netstorm.boost.spider.api.config.mapping.Mapper;
import au.net.netstorm.boost.spider.api.config.web.Web;
import au.net.netstorm.boost.spider.api.config.wire.Wire;

public class AqueductWeb implements Web {
    String scope = "leapstream.scoreboard.alien.aqueduct";
    Wire wire;
    Mapper mapper;

    public void web() {
        mapper.prefix("Default", scope);
        wire.cls(DefaultConduit.class).one().to(Conduit.class).to(ConduitIn.class).to(ConduitOut.class);
    }
}
