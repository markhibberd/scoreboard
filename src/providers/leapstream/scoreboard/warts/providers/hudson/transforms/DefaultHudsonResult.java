package leapstream.scoreboard.warts.providers.hudson.transforms;

import static hudson.model.Result.ABORTED;
import static hudson.model.Result.FAILURE;
import static hudson.model.Result.NOT_BUILT;
import static hudson.model.Result.SUCCESS;
import static hudson.model.Result.UNSTABLE;
import hudson.model.Run;
import leapstream.scoreboard.warts.providers.model.Result;

import java.util.HashMap;
import java.util.Map;

public final class DefaultHudsonResult implements HudsonResult {
    private final Map<hudson.model.Result, Result> lookup = new HashMap();
    {
        lookup.put(SUCCESS, Result.SUCCESS);
        lookup.put(FAILURE, Result.FAILURE);
        lookup.put(UNSTABLE, Result.ERROR);
        lookup.put(NOT_BUILT, Result.ERROR);
        lookup.put(ABORTED, Result.ERROR);
    }

    public Result result(Run run) {
        hudson.model.Result result = run.getResult();
        if (!lookup.containsKey(result)) return Result.ERROR;
        return lookup.get(result);
    }
}
