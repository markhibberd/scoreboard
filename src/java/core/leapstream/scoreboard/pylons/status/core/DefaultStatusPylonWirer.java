package leapstream.scoreboard.pylons.status.core;

import leapstream.scoreboard.alien.ui.core.Ui;
import leapstream.scoreboard.core.gunge.Builder;
import leapstream.scoreboard.core.model.Build;

// FIX 1915 Dec 23, 2008 Hook in.  Use or lose.
public final class DefaultStatusPylonWirer implements StatusPylonWirer {
    StatusPylonWirerFu status;
    Builder builder;

    public Ui nu(String name, String url) {
        Build build = builder.get(name, url);
        return status.nu(build);
    }
}
