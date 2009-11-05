package leapstream.scoreboard.alien.aqueduct;

import au.net.netstorm.boost.spider.api.builder.Sticker;
import au.net.netstorm.boost.spider.api.builder.Egg;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import au.net.netstorm.boost.spider.api.runtime.Spider;
import leapstream.scoreboard.alien.ui.gunge.thread.ThreadUtil;

public class DefaultAqueductWirer implements AqueductWirer {
    ThreadUtil threader;
    Sticker sticker;
    Nu nu;

    public ConduitIn nu(int size, long timeout) {
        Egg egg = nu.nu(Egg.class, AqueductWeb.class);
        Spider spider = egg.hatch();
        sticker.data(spider, Pool.class, size);
        sticker.data(spider, Timeout.class, timeout);
        Conduit conduit = spider.resolve(Conduit.class);
        Resivoir resivoir = spider.resolve(Resivoir.class);
        threader.daemon(resivoir);
        return conduit;
    }
}
