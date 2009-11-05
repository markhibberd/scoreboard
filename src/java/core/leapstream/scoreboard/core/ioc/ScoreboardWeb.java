package leapstream.scoreboard.core.ioc;

import au.net.netstorm.boost.bullet.log.LogEngine;
import au.net.netstorm.boost.bullet.log.StandardOutLogEngine;
import au.net.netstorm.boost.spider.api.builder.Spinneret;
import au.net.netstorm.boost.spider.api.config.mapping.Mapper;
import au.net.netstorm.boost.spider.api.config.scope.Scoper;
import au.net.netstorm.boost.spider.api.config.web.Web;
import au.net.netstorm.boost.spider.api.config.wire.Wire;
import au.net.netstorm.boost.spider.api.runtime.Impl;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import au.net.netstorm.boost.spider.api.runtime.Resolver;
import leapstream.scoreboard.alien.clobber.core.ClobberWeb;
import leapstream.scoreboard.alien.ioc.AlienWeb;
import leapstream.scoreboard.alien.ui.audio.AudioWeb;
import leapstream.scoreboard.alien.ui.swing.pear.Frame;
import leapstream.scoreboard.alien.ui.swing.pear.FrameProvider;
import leapstream.scoreboard.alien.ui.swing.pear.Label;
import leapstream.scoreboard.alien.ui.swing.pear.LabelProvider;
import leapstream.scoreboard.alien.ui.swing.pear.Panel;
import leapstream.scoreboard.alien.ui.swing.pear.PanelProvider;
import leapstream.scoreboard.alien.ui.val.AspectRatio;
import leapstream.scoreboard.alien.ui.val.PreferredSize;
import leapstream.scoreboard.alien.aqueduct.AqueductWirer;
import leapstream.scoreboard.alien.aqueduct.ConduitIn;
import leapstream.scoreboard.alien.aqueduct.Aqueduct;
import leapstream.scoreboard.core.ui.key.DefaultNavigator;
import leapstream.scoreboard.core.ui.key.KeyWeb;
import leapstream.scoreboard.core.ui.key.Navigator;
import leapstream.scoreboard.core.ui.widgets.Board;
import leapstream.scoreboard.core.ui.widgets.DefaultBoard;
import leapstream.scoreboard.core.ui.widgets.DefaultNavigableTiles;
import leapstream.scoreboard.core.ui.widgets.NavigableTiles;
import leapstream.scoreboard.core.poll.Times;
import leapstream.scoreboard.core.poll.Threads;

import java.awt.Dimension;

// OK NCSS {
public final class ScoreboardWeb implements Web {
    Dimension preferred = new Dimension(800, 800);
    Dimension aspect = new Dimension(5, 6);
    Spinneret spinneret;
    Resolver resolver;
    Scoper scoper;
    Mapper mapper;
    // FIX 3081 Feb 18, 2009 Remove binders.
    //    RefThing ref;
    Impl impl;
    Nu nu;
    Wire wire;

    public void web() {
        // FIX 1596 Dec 30, 2008 Revisit. Where how is the best way to declare.
        scoper.scope("leapstream.scoreboard");
        mapper.prefix("Default");
        subwebs();
        ui();
        backend();
        logging();
    }

    private void subwebs() {
        spinneret.spin(ClobberWeb.class);
        spinneret.spin(AudioWeb.class);
        spinneret.spin(KeyWeb.class);
        spinneret.spin(AlienWeb.class);
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
        wire.nu(PreferredSize.class, preferred).to(PreferredSize.class);
        wire.nu(AspectRatio.class, aspect).to(AspectRatio.class);
        wire.provider(FrameProvider.class).one().to(Frame.class);
        // FIX 1596 Mar 5, 2009 The following do not need the mapping (only the single).
        wire.cls(DefaultNavigator.class).one().to(Navigator.class);
        wire.cls(DefaultNavigableTiles.class).one().to(NavigableTiles.class);
        wire.cls(DefaultBoard.class).one().to(Board.class);
    }

    private void backend() {
        AqueductWirer aqueducts = nu.nu(AqueductWirer.class);
        Aqueduct aqueduct = aqueducts.nu(Threads.POOL);
        ConduitIn in = aqueduct.in();
        wire.ref(in).to(ConduitIn.class);
        wire.ref(aqueduct).to(Aqueduct.class);
    }

    private void logging() {
        wire.cls(StandardOutLogEngine.class).to(LogEngine.class);
    }
}
// } OK NCSS
