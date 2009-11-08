package leapstream.scoreboard.core.config;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import leapstream.scoreboard.alien.aqueduct.Aqueduct;
import leapstream.scoreboard.alien.script.Args;
import leapstream.scoreboard.alien.script.Script;
import leapstream.scoreboard.core.pylon.PylonWirer;
import leapstream.scoreboard.core.pylon.Pylons;
import leapstream.scoreboard.edge.java.net.URL;
import leapstream.scoreboard.pylons.image.core.ImagePylonWirer;
import leapstream.scoreboard.pylons.score.core.ScorePylonWirer;
import leapstream.scoreboard.pylons.status.core.StatusPylonWirer;

public final class DefaultConfiguratorFu implements ConfiguratorFu {
    // FIX 1205 Need a generic way to allow this to be bound. Spider??
    ImagePylonWirer images;
    ScorePylonWirer scores;
    StatusPylonWirer stati;
    Aqueduct aqueduct;
    PylonWirer wirer;
    Script script;
    Pylons pylons;
    Nu nu;
    // FIX CONFIG add config facade here.

    public void config(URL... urls) {
        Args args = args();
        script.execute(args, urls);
    }

    private Args args() {
        Args args = nu.nu(Args.class);
        // FIX CONFIG wire in config facade.
        args.put("pylons", pylons);
        args.put("wirer", wirer);
        args.put("images", images);
        args.put("builds", scores);
        args.put("stati", stati);
        args.put("threadpool", aqueduct);
        return args;
    }
}
