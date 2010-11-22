package leapstream.scoreboard.warts.providers.hudson.transforms;
// OK GenericIllegalRegexp {

import java.util.Calendar;
import java.util.Date;

import au.net.netstorm.boost.bullet.time.core.TimeFactory;
import au.net.netstorm.boost.bullet.time.core.TimePoint;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import hudson.model.AbstractProject;
import leapstream.scoreboard.warts.providers.operations.Timestamp;
import leapstream.scoreboard.warts.providers.model.Stati;
import leapstream.scoreboard.warts.providers.model.Status;

import static leapstream.scoreboard.warts.providers.model.Stati.BUILDING;
import static leapstream.scoreboard.warts.providers.model.Stati.DISABLED;
import static leapstream.scoreboard.warts.providers.model.Stati.QUEUED;
import static leapstream.scoreboard.warts.providers.model.Stati.WAITING;

public final class DefaultHudsonStatus implements HudsonStatus {
    Nu nu;
    Timestamp time;
    TimeFactory times;

    public Status status(AbstractProject project) {
        Stati stati = stati(project);
        TimePoint since = since(project);
        return nu.nu(Status.class, stati, since);
    }

    private Stati stati(AbstractProject project) {
        if (project.isBuilding()) return BUILDING;
        if (project.isInQueue()) return QUEUED;
        if (project.isDisabled()) return DISABLED;
        return WAITING;
    }

    private TimePoint since(AbstractProject project) {
        hudson.model.Run run = project.getLastBuild();
        if (run == null) return time.now();
        Calendar timestamp = run.getTimestamp();
        Date date = timestamp.getTime();
        return times.time(date);
    }
}
// } OK GenericIllegalRegexp
