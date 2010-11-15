package leapstream.scoreboard.core.pylon;

import leapstream.scoreboard.alien.ui.core.Ui;
import leapstream.scoreboard.legacy.model.Name;
 
public interface PylonX {
    Name name();
    boolean mandatory();
    Ui view();
}
