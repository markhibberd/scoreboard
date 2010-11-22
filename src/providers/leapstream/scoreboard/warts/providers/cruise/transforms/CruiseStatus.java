package leapstream.scoreboard.warts.providers.cruise.transforms;

import leapstream.scoreboard.warts.providers.model.Status;
import net.sourceforge.cruisecontrol.dashboard.Build;

public interface CruiseStatus {
    Status status(Build build);
}
