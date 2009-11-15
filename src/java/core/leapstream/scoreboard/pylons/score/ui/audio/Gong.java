package leapstream.scoreboard.pylons.score.ui.audio;

import leapstream.scoreboard.edge.java.net.URL;

public interface Gong {
    void bang(URL wav, String msg);
}
