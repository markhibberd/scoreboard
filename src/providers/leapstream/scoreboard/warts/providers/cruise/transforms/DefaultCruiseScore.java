package leapstream.scoreboard.warts.providers.cruise.transforms;

import au.net.netstorm.boost.bullet.time.core.Clock;
import au.net.netstorm.boost.bullet.time.core.TimePoint;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import leapstream.scoreboard.legacy.model.History;
import leapstream.scoreboard.legacy.model.Name;
import leapstream.scoreboard.legacy.model.Score;
import leapstream.scoreboard.legacy.model.Status;
import net.sourceforge.cruisecontrol.dashboard.Build;

import java.util.List;

public final class DefaultCruiseScore implements CruiseScore {
    CruiseStatus statistician;
    CruiseHistory historian;
    CruiseName namer;
    Clock clock;
    Nu nu;

    public Score score(Build build, List<Build> builds) {
        Name name = namer.name(build);
        TimePoint timestamp = clock.now();
        Status status = statistician.status(build);
        History history = historian.history(builds);
        return nu.nu(Score.class, name, status, timestamp, history);
    }
}
