package leapstream.scoreboard.warts.providers.hudson.transforms;

import hudson.model.AbstractProject;
import leapstream.scoreboard.core.model.Name;

public interface HudsonName {
    Name name(AbstractProject project);
}
