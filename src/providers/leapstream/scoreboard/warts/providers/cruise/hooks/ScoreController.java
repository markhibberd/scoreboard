package leapstream.scoreboard.warts.providers.cruise.hooks;

import au.net.netstorm.boost.spider.api.builder.Egg;
import au.net.netstorm.boost.spider.api.builder.SpiderEgg;
import au.net.netstorm.boost.spider.api.config.wire.Wire;
import au.net.netstorm.boost.spider.api.runtime.Spider;
import au.net.netstorm.boost.spider.ioc.BoostWeb;
import net.sourceforge.cruisecontrol.dashboard.service.HistoricalBuildSummariesService;
import net.sourceforge.cruisecontrol.dashboard.service.LatestBuildSummariesService;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ScoreController implements Controller {
    Egg egg = new SpiderEgg(BoostWeb.class, CruiseWeb.class);
    Spider spider = egg.hatch();
    Wire wire = spider.resolve(Wire.class);

    public ScoreController(HistoricalBuildSummariesService fu, LatestBuildSummariesService gu) {
        wire.ref(fu).to(HistoricalBuildSummariesService.class);
        wire.ref(gu).to(LatestBuildSummariesService.class);
    }

    public final ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        View view = spider.resolve(View.class);
        return new ModelAndView(view);
    }
}
