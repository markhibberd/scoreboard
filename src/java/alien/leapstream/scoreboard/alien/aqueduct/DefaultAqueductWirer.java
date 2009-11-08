package leapstream.scoreboard.alien.aqueduct;

import au.net.netstorm.boost.spider.api.builder.Egg;
import au.net.netstorm.boost.spider.api.builder.Sticker;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import au.net.netstorm.boost.spider.api.runtime.Spider;
import au.net.netstorm.boost.spider.ioc.BoostWeb;
import leapstream.scoreboard.alien.ui.gunge.thread.ThreadUtil;

public class DefaultAqueductWirer implements AqueductWirer {
    ThreadUtil threader;
    Sticker sticker;
    Nu nu;

    public Aqueduct nu(int pool) {
        Egg egg = nu.nu(Egg.class, BoostWeb.class, AqueductWeb.class);
        Spider spider = egg.hatch();
        sticker.data(spider, Pool.class, pool);
        Resivoir resivoir = spider.resolve(Resivoir.class);
        threader.daemon(resivoir);
        return spider.resolve(Aqueduct.class);
    }
}
