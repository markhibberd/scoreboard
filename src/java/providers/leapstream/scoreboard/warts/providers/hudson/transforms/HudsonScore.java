package leapstream.scoreboard.warts.providers.hudson.transforms;

import hudson.model.Project;
import leapstream.scoreboard.core.model.Score;

public interface HudsonScore {
    Score score(Project project, Integer noOfRuns);
}
