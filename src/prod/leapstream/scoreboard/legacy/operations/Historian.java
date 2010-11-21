package leapstream.scoreboard.legacy.operations;

import leapstream.scoreboard.legacy.model.History;
import leapstream.scoreboard.legacy.model.Id;

public interface Historian {
    Id last(History history);
    int count(History history);
    boolean good(History history);
}
