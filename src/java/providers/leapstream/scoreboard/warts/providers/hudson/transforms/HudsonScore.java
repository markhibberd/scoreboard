package leapstream.scoreboard.warts.providers.hudson.transforms;

import hudson.model.AbstractProject;
import leapstream.scoreboard.core.model.Score;

public interface HudsonScore {
    Score score(AbstractProject project, Integer noOfRuns);
}
