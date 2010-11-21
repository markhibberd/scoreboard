package leapstream.scoreboard.warts.providers.hudson.transforms;

import hudson.model.AbstractProject;
import hudson.model.Hudson;
import hudson.model.TopLevelItem;

// FIX pull out with other scorebaord stuff.
public final class DefaultHudsonProject implements HudsonProject {
    public AbstractProject project(Hudson hudson, String name) {
        if (name == null || name.equals("")) fail("Must specify project.");
        TopLevelItem item = hudson.getItem(name);
        if (!(item instanceof AbstractProject))
            fail("Invalid project specified: '" + name + "', this one is [" + item.getClass().getSimpleName() + "]");
        return (AbstractProject) item;
    }

    private void fail(String message) {
        throw new IllegalArgumentException(message);
    }

}
