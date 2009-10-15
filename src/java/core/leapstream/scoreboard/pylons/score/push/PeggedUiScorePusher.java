package leapstream.scoreboard.pylons.score.push;

import leapstream.scoreboard.core.model.Build;
import leapstream.scoreboard.core.model.History;
import leapstream.scoreboard.core.model.Name;
import leapstream.scoreboard.core.model.Score;
import leapstream.scoreboard.pylons.score.ui.comp.Dial;
import leapstream.scoreboard.pylons.score.ui.comp.Freshness;
import leapstream.scoreboard.pylons.score.ui.comp.Pegs;
import leapstream.scoreboard.pylons.score.ui.comp.Status;
import leapstream.scoreboard.pylons.score.ui.comp.Title;
import leapstream.scoreboard.pylons.score.ui.core.ScoreTile;
import leapstream.scoreboard.pylons.score.ui.gunge.Digger;

public final class PeggedUiScorePusher implements ScorePusher {
    ScoreTile tile;
    Build build;
    Digger digger;

    public void starting() {
        title();
    }

    public void push(Score score) {
        dial(score);
        status(score);
        pegs(score);
        freshness(score);
    }

    public void fail(Throwable t) {
        Dial dial = digger.dial(tile);
        dial.bomb(t);
    }

    private void title() {
        Title title = digger.title(tile);
        Name name = build.name();
        title.title(name);
    }

    private void dial(Score score) {
        Dial dial = digger.dial(tile);
        History history = score.history();
        // FIX 244 Consider rename.
        leapstream.scoreboard.core.model.Status status = score.status(); // FIX 244 Try and resolve Status clash (see long package name).
        dial.dial(history, status);
    }

    private void status(Score score) {
        Status status = digger.status(tile);
        status.status(score.status());
    }

    private void pegs(Score score) {
        Pegs pegs = digger.pegs(tile);
        History history = score.history();
        pegs.history(history);
    }

    private void freshness(Score score) {
        Freshness freshness = digger.freshness(tile);
        freshness.freshness(score);
    }
}
