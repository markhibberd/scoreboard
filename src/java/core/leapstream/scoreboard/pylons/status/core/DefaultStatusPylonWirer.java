package leapstream.scoreboard.pylons.status.core;

import leapstream.scoreboard.core.gunge.Builder;
import leapstream.scoreboard.core.pylon.Pylon;
import leapstream.scoreboard.core.model.Build;
import leapstream.scoreboard.pylons.status.ui.core.StatusTile;

// FIX 1915 Dec 23, 2008 Hook in.  Use or lose.
public final class DefaultStatusPylonWirer implements StatusPylonWirer {
    StatusPylonWirerFu status;
    Builder builder;

    public Pylon<StatusTile> nu(String name, String url) {
        Build build = builder.get(name, url);
        return status.nu(build);
    }
}
