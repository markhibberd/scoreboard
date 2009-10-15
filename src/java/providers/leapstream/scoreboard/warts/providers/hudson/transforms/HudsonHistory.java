package leapstream.scoreboard.warts.providers.hudson.transforms;

import hudson.model.Project;
import leapstream.scoreboard.core.model.History;

public interface HudsonHistory {
    History history(Project project, Integer noOfRuns);
}
