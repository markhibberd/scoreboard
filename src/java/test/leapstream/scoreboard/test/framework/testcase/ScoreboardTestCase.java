package leapstream.scoreboard.test.framework.testcase;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.web.SniperWeb;
import au.net.netstorm.boost.spider.ioc.BoostWeb;
import leapstream.scoreboard.legacy.ioc.ScoreboardWeb;
import leapstream.scoreboard.test.framework.ioc.ScoreboardTestWeb;

public class ScoreboardTestCase extends LifecycleTestCase {
    public final Class[] webs() {
        return new Class[] {
                BoostWeb.class,
                SniperWeb.class,
                ScoreboardWeb.class,
                ScoreboardTestWeb.class
        };
    }
}
