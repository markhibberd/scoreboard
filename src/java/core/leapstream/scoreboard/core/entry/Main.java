package leapstream.scoreboard.core.entry;

import au.net.netstorm.boost.spider.api.entry.SpiderMain;
import au.net.netstorm.boost.spider.ioc.BoostWeb;
import leapstream.scoreboard.core.ioc.ScoreboardWeb;

// FIX 3324 Mar 19, 2009 Rename to ScoreboardMain.
public final class Main {
    public static void main(String[] args) {
        au.net.netstorm.boost.spider.api.entry.Main main = new SpiderMain(BoostWeb.class, ScoreboardWeb.class);
        main.main(ScoreboardGo.class, args);
    }
}
