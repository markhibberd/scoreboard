package leapstream.scoreboard.warts.providers.cruise.transforms;

import au.net.netstorm.boost.bullet.time.core.TimePoint;
import au.net.netstorm.boost.gunge.collection.DefaultStrictMap;
import au.net.netstorm.boost.gunge.collection.StrictMap;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import leapstream.scoreboard.core.model.Stati;
import static leapstream.scoreboard.core.model.Stati.BUILDING;
import static leapstream.scoreboard.core.model.Stati.DISABLED;
import static leapstream.scoreboard.core.model.Stati.ERRORED;
import static leapstream.scoreboard.core.model.Stati.QUEUED;
import static leapstream.scoreboard.core.model.Stati.WAITING;
import leapstream.scoreboard.core.model.Status;
import net.sourceforge.cruisecontrol.dashboard.Build;
import net.sourceforge.cruisecontrol.dashboard.CurrentStatus;
import org.joda.time.DateTime;

public final class DefaultCruiseStatus implements CruiseStatus {
    CruiseTimer timer;
    Nu nu;
    StrictMap<CurrentStatus, Stati> statis = new DefaultStrictMap();

    {
        statis.put(CurrentStatus.BUILDING, BUILDING);
        statis.put(CurrentStatus.BOOTSTRAPPING, WAITING);
        statis.put(CurrentStatus.DISCONTINUED, ERRORED);
        statis.put(CurrentStatus.MODIFICATIONSET, WAITING);
        statis.put(CurrentStatus.PAUSED, DISABLED);
        statis.put(CurrentStatus.QUEUED, QUEUED);
        statis.put(CurrentStatus.WAITING, WAITING);
    }

    public Status status(Build build) {
        Stati stati = stati(build);
        TimePoint time = since(build, stati);
        return nu.nu(Status.class, stati, time);
    }

    private Stati stati(Build build) {
        CurrentStatus status = build.getCurrentStatus();
        if (statis.exists(status)) return statis.get(status);
        throw new IllegalStateException("Cruise is a sequinned turd " + status);
    }

    private TimePoint since(Build build, Stati stati) {
        DateTime dodgy = fucked(build, stati);
        return timer.time(dodgy);
    }

    private DateTime fucked(Build build, Stati stati) {
        return stati == BUILDING ? build.getBuildingSince() : build.getBuildDate();
    }
}
