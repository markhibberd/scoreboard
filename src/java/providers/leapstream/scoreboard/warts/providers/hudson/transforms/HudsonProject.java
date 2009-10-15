package leapstream.scoreboard.warts.providers.hudson.transforms;

import hudson.model.Project;
import hudson.model.Hudson;

// FIX pull out with other scorebaord stuff.
public interface HudsonProject {
    Project project(Hudson hudson, String name);
}
