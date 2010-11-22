package leapstream.scoreboard.warts.providers.hudson.transforms;
// OK GenericIllegalRegexp {

import au.net.netstorm.boost.bullet.time.core.TimePoint;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import leapstream.scoreboard.warts.providers.operations.Timestamp;
import leapstream.scoreboard.warts.providers.model.Id;
import leapstream.scoreboard.warts.providers.model.Result;
import leapstream.scoreboard.warts.providers.model.Run;

import java.util.Calendar;

public final class DefaultHudsonRun implements HudsonRun {
    HudsonResult resultage;
    Timestamp times;
    Nu nu;

    // FIX Perhaps create or get.
    public Run run(hudson.model.Run run) {
        Id id = id(run);
        Result result = resultage.result(run);
        TimePoint timestamp = timestamp(run);
        return nu.nu(Run.class, id, result, timestamp);
    }

    public Id id(hudson.model.Run run) {
        int number = run.getNumber();
        return nu.nu(Id.class, "" + number);
    }

    public TimePoint timestamp(hudson.model.Run run) {
        Calendar timestamp = run.getTimestamp();
        return times.then(timestamp);
    }
}
// } OK GenericIllegalRegexp