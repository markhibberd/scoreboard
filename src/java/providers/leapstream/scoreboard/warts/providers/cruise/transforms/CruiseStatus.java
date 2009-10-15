package leapstream.scoreboard.warts.providers.cruise.transforms;

import net.sourceforge.cruisecontrol.dashboard.Build;
import leapstream.scoreboard.core.model.Status;

public interface CruiseStatus {
    Status status(Build build);
}
