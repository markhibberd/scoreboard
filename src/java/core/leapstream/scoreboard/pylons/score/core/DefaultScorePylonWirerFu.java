package leapstream.scoreboard.pylons.score.core;

import au.net.netstorm.boost.spider.api.builder.Egg;
import au.net.netstorm.boost.spider.api.builder.Sticker;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import au.net.netstorm.boost.spider.api.runtime.Spider;
import au.net.netstorm.boost.spider.ioc.BoostWeb;
import leapstream.scoreboard.alien.ui.core.Ui;
import leapstream.scoreboard.core.ioc.ScoreboardWeb;
import leapstream.scoreboard.core.model.Build;
import leapstream.scoreboard.core.poll.Poller;
import leapstream.scoreboard.pylons.score.ui.core.ScoreTile;
import leapstream.scoreboard.pylons.score.ui.core.ScoreTileWidgets;

// FIX 379 Sort out dupe with DefaultImagePylonWirer and DefaultStatusPylonWirerFu.
public final class DefaultScorePylonWirerFu implements ScorePylonWirerFu {
    PollThing polls;
    Sticker sticker;
    Poller poller;
    UiThing uis;
    Nu nu;

    // FIX LIFECYCLE A lot of this is generic and needs to be pulled out.  See DefaultStatusPylonWirerFu.
    public Ui nu(Build build, int poll) {
        Spider spider = spider();
        sticker.instance(spider, Build.class, build);
        Ui ui = uis.ui(spider, ScoreTileWidgets.class, ScoreTile.class);
        polls.poll(spider, poller, poll);
        return ui;
    }

    private Spider spider() {
        Egg egg = nu.nu(Egg.class, BoostWeb.class, ScoreboardWeb.class, HubWeb.class, PeggedUiWeb.class);
        return egg.hatch();
    }
}
