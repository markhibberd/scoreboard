package leapstream.scoreboard.warts.providers.hudson.transforms;
// OK GenericIllegalRegexp {

import au.net.netstorm.boost.bullet.time.core.TimeFactory;
import au.net.netstorm.boost.bullet.time.core.TimePoint;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import hudson.model.Project;
import leapstream.scoreboard.core.gunge.Timestamp;
import leapstream.scoreboard.core.model.Stati;
import static leapstream.scoreboard.core.model.Stati.BUILDING;
import static leapstream.scoreboard.core.model.Stati.DISABLED;
import static leapstream.scoreboard.core.model.Stati.QUEUED;
import static leapstream.scoreboard.core.model.Stati.WAITING;
import leapstream.scoreboard.core.model.Status;

import java.util.Calendar;
import java.util.Date;

public final class DefaultHudsonStatus implements HudsonStatus {
    Nu nu;
    Timestamp time;
    TimeFactory times;

    public Status status(Project project) {
        Stati stati = stati(project);
        TimePoint since = since(project);
        return nu.nu(Status.class, stati, since);
    }

    private Stati stati(Project project) {
        if (project.isBuilding()) return BUILDING;
        if (project.isInQueue()) return QUEUED;
        if (project.isDisabled()) return DISABLED;
        return WAITING;
    }

    private TimePoint since(Project project) {
        hudson.model.Run run = project.getLastBuild();
        if (run == null) return time.now();
        Calendar timestamp = run.getTimestamp();
        Date date = timestamp.getTime();
        return times.time(date);
    }
}
// } OK GenericIllegalRegexp
