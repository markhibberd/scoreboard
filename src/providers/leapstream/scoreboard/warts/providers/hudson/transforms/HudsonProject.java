package leapstream.scoreboard.warts.providers.hudson.transforms;

import hudson.model.AbstractProject;
import hudson.model.Hudson;

// FIX pull out with other scorebaord stuff.
public interface HudsonProject {
    AbstractProject project(Hudson hudson, String name);
}
