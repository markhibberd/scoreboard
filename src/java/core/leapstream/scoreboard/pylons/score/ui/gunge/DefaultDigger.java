package leapstream.scoreboard.pylons.score.ui.gunge;

import leapstream.scoreboard.alien.ui.core.Widget;
import leapstream.scoreboard.pylons.score.ui.comp.Dial;
import leapstream.scoreboard.pylons.score.ui.comp.Freshness;
import leapstream.scoreboard.pylons.score.ui.comp.Pegs;
import leapstream.scoreboard.pylons.score.ui.comp.Status;
import leapstream.scoreboard.pylons.score.ui.comp.Title;
import leapstream.scoreboard.pylons.score.ui.core.ScoreTile;

public final class DefaultDigger implements Digger {
    public Freshness freshness(ScoreTile tile) {
        Widget<Freshness> widget = tile.freshness();
        return widget.control();
    }

    public Dial dial(ScoreTile tile) {
        Widget<Dial> widget = tile.dial();
        return widget.control();
    }

    public Title title(ScoreTile tile) {
        Widget<Title> widget = tile.title();
        return widget.control();
    }

    public Status status(ScoreTile tile) {
        Widget<Status> widget = tile.status();
        return widget.control();
    }

    public Pegs pegs(ScoreTile tile) {
        Widget<Pegs> widget = tile.pegs();
        return widget.control();
    }
}
