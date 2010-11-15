package leapstream.scoreboard.warts.providers.cruise.transforms;

import leapstream.scoreboard.legacy.model.Name;
import net.sourceforge.cruisecontrol.dashboard.Build;

public interface CruiseName {
    Name name(Build build);
}
