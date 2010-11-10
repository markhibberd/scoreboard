package leapstream.scoreboard.alien.ui.audio.core;

import leapstream.scoreboard.edge.java.net.URL;

public interface Playables {
    Playable say(String msg);
    Playable play(URL wav);
    Playable sequential(Playable... playables);
}
