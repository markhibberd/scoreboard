package leapstream.scoreboard.pylons.score.push;

import au.net.netstorm.boost.spider.api.lifecycle.Constructable;
import leapstream.scoreboard.core.model.Score;
// FIX 1531 Feb 6, 2009 Hubbize.

// FIX 2950 Feb 16, 2009 Sort out Scoreboard Hub.
public final class HubScorePusher implements ScorePusher, Constructable {
    private ScorePusher[] pushers;
    ScorePusher state;
    ScorePusher ui;
    ScorePusher audio;
    ScorePusher log;

    public void constructor() {
        pushers = new ScorePusher[]{state, ui, audio, log};
    }

    public void push(Score score) {
        for (ScorePusher pusher : pushers) pusher.push(score);
    }

    public void fail(Throwable t) {
        for (ScorePusher pusher : pushers) pusher.fail(t);
    }
}
