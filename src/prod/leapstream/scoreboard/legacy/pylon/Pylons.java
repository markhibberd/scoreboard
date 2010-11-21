package leapstream.scoreboard.legacy.pylon;

import java.util.List;

public interface Pylons extends Iterable<PylonX> {
    void add(PylonX pylonX);
    // FIX LIFECYCLE Elliminate these. Drive this data structure deeper and they should not be needed.
    List<PylonX> mandatory();
    List<PylonX> optional();
}
