package leapstream.scoreboard.warts.providers.hudson.transforms;

import hudson.model.Hudson;
import hudson.model.Project;
import hudson.model.TopLevelItem;

// FIX pull out with other scorebaord stuff.
public final class DefaultHudsonProject implements HudsonProject {
    public Project project(Hudson hudson, String name) {
        if (name == null || name.equals("")) fail("Must specify project.");
        TopLevelItem item = hudson.getItem(name);
        if (!(item instanceof Project)) fail("Invalid project specified: '" + name + "'");
        return (Project) item;
    }

    private void fail(String message) {
        throw new IllegalArgumentException(message);
    }

}
