package leapstream.scoreboard.warts.providers.hudson.transforms;

import au.net.netstorm.boost.bullet.time.core.TimePoint;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import hudson.model.AbstractProject;
import leapstream.scoreboard.core.gunge.Timestamp;
import leapstream.scoreboard.core.model.History;
import leapstream.scoreboard.core.model.Name;
import leapstream.scoreboard.core.model.Score;
import leapstream.scoreboard.core.model.Status;

public class DefaultHudsonScore implements HudsonScore {
    HudsonStatus statistician;
    HudsonName namer;
    HudsonHistory historian;
    Timestamp time;
    Nu nu;

    public Score score(AbstractProject project, Integer noOfRuns) {
        Name name = namer.name(project);
        Status status = statistician.status(project);
        TimePoint timestamp = time.now();
        History history = historian.history(project, noOfRuns);
        return nu.nu(Score.class, name, status, timestamp, history);
    }
}
