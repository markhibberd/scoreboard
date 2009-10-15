package leapstream.scoreboard.warts.providers.hudson.hooks;

import au.net.netstorm.boost.spider.api.builder.Egg;
import au.net.netstorm.boost.spider.api.builder.SpiderEgg;
import au.net.netstorm.boost.spider.api.config.wire.Wire;
import au.net.netstorm.boost.spider.api.runtime.Spider;
import au.net.netstorm.boost.spider.ioc.BoostWeb;
import hudson.Plugin;
import leapstream.scoreboard.core.ioc.ScoreboardWeb;

import javax.servlet.ServletContext;

public class ScoreboardPlugin extends Plugin {
    private Egg egg = new SpiderEgg(BoostWeb.class, ScoreboardWeb.class);
    private Spider spider = egg.hatch();
    private Wire wire = spider.resolve(Wire.class);

    public void setServletContext(ServletContext context) {
        super.setServletContext(context);
        wire.ref(context).to(ServletContext.class);
    }

    public void start() {
        Runnable runnable = spider.impl(Hooker.class);
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
