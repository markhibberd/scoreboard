package leapstream.scoreboard.legacy.pylon;

import leapstream.scoreboard.legacy.ui.core.Ui;
import leapstream.scoreboard.legacy.model.Name;
 
public interface PylonX {
    Name name();
    boolean mandatory();
    Ui view();
}
