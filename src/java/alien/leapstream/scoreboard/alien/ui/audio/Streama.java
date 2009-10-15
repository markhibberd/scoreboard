package leapstream.scoreboard.alien.ui.audio;

import leapstream.scoreboard.edge.javax.sound.sampled.AudioInputStream;
import leapstream.scoreboard.edge.javax.sound.sampled.SourceDataLine;

public interface Streama {
    void stream(AudioInputStream in, SourceDataLine line);
}
