package leapstream.scoreboard.legacy.ioc;

import au.net.netstorm.boost.bullet.log.LogEngine;
import au.net.netstorm.boost.bullet.log.StandardOutLogEngine;
import au.net.netstorm.boost.spider.api.builder.Spinneret;
import au.net.netstorm.boost.spider.api.config.mapping.Mapper;
import au.net.netstorm.boost.spider.api.config.scope.Scoper;
import au.net.netstorm.boost.spider.api.config.web.Web;
import au.net.netstorm.boost.spider.api.config.wire.Wire;
import leapstream.scoreboard.legacy.clobber.core.ClobberWeb;
import leapstream.scoreboard.legacy.ui.swing.pear.Frame;
import leapstream.scoreboard.legacy.ui.swing.pear.FrameProvider;
import leapstream.scoreboard.legacy.ui.swing.pear.Label;
import leapstream.scoreboard.legacy.ui.swing.pear.LabelProvider;
import leapstream.scoreboard.legacy.ui.swing.pear.Panel;
import leapstream.scoreboard.legacy.ui.swing.pear.PanelProvider;
import leapstream.scoreboard.legacy.config.script.ConfiguratorLibraries;
import leapstream.scoreboard.legacy.config.script.DefaultConfiguratorLibraries;
import leapstream.scoreboard.legacy.pylon.DefaultPylons;
import leapstream.scoreboard.legacy.ui.key.DefaultNavigator;
import leapstream.scoreboard.legacy.ui.key.KeyWeb;
import leapstream.scoreboard.legacy.ui.key.Navigator;
import leapstream.scoreboard.legacy.ui.widgets.Board;
import leapstream.scoreboard.legacy.ui.widgets.DefaultBoard;
import leapstream.scoreboard.legacy.ui.widgets.DefaultNavigableTiles;
import leapstream.scoreboard.legacy.ui.widgets.NavigableTiles;
import leapstream.scoreboard.legacy.pylon.Pylons;

// OK NCSS {
public final class ScoreboardWeb implements Web {
    Spinneret spinneret;
    Scoper scoper;
    Mapper mapper;
    Wire wire;

    public void web() {
        // FIX 1596 Dec 30, 2008 Revisit. Where how is the best way to declare.
        scoper.scope("leapstream.scoreboard");
        mapper.prefix("Default");
        state();
        subwebs();
        ui();
        logging();
    }

    private void state() {
        wire.cls(DefaultPylons.class).one().to(Pylons.class);
        wire.cls(DefaultConfiguratorLibraries.class).one().to(ConfiguratorLibraries.class);
    }

    private void subwebs() {
        spinneret.spin(ClobberWeb.class);
        spinneret.spin(KeyWeb.class);
    }

    // FIX 3081 Feb 18, 2009 Look at how scoping works.
    // FIX 3081 Feb 18, 2009 This is one of a drivers for the API change.
    // FIX BREADCRUMB 3081 AAAAAAAAAAAAAAAAAAAAAAA Use this as driver for sticky|one|single|shared.
    // FIX 3081 Feb 18, 2009 Tidy
    private void ui() {
        general();
        single();
    }

    private void general() {
        wire.provider(PanelProvider.class).to(Panel.class);
        wire.provider(LabelProvider.class).to(Label.class);
    }

    private void single() {
        wire.provider(FrameProvider.class).one().to(Frame.class);
        // FIX 1596 Mar 5, 2009 The following do not need the mapping (only the single).
        wire.cls(DefaultNavigator.class).one().to(Navigator.class);
        wire.cls(DefaultNavigableTiles.class).one().to(NavigableTiles.class);
        wire.cls(DefaultBoard.class).one().to(Board.class);
    }

    private void logging() {
        wire.cls(StandardOutLogEngine.class).to(LogEngine.class);
    }

}
// } OK NCSS
