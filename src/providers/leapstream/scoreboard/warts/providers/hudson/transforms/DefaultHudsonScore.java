package leapstream.scoreboard.warts.providers.hudson.transforms;

import au.net.netstorm.boost.bullet.time.core.TimePoint;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import hudson.model.AbstractProject;
import leapstream.scoreboard.warts.providers.operations.Timestamp;
import leapstream.scoreboard.warts.providers.model.History;
import leapstream.scoreboard.warts.providers.model.Name;
import leapstream.scoreboard.warts.providers.model.Score;
import leapstream.scoreboard.warts.providers.model.Status;

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
