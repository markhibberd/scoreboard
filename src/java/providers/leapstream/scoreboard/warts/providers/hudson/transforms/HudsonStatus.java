package leapstream.scoreboard.warts.providers.hudson.transforms;

import hudson.model.Project;
import leapstream.scoreboard.core.model.Status;

public interface HudsonStatus {
    Status status(Project project);
}
