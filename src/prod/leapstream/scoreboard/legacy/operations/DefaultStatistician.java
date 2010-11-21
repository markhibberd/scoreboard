package leapstream.scoreboard.legacy.operations;

import leapstream.scoreboard.legacy.model.Stati;
import static leapstream.scoreboard.legacy.model.Stati.BUILDING;
import static leapstream.scoreboard.legacy.model.Stati.QUEUED;
import leapstream.scoreboard.legacy.model.Status;

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
