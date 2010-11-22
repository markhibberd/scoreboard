package leapstream.scoreboard.warts.providers.hudson.transforms;

import leapstream.scoreboard.warts.providers.model.Run;

public interface HudsonRun {
    Run run(hudson.model.Run run);
}
