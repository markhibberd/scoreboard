package leapstream.scoreboard.warts.providers.hudson.transforms;

import hudson.model.AbstractProject;
import hudson.model.Hudson;
import leapstream.scoreboard.warts.providers.clobber.core.Dumper;
import leapstream.scoreboard.warts.providers.model.Score;

public final class DefaultScorer implements Scorer {
    private static final int HISTORY = 11;
    Hudson hudson;
    HudsonScore scorer;
    HudsonProject projector;
    Dumper dumper;

    public String score(String name) {
       AbstractProject project = projector.project(hudson, name);
       Score score = scorer.score(project, HISTORY);
       return dumper.dump(score);
    }
}
