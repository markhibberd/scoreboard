package leapstream.scoreboard.alien.aqueduct;

import au.net.netstorm.boost.spider.api.config.web.Web;
import au.net.netstorm.boost.spider.api.config.mapping.Mapper;

public class AqueductWeb implements Web {
    String scope = "leapstream.scoreboard.alien.aqueduct";
    Mapper mapper;

    public void web() {
        mapper.prefix("Default", scope);
    }
}
