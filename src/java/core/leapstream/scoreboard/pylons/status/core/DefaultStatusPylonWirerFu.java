package leapstream.scoreboard.pylons.status.core;

import au.net.netstorm.boost.spider.api.builder.Egg;
import au.net.netstorm.boost.spider.api.builder.Sticker;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import au.net.netstorm.boost.spider.api.runtime.Spider;
import au.net.netstorm.boost.spider.ioc.BoostWeb;
import leapstream.scoreboard.alien.ui.core.Ui;
import leapstream.scoreboard.core.ioc.ScoreboardWeb;
import leapstream.scoreboard.core.model.Build;
import leapstream.scoreboard.core.poll.Poller;
import leapstream.scoreboard.pylons.score.core.HubWeb;
import leapstream.scoreboard.pylons.score.core.PollThing;
import leapstream.scoreboard.pylons.score.core.StatusUiWeb;
import leapstream.scoreboard.pylons.score.core.UiThing;
import leapstream.scoreboard.pylons.status.ui.core.StatusTile;
import leapstream.scoreboard.pylons.status.ui.core.StatusTileWidgets;

// FIX 1915 Dec 23, 2008 Remove dupe
public final class DefaultStatusPylonWirerFu implements StatusPylonWirerFu {
    Sticker sticker;
    PollThing polls;
    Poller poller;
    UiThing uis;
    Nu nu;

    public Ui nu(Build build) {
        Spider spider = spider();
        sticker.instance(spider, Build.class, build);
        Ui ui = uis.ui(spider, StatusTileWidgets.class, StatusTile.class);
        polls.poll(spider, poller);
        return ui;
    }

    private Spider spider() {
        Egg egg = nu.nu(Egg.class, BoostWeb.class, ScoreboardWeb.class, HubWeb.class, StatusUiWeb.class);
        return egg.hatch();
    }
}
