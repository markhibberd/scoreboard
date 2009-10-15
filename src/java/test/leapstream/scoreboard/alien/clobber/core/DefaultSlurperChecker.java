package leapstream.scoreboard.alien.clobber.core;

import au.net.netstorm.boost.bullet.scalpel.core.Edges;
import au.net.netstorm.boost.bullet.time.core.TimePoint;
import au.net.netstorm.boost.spider.api.lifecycle.Constructable;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import junit.framework.Assert;
import leapstream.scoreboard.alien.gunge.TimePointFormatter;
import leapstream.scoreboard.core.model.History;
import leapstream.scoreboard.core.model.Id;
import leapstream.scoreboard.core.model.Name;
import static leapstream.scoreboard.core.model.Result.SUCCESS;
import leapstream.scoreboard.core.model.Run;
import leapstream.scoreboard.core.model.Score;
import static leapstream.scoreboard.core.model.Stati.BUILDING;
import leapstream.scoreboard.core.model.Status;
import leapstream.scoreboard.edge.java.io.InputStream;

import java.util.List;

public final class DefaultSlurperChecker extends Assert implements SlurperChecker, Constructable {
    private Name name;
    private TimePoint time;
    private Id id;
    private Status status;
    private Score score;
    private Run run;
    private History history;
    TimePointFormatter formatter;
    Edges edges;
    Nu nu;

    public void constructor() {
        // FIX 375 Think about these hard coded values a bit more (they currently have to correspond to some files). Dodgy.
        name = nu.nu(Name.class, "boost");
        time = formatter.parse("2008-09-01T02:45:00Z");
        id = nu.nu(Id.class, "id");
        status = nu.nu(Status.class, BUILDING, time);
        run = nu.nu(Run.class, time, id, SUCCESS);
        history = history();
        score = nu.nu(Score.class, name, time, status, history);
    }

    public void check(Slurper subject, InputStream stream) {
        Score actual = subject.slurp(Score.class, stream);
        assertEquals(score, actual);
    }

    private History history() {
        List<Run> runs = nu.nu(List.class);
        for (int i = 0; i < 10; i++) runs.add(run);
        return nu.nu(History.class, runs);
    }
}
