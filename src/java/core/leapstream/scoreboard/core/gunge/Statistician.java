package leapstream.scoreboard.core.gunge;

import leapstream.scoreboard.legacy.model.Status;

public interface Statistician {
    boolean building(Status status);
    boolean queued(Status status);
}
