package leapstream.scoreboard.pylons.score.core;

import au.net.netstorm.boost.spider.api.builder.Egg;
import au.net.netstorm.boost.spider.api.builder.SpiderEgg;
import au.net.netstorm.boost.spider.api.builder.Sticker;
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

    public Ui nu(Build build) {
        Spider spider = spider();
        sticker.instance(spider, Build.class, build);        
        // FIX LIFECYCLE No need for widget at all. Just tile. 
        Widget<ScoreTile> widget = widget(spider);
        poll(spider);
        return widget;
    }

    private Widget<ScoreTile> widget(Spider spider) {
        ScoreTileWidgets widgets = spider.resolve(ScoreTileWidgets.class);
        Widget<ScoreTile> widget = widgets.nu();
        ScoreTile tile = widget.control();
        sticker.instance(spider, ScoreTile.class, tile);
        return widget;
    }

    private void poll(Spider spider) {
        Runnable runnable = spider.impl(ScoreRunnable.class);
        TimeoutHandler times = spider.impl(ScoreTimeoutHandler.class);
        ErrorHandler errors = spider.impl(ScoreErrorHandler.class);
        Runnable imbued = resilient.imbune(runnable, errors, times, Times.SCORE_POLL);
        poller.poll(imbued, Times.SCORE_POLL);
    }

    private Spider spider() {
        // FIX 3324 Mar 13, 2009 Can we use Nu here?
        Egg egg = new SpiderEgg(BoostWeb.class, ScoreboardWeb.class, HubWeb.class, PeggedUiWeb.class);
        return egg.hatch();
    }
}
