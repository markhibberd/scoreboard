package leapstream.scoreboard.warts.providers.hudson.transforms;

import leapstream.scoreboard.legacy.model.Run;

public interface HudsonRun {
    Run run(hudson.model.Run run);
}
