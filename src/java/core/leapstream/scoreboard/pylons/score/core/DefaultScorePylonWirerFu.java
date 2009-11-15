package leapstream.scoreboard.pylons.score.core;

import au.net.netstorm.boost.spider.api.builder.Egg;
import au.net.netstorm.boost.spider.api.builder.SpiderEgg;
import au.net.netstorm.boost.spider.api.builder.Sticker;
import au.net.netstorm.boost.spider.api.runtime.Resolver;
import au.net.netstorm.boost.spider.api.runtime.Spider;
import au.net.netstorm.boost.spider.ioc.BoostWeb;
import leapstream.scoreboard.alien.resilient.ErrorHandler;
import leapstream.scoreboard.alien.resilient.ResilientRunnables;
import leapstream.scoreboard.alien.resilient.TimeoutHandler;
import leapstream.scoreboard.alien.ui.core.Widget;
import leapstream.scoreboard.core.ioc.ScoreboardWeb;
import leapstream.scoreboard.core.model.Build;
import leapstream.scoreboard.core.poll.Poller;
import leapstream.scoreboard.core.poll.Times;
import leapstream.scoreboard.core.pylon.PylonView;
import leapstream.scoreboard.pylons.score.job.ScoreErrorHandler;
import leapstream.scoreboard.pylons.score.job.ScoreRunnable;
import leapstream.scoreboard.pylons.score.job.ScoreTimeoutHandler;
import leapstream.scoreboard.pylons.score.ui.core.ScoreTile;
import leapstream.scoreboard.pylons.score.ui.core.ScoreTileWidgets;

// FIX 379 Sort out dupe with DefaultImagePylonWirer and DefaultStatusPylonWirerFu.
public final class DefaultScorePylonWirerFu implements ScorePylonWirerFu {
    ResilientRunnables resilient;
    Sticker sticker;
    Poller poller;

    public PylonView<ScoreTile> nu(Build build) {
        Spider spider = spider();
        Widget<ScoreTile> widget = resolve(spider);
        wire(spider, build, widget);
        poll(spider);
        return spider.nu(PylonView.class, widget);
    }

    private void poll(Spider spider) {
        Runnable runnable = spider.impl(ScoreRunnable.class);
        TimeoutHandler times = spider.impl(ScoreTimeoutHandler.class);
        ErrorHandler errors = spider.impl(ScoreErrorHandler.class);
        Runnable imbued = resilient.imbune(runnable, errors, times, Times.SCORE_POLL);
        poller.poll(imbued, Times.SCORE_POLL);
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

    private Spider spider() {
        // FIX 3324 Mar 13, 2009 Can we use Nu here?
        Egg egg = new SpiderEgg(BoostWeb.class, ScoreboardWeb.class, HubWeb.class, PeggedUiWeb.class);
        return egg.hatch();
    }
}
