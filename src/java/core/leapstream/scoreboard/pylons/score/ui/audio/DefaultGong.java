package leapstream.scoreboard.pylons.score.ui.audio;

import leapstream.scoreboard.edge.java.net.URL;
import leapstream.scoreboard.alien.ui.audio.core.Playables;
import leapstream.scoreboard.alien.ui.audio.core.Audio;
import leapstream.scoreboard.alien.ui.audio.core.Playable;

public class DefaultGong implements Gong {
    Playables playables;
    Audio audio;
    
    public void bang(URL wav, String msg) {
        Playable play = playables.play(wav);
        Playable say = playables.say(msg);
        Playable seq = playables.sequential(play, say);
        audio.play(seq);
    }
}
