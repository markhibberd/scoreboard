package leapstream.scoreboard.warts.providers.hudson.transforms;

import hudson.model.Hudson;
import hudson.model.Project;
import leapstream.scoreboard.alien.clobber.core.Dumper;
import leapstream.scoreboard.core.model.Score;

public final class DefaultScorer implements Scorer {
    private static final int HISTORY = 11;
    Hudson hudson;
    HudsonScore scorer;
    HudsonProject projector;
    Dumper dumper;

    public String score(String name) {
       Project project = projector.project(hudson, name);
       Score score = scorer.score(project, HISTORY);
       return dumper.dump(score);
    }
}
