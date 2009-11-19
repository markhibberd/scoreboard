package leapstream.scoreboard.pylons.score.core;

import au.net.netstorm.boost.spider.api.builder.Sticker;
import au.net.netstorm.boost.spider.api.runtime.Spider;
import leapstream.scoreboard.alien.ui.core.Ui;
import leapstream.scoreboard.alien.ui.core.Widget;
import leapstream.scoreboard.alien.ui.swing.containers.Failable;
import leapstream.scoreboard.core.model.Build;
import leapstream.scoreboard.core.model.Name;
import leapstream.scoreboard.core.ui.fail.JollyRoger;
import leapstream.scoreboard.core.ui.widgets.Widgets;

public class DefaultUiThing implements UiThing {
    Sticker sticker;

    public <T> Ui ui(Spider spider, Class<? extends Widgets<T>> widgetscls, Class<T> tilecls) {
        Widget<?> widget = widget(spider, widgetscls, tilecls);
        JollyRoger fail = crossbones(spider);
        Failable failable = spider.nu(Failable.class, widget, fail);
        sticker.instance(spider, Failable.class, failable);
        return failable;
    }

    private <T> Widget<?> widget(Spider spider, Class<? extends Widgets<T>> widgetscls, Class<T> tilecls) {
        Widgets<T> widgets = spider.resolve(widgetscls);
        Widget<T> widget = widgets.nu();
        T t = widget.control();
        sticker.instance(spider, tilecls, t);
        return widget;
    }

    private JollyRoger crossbones(Spider spider) {
        JollyRoger fail = spider.nu(JollyRoger.class);
        Build build = spider.resolve(Build.class);
        Name name = build.name();
        fail.set(name);
        return fail;
    }


}
