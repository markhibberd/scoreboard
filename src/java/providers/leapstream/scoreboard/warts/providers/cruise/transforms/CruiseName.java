package leapstream.scoreboard.warts.providers.cruise.transforms;

import net.sourceforge.cruisecontrol.dashboard.Build;
import leapstream.scoreboard.core.model.Name;

public interface CruiseName {
    Name name(Build build);
}
