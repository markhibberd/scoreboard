package leapstream.scoreboard.pylons.status.core;

import leapstream.scoreboard.alien.ui.core.Ui;
import leapstream.scoreboard.core.gunge.Builder;
import leapstream.scoreboard.core.model.Build;
import leapstream.scoreboard.core.poll.Times;

// FIX 1915 Dec 23, 2008 Hook in.  Use or lose.
public final class DefaultStatusPylonWirer implements StatusPylonWirer {
    StatusPylonWirerFu status;
    Builder builder;

    public Ui nu(String name, String url, int poll) {
        Build build = builder.get(name, url);
        return status.nu(build, poll);
    }

    public Ui nu(String name, String url) {
        return nu(name, url, Times.STATUS_POLL);
    }
}
