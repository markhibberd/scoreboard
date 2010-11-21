package leapstream.scoreboard.legacy.pylon;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import leapstream.scoreboard.legacy.ui.core.Ui;
import leapstream.scoreboard.legacy.model.Name;

public final class DefaultPylonWirer implements PylonWirer {
    Nu nu;

    public PylonX nu(String name, Ui pylons, boolean mandatory) {
        Name strong = nu.nu(Name.class, name);
        return nu.nu(PylonX.class, strong, pylons, mandatory);
    }
}
