package leapstream.scoreboard.warts.providers.cruise.transforms;

import net.sourceforge.cruisecontrol.dashboard.Build;

import java.util.List;

import leapstream.scoreboard.core.model.Score;

public interface CruiseScore {
    Score score(Build build, List<Build> builds);
}
