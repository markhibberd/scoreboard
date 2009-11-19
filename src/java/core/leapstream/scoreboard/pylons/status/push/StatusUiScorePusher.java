package leapstream.scoreboard.pylons.status.push;

import leapstream.scoreboard.alien.ui.core.Widget;
import leapstream.scoreboard.core.model.History;
import leapstream.scoreboard.core.model.Score;
import leapstream.scoreboard.core.model.Status;
import leapstream.scoreboard.pylons.score.push.ScorePusher;
import leapstream.scoreboard.pylons.score.ui.comp.Dial;
import leapstream.scoreboard.pylons.score.ui.gunge.Digger;
import leapstream.scoreboard.pylons.status.ui.core.StatusTile;

// FIX AQUEDUCT Rip out farmer gumf.
// FIX 1915 Dec 23, 2008 Dupe with PeggedUiScorePusher.
// FIX 1915 Dec 23, 2008 Does Digger need to be more generic or does it suggest other changes.
public final class StatusUiScorePusher implements ScorePusher {
    StatusTile tile;
    Digger digger;

    public void push(Score score) {
        Dial dial = dial();
        History history = score.history();
        Status status = score.status();
        dial.dial(history, status);
    }

    private Dial dial() {
        Widget<Dial> widget = tile.dial();
        return widget.control();
    }
}
