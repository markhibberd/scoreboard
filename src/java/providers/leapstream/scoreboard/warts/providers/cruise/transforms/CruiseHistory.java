package leapstream.scoreboard.warts.providers.cruise.transforms;

import leapstream.scoreboard.core.model.History;
import net.sourceforge.cruisecontrol.dashboard.Build;

import java.util.List;

public interface CruiseHistory {
    History history(List<Build> builds);
}
