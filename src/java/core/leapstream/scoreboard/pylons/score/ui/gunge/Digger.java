package leapstream.scoreboard.pylons.score.ui.gunge;

import leapstream.scoreboard.pylons.score.ui.comp.Dial;
import leapstream.scoreboard.pylons.score.ui.comp.Freshness;
import leapstream.scoreboard.pylons.score.ui.comp.Pegs;
import leapstream.scoreboard.pylons.score.ui.comp.Status;
import leapstream.scoreboard.pylons.score.ui.comp.Title;
import leapstream.scoreboard.pylons.score.ui.core.ScoreTile;

public interface Digger {
    Freshness freshness(ScoreTile tile);

    Dial dial(ScoreTile tile);

    Title title(ScoreTile tile);

    Status status(ScoreTile tile);

    Pegs pegs(ScoreTile tile);
}
