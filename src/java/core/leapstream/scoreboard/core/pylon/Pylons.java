package leapstream.scoreboard.core.pylon;

import java.util.List;

public interface Pylons extends Iterable<Pylon> {
    void add(Pylon pylon);
    // FIX LIFECYCLE Elliminate these. Drive this data structure deeper and they should not be needed.
    List<Pylon> mandatory();
    List<Pylon> optional();
}
