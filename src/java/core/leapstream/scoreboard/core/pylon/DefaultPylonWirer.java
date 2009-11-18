package leapstream.scoreboard.core.pylon;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import leapstream.scoreboard.alien.ui.core.Ui;
import leapstream.scoreboard.core.model.Name;

public final class DefaultPylonWirer implements PylonWirer {
    Nu nu;

    public Pylon nu(String name, Ui pylons, boolean mandatory) {
        Name strong = nu.nu(Name.class, name);
        return nu.nu(Pylon.class, strong, pylons, mandatory);
    }
}
