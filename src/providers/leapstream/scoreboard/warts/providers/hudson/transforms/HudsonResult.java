package leapstream.scoreboard.warts.providers.hudson.transforms;

import hudson.model.Run;
import leapstream.scoreboard.warts.providers.model.Result;

public interface HudsonResult {
    Result result(Run run);
}
