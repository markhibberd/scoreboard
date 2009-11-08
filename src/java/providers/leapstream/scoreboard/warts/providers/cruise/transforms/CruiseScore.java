package leapstream.scoreboard.warts.providers.cruise.transforms;

import leapstream.scoreboard.core.model.Score;
import net.sourceforge.cruisecontrol.dashboard.Build;

import java.util.List;

public interface CruiseScore {
    Score score(Build build, List<Build> builds);
}
