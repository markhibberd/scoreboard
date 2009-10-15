package leapstream.scoreboard.pylons.status.core;

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
import static leapstream.scoreboard.core.poll.Times.STATUS_POLL;
import static leapstream.scoreboard.core.poll.Times.STATUS_TIMEOUT;
import leapstream.scoreboard.core.pylon.Pylon;
import leapstream.scoreboard.pylons.score.core.HubWeb;
import leapstream.scoreboard.pylons.score.core.StatusUiWeb;
import leapstream.scoreboard.pylons.score.pull.ScorePuller;
import leapstream.scoreboard.pylons.score.push.ScorePusher;
import leapstream.scoreboard.pylons.status.ui.core.StatusTile;
import leapstream.scoreboard.pylons.status.ui.core.StatusTileWidgets;

// FIX 1915 Dec 23, 2008 Remove dupe
public final class DefaultStatusPylonWirerFu implements StatusPylonWirerFu {
    FarmerWirer farmers;
    Sticker sticker;

    // FIX BREADCRUMB 1915 AAAAAAAAAAAAAAAAAAAAAAAAAA Here.
    public Pylon<StatusTile> nu(Build build) {
        Spider spider = spider();
        Widget<StatusTile> widget = resolve(spider);
        wire(spider, build, widget);
        StartStop ss = farm(spider);
        return spider.nu(Pylon.class, widget, ss);
    }

    private void wire(Resolver resolver, Build build, Widget<StatusTile> widget) {
        StatusTile tile = widget.control();
        sticker.instance(resolver, StatusTile.class, tile);
        sticker.instance(resolver, Build.class, build);
    }

    private Widget<StatusTile> resolve(Resolver resolver) {
        StatusTileWidgets widgets = resolver.resolve(StatusTileWidgets.class);
        return widgets.nu();
    }

    private StartStop farm(Resolver resolver) {
        Farmer farmer = farmers.nu(STATUS_POLL, STATUS_TIMEOUT);
        Pull puller = resolver.resolve(ScorePuller.class);
        Push pusher = resolver.resolve(ScorePusher.class);
        return farmer.farm(pusher, puller);
    }

    private Spider spider() {
        // FIX 3324 Mar 13, 2009 Can we use Nu here?
        Egg egg = new SpiderEgg(BoostWeb.class, ScoreboardWeb.class, HubWeb.class, StatusUiWeb.class);
        return egg.hatch();
    }
}
