package leapstream.scoreboard.core.gunge;

import au.net.netstorm.boost.bullet.incredibles.core.Weaken;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import leapstream.scoreboard.core.model.History;
import leapstream.scoreboard.core.model.Id;
import leapstream.scoreboard.core.model.Result;
import leapstream.scoreboard.core.model.Run;

import static java.lang.Math.min;
import java.util.List;

public final class DefaultHistorian implements Historian {
    private static final int MAX_VOLUME = 11;
    Weaken weaken;
    Nu nu;

    public Id last(History history) {
        List<Run> runs = weaken.w(history);
        if (runs.size() == 0) return nu.nu(Id.class, "nil");
        Run run = runs.get(0);
        return run.id();
    }

    public int count(History history) {
        List<Run> runs = weaken.w(history);
        if (runs.size() == 0) return 0;
        int count = count(runs);
        return min(count, MAX_VOLUME);
    }

    public boolean good(History history) {
        List<Run> runs = weaken.w(history);
        if (runs.size() == 0) return true;
        Run run = runs.get(0);
        Result result = run.result();
        return result == Result.SUCCESS;
    }

    private int count(List<Run> runs) {
        Run first = runs.get(0);
        Result expected = first.result();
        return count(runs, expected);
    }

    private int count(List<Run> runs, Result expected) {
        int r = 0;
        for (Run run : runs) {
            if (run.result() != expected) break;
            ++r;
        }
        return r;
    }
}
