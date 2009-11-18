package leapstream.scoreboard.pylons.status.core;

import au.net.netstorm.boost.spider.api.builder.Egg;
import au.net.netstorm.boost.spider.api.builder.SpiderEgg;
import au.net.netstorm.boost.spider.api.builder.Sticker;
import au.net.netstorm.boost.spider.api.runtime.Resolver;
import au.net.netstorm.boost.spider.api.runtime.Spider;
import au.net.netstorm.boost.spider.ioc.BoostWeb;
import leapstream.scoreboard.alien.resilient.ErrorHandler;
import leapstream.scoreboard.alien.resilient.ResilientRunnables;
import leapstream.scoreboard.alien.resilient.TimeoutHandler;
import leapstream.scoreboard.alien.ui.core.Ui;
import leapstream.scoreboard.alien.ui.core.Widget;
import leapstream.scoreboard.core.ioc.ScoreboardWeb;
import leapstream.scoreboard.core.model.Build;
import leapstream.scoreboard.core.poll.Poller;
import leapstream.scoreboard.core.poll.Times;
import leapstream.scoreboard.pylons.score.core.HubWeb;
import leapstream.scoreboard.pylons.score.core.StatusUiWeb;
import leapstream.scoreboard.pylons.score.job.ScoreErrorHandler;
import leapstream.scoreboard.pylons.score.job.ScoreRunnable;
import leapstream.scoreboard.pylons.score.job.ScoreTimeoutHandler;
import leapstream.scoreboard.pylons.status.ui.core.StatusTile;
import leapstream.scoreboard.pylons.status.ui.core.StatusTileWidgets;

// FIX 1915 Dec 23, 2008 Remove dupe
public final class DefaultStatusPylonWirerFu implements StatusPylonWirerFu {
    ResilientRunnables resilient;
    Sticker sticker;
    Poller poller;

    // FIX BREADCRUMB 1915 AAAAAAAAAAAAAAAAAAAAAAAAAA Here.
    public Ui nu(Build build) {
        Spider spider = spider();
        Widget<StatusTile> widget = resolve(spider);
        wire(spider, build, widget);
        poll(spider);
        return widget;
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

    private void poll(Spider spider) {
        Runnable runnable = spider.impl(ScoreRunnable.class);
        TimeoutHandler times = spider.impl(ScoreTimeoutHandler.class);
        ErrorHandler errors = spider.impl(ScoreErrorHandler.class);
        Runnable imbued = resilient.imbune(runnable, errors, times, Times.STATUS_POLL);
        poller.poll(imbued, Times.STATUS_POLL);
    }

    private Spider spider() {
        // FIX 3324 Mar 13, 2009 Can we use Nu here?
        Egg egg = new SpiderEgg(BoostWeb.class, ScoreboardWeb.class, HubWeb.class, StatusUiWeb.class);
        return egg.hatch();
    }
}
