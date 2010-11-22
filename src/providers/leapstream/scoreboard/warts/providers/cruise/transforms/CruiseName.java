package leapstream.scoreboard.warts.providers.cruise.transforms;

import leapstream.scoreboard.warts.providers.model.Name;
import net.sourceforge.cruisecontrol.dashboard.Build;

public interface CruiseName {
    Name name(Build build);
}
