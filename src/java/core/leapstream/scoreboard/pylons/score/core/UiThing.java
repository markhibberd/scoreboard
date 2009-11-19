package leapstream.scoreboard.pylons.score.core;

import au.net.netstorm.boost.spider.api.runtime.Spider;
import leapstream.scoreboard.alien.ui.core.Ui;
import leapstream.scoreboard.core.ui.widgets.Widgets;

// FIX LIFECYCLE Push out of pylons. Wrap around all.
public interface UiThing {
    <T> Ui ui(Spider spider, Class<? extends Widgets<T>> widgetscls, Class<T> tilecls);
}
