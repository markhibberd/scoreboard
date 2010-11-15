package leapstream.scoreboard.warts.providers.hudson.transforms;

import hudson.model.Run;
import leapstream.scoreboard.legacy.model.Result;

public interface HudsonResult {
    Result result(Run run);
}
