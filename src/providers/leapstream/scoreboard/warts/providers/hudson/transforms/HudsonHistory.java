package leapstream.scoreboard.warts.providers.hudson.transforms;

import hudson.model.AbstractProject;
import leapstream.scoreboard.warts.providers.model.History;

public interface HudsonHistory {
    History history(AbstractProject project, Integer noOfRuns);
}
