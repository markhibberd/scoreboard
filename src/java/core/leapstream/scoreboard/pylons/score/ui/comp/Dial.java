package leapstream.scoreboard.pylons.score.ui.comp;

import leapstream.scoreboard.core.model.History;
import leapstream.scoreboard.core.model.Status;

public interface Dial {
    // FIX 244 History is used for colouring and number displayed.
    // FIX 244 Status is used for colouring (RED, GREEN, FLASHING RED).
    void dial(History history, Status status);

    // FIX 244 Move out of here.  Short term visual failure cue.
    void bomb(Throwable t);
}
