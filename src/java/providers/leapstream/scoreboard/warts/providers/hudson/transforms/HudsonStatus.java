package leapstream.scoreboard.warts.providers.hudson.transforms;

import hudson.model.AbstractProject;
import leapstream.scoreboard.core.model.Status;

public interface HudsonStatus {
    Status status(AbstractProject project);
}
