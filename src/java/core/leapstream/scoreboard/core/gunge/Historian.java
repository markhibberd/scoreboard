package leapstream.scoreboard.core.gunge;

import leapstream.scoreboard.core.model.History;
import leapstream.scoreboard.core.model.Id;

public interface Historian {
    Id last(History history);
    int count(History history);
    boolean good(History history);
}
