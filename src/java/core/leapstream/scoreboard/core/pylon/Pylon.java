package leapstream.scoreboard.core.pylon;

import leapstream.scoreboard.alien.ui.core.Ui;
import leapstream.scoreboard.core.model.Name;
 
public interface Pylon {
    Name name();
    boolean mandatory();
    Ui view();
}
