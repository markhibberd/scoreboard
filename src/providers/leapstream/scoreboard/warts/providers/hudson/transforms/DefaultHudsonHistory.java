package leapstream.scoreboard.warts.providers.hudson.transforms;

import java.util.List;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import hudson.model.AbstractProject;
import leapstream.scoreboard.warts.providers.model.History;
import leapstream.scoreboard.warts.providers.model.Run;

public final class DefaultHudsonHistory implements HudsonHistory {
    HudsonRun runner;
    Nu nu;

    public History history(AbstractProject project, Integer noOfRuns) {
        List<Run> runs = nu.nu(List.class);
        accumulate(project, noOfRuns, runs);
        return nu.nu(History.class, runs);
    }

    private void accumulate(AbstractProject project, Integer noOfRuns, List<Run> runs) {
        hudson.model.Run last = project.getLastBuild();
        if (last == null) return;
        if (last.isBuilding()) last = last.getPreviousBuild();
        accumulate(noOfRuns, runs, last);
    }

    private void accumulate(Integer noOfRuns, List<Run> runs, hudson.model.Run last) {
        hudson.model.Run accumulator = last;
        while (!done(noOfRuns, runs, accumulator)) accumulator = add(runs, accumulator);
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
