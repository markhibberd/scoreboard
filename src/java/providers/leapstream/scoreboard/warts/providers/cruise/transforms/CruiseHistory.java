package leapstream.scoreboard.warts.providers.cruise.transforms;

import net.sourceforge.cruisecontrol.dashboard.Build;

import java.util.List;

import leapstream.scoreboard.core.model.History;

public interface CruiseHistory {
    History history(List<Build> builds);
}
