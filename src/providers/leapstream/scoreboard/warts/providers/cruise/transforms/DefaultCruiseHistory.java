package leapstream.scoreboard.warts.providers.cruise.transforms;

import au.net.netstorm.boost.bullet.time.core.TimePoint;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import leapstream.scoreboard.legacy.model.History;
import leapstream.scoreboard.legacy.model.Id;
import leapstream.scoreboard.legacy.model.Result;
import static leapstream.scoreboard.legacy.model.Result.FAILURE;
import static leapstream.scoreboard.legacy.model.Result.SUCCESS;
import leapstream.scoreboard.legacy.model.Run;
import net.sourceforge.cruisecontrol.dashboard.Build;
import org.joda.time.DateTime;

import java.util.List;

public final class DefaultCruiseHistory implements CruiseHistory {
    int runs = 11;
    CruiseTimer timer;
    Nu nu;

    public History history(List<Build> builds) {
        List items = nu.nu(List.class);
        int size = builds.size();
        int limit = Math.min(size, runs);
        for (int i = 0; i < limit; i++) {
            Build build = builds.get(i);
            history(items, build);
        }
        return nu.nu(History.class, items);
    }

    private void history(List items, Build build) {
        Run run = run(build);
        items.add(run);
    }

    private Run run(Build build) {
        Id id = id(build);
        Result result = result(build);
        TimePoint timestamp = timestamp(build);
        return nu.nu(Run.class, id, result, timestamp);
    }

    private Id id(Build build) {
        DateTime date = build.getBuildDate();
        String label = "" + date.getMillis();
        return nu.nu(Id.class, label);
    }

    private Result result(Build build) {
        return build.hasPassed() ? SUCCESS : FAILURE;
    }

    private TimePoint timestamp(Build build) {
        DateTime dodgy = build.getBuildDate();
        return timer.time(dodgy);
    }
}
