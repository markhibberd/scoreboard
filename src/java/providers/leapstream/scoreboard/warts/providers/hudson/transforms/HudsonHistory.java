package leapstream.scoreboard.warts.providers.hudson.transforms;

import hudson.model.AbstractProject;
import leapstream.scoreboard.core.model.History;

public interface HudsonHistory {
    History history(AbstractProject project, Integer noOfRuns);
}
