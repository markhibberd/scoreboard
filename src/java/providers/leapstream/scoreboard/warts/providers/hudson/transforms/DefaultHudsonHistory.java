package leapstream.scoreboard.warts.providers.hudson.transforms;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import hudson.model.Project;
import leapstream.scoreboard.core.model.History;
import leapstream.scoreboard.core.model.Run;

import java.util.List;

public final class DefaultHudsonHistory implements HudsonHistory {
    HudsonRun runner;
    Nu nu;

    public History history(Project project, Integer noOfRuns) {
        List<Run> runs = nu.nu(List.class);
        accumulate(project, noOfRuns, runs);
        return nu.nu(History.class, runs);
    }

    private void accumulate(Project project, Integer noOfRuns, List<Run> runs) {
        hudson.model.Run last = project.getLastBuild();
        if (last == null) return;
        if (last.isBuilding()) last = last.getPreviousBuild();
        accumulate(noOfRuns, runs, last);
    }

    private void accumulate(Integer noOfRuns, List<Run> runs, hudson.model.Run last) {
        while (!done(noOfRuns, runs, last)) last = add(runs, last);
    }

    private hudson.model.Run add(List<Run> runs, hudson.model.Run last) {
        Run run = runner.run(last);
        runs.add(run);
        return last.getPreviousBuild();
    }

    private boolean done(Integer noOfRuns, List<Run> runs, hudson.model.Run last) {
        return runs.size() >= noOfRuns || last == null;
    }
}
