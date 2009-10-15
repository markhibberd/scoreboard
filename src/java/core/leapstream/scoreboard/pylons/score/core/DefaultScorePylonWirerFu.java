package leapstream.scoreboard.pylons.score.core;

import au.net.netstorm.boost.bullet.farmer.Farmer;
import au.net.netstorm.boost.bullet.farmer.FarmerWirer;
import au.net.netstorm.boost.bullet.farmer.Pull;
import au.net.netstorm.boost.bullet.farmer.Push;
import au.net.netstorm.boost.gunge.lifecycle.StartStop;
import au.net.netstorm.boost.spider.api.builder.Egg;
import au.net.netstorm.boost.spider.api.builder.SpiderEgg;
import au.net.netstorm.boost.spider.api.builder.Sticker;
import au.net.netstorm.boost.spider.api.runtime.Resolver;
import au.net.netstorm.boost.spider.api.runtime.Spider;
import au.net.netstorm.boost.spider.ioc.BoostWeb;
import leapstream.scoreboard.alien.ui.core.Widget;
import leapstream.scoreboard.core.ioc.ScoreboardWeb;
import leapstream.scoreboard.core.model.Build;
import static leapstream.scoreboard.core.poll.Times.SCORE_POLL;
import static leapstream.scoreboard.core.poll.Times.SCORE_TIMEOUT;
import leapstream.scoreboard.core.pylon.Pylon;
import leapstream.scoreboard.pylons.score.pull.ScorePuller;
import leapstream.scoreboard.pylons.score.push.ScorePusher;
import leapstream.scoreboard.pylons.score.ui.core.ScoreTile;
import leapstream.scoreboard.pylons.score.ui.core.ScoreTileWidgets;

// FIX 379 Sort out dupe with DefaultImagePylonWirer and DefaultStatusPylonWirerFu.
public final class DefaultScorePylonWirerFu implements ScorePylonWirerFu {
    FarmerWirer farmers;
    Sticker sticker;

    public Pylon<ScoreTile> nu(Build build) {
        Spider spider = spider();
        Widget<ScoreTile> widget = resolve(spider);
        wire(spider, build, widget);
        StartStop ss = farm(spider);
        return spider.nu(Pylon.class, widget, ss);
    }

    // FIX 244 Split this out into two roles, switch to new spider, then wire everything together.
    private Widget<ScoreTile> resolve(Resolver resolver) {
        ScoreTileWidgets widgets = resolver.resolve(ScoreTileWidgets.class);
        return widgets.nu();
    }

    private void wire(Resolver resolver, Build build, Widget<ScoreTile> widget) {
        ScoreTile tile = widget.control();
        sticker.instance(resolver, ScoreTile.class, tile);
        sticker.instance(resolver, Build.class, build);
    }

    private StartStop farm(Resolver resolver) {
        Farmer farmer = farmers.nu(SCORE_POLL, SCORE_TIMEOUT);
        Pull puller = resolver.resolve(ScorePuller.class);
        Push pusher = resolver.resolve(ScorePusher.class);
        return farmer.farm(pusher, puller);
    }

    private Spider spider() {
        // FIX 3324 Mar 13, 2009 Can we use Nu here?
        Egg egg = new SpiderEgg(BoostWeb.class, ScoreboardWeb.class, HubWeb.class, PeggedUiWeb.class);
        return egg.hatch();
    }
}
