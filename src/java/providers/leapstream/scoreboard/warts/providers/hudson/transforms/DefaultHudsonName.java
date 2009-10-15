package leapstream.scoreboard.warts.providers.hudson.transforms;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import hudson.model.Project;
import leapstream.scoreboard.core.model.Name;

public final class DefaultHudsonName implements HudsonName {
    Nu nu;

    public Name name(Project project) {
        String name = project.getName();
        return nu.nu(Name.class, name);
    }
}
