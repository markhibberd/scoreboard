package leapstream.scoreboard.warts.providers.hudson.transforms;

import hudson.model.Project;
import leapstream.scoreboard.core.model.Name;

public interface HudsonName {
    Name name(Project project);
}
