package leapstream.scoreboard.warts.providers.cruise.hooks;

import au.net.netstorm.boost.spider.api.config.mapping.Mapper;
import au.net.netstorm.boost.spider.api.config.web.Web;
import au.net.netstorm.boost.spider.api.config.wire.Wire;
import org.springframework.web.servlet.View;

public class CruiseWeb implements Web {
    String scope = "leapstream.scoreboard";
    Mapper mapper;
    Wire wire;

    public void web() {
        mapper.prefix("Default", scope);
        wire.cls(ScoreView.class).to(View.class);
    }
}
