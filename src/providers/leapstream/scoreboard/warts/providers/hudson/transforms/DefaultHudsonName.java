package leapstream.scoreboard.warts.providers.hudson.transforms;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import hudson.model.AbstractProject;
import leapstream.scoreboard.legacy.model.Name;

public final class DefaultHudsonName implements HudsonName {
    Nu nu;

    public Name name(AbstractProject project) {
        String name = project.getName();
        return nu.nu(Name.class, name);
    }
}
