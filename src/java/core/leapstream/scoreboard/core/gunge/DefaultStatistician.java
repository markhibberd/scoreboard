package leapstream.scoreboard.core.gunge;

import leapstream.scoreboard.core.model.Stati;
import static leapstream.scoreboard.core.model.Stati.BUILDING;
import static leapstream.scoreboard.core.model.Stati.QUEUED;
import leapstream.scoreboard.core.model.Status;

public final class DefaultStatistician implements Statistician {
    public boolean building(Status status) {
        return is(status, BUILDING);
    }

    public boolean queued(Status status) {
        return is(status, QUEUED);
    }

    private boolean is(Status status, Stati is) {
        Stati stati = status.is();
        return stati == is;
    }
}
