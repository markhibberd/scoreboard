package leapstream.scoreboard.warts.providers.cruise.transforms;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import leapstream.scoreboard.core.model.Name;
import net.sourceforge.cruisecontrol.dashboard.Build;

public final class DefaultCruiseName implements CruiseName {
    Nu nu;

    public Name name(Build build) {
        String name = build.getProjectName();
        return nu.nu(Name.class, name);
    }
}
