package leapstream.scoreboard.legacy.config.script;

import au.net.netstorm.boost.gunge.array.ArrayMaster;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import leapstream.scoreboard.legacy.pylon.PylonWirer;
import leapstream.scoreboard.legacy.script.Args;
import leapstream.scoreboard.legacy.script.Script;
import leapstream.scoreboard.legacy.ui.frob.WindowFrobber;
import leapstream.scoreboard.legacy.ui.widgets.Board;
import leapstream.scoreboard.legacy.edge.java.net.URL;

public final class DefaultConfiguratorFu implements ConfiguratorFu {
    WindowFrobber frobber;
    // FIX 1205 Need a generic way to allow this to be bound. Spider??
    Object images = new Object();
    Object scores = new Object();
    Object stati = new Object();
    ArrayMaster arrays;
    PylonWirer wirer;
    Script script;
    Board board;
    Nu nu;

    public void config(URL[] libraries, URL... configs) {
        Args args = args();
        for (URL config : configs)
            evalconfig(libraries, args, config);
    }

    private void evalconfig(URL[] libraries, Args args, URL config) {
        URL[] contextualised = arrays.plus(libraries, config);
        script.execute(args, contextualised);
    }

    private Args args() {
        Args args = nu.nu(Args.class);
        // FIX CONFIG wire in config facade.
        register(args);
        return args;
    }

    private void register(Args args) {
        args.put("wirer", wirer);
        args.put("images", images);
        args.put("builds", scores);
        args.put("stati", stati);
        args.put("board", board);
        args.put("window", frobber);
    }
}
