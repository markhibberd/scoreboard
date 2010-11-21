package leapstream.scoreboard.warts.providers.cruise.transforms;

import leapstream.scoreboard.legacy.model.Status;
import net.sourceforge.cruisecontrol.dashboard.Build;

public interface CruiseStatus {
    Status status(Build build);
}
