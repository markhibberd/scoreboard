package leapstream.scoreboard.warts.providers.hudson.transforms;

import hudson.model.Hudson;
import hudson.model.Project;

// FIX pull out with other scorebaord stuff.
public interface HudsonProject {
    Project project(Hudson hudson, String name);
}
