package leapstream.scoreboard.alien.ui.audio.wav;

import leapstream.scoreboard.edge.java.net.URL;
import leapstream.scoreboard.edge.javax.sound.sampled.AudioInputStream;
import leapstream.scoreboard.edge.javax.sound.sampled.AudioFormat;
import leapstream.scoreboard.edge.javax.sound.sampled.SourceDataLine;
import leapstream.scoreboard.edge.javax.sound.sampled.DataLine;
import leapstream.scoreboard.edge.javax.sound.sampled.Line;
import leapstream.scoreboard.edge.javax.sound.sampled.AudioSystemStatic;
import leapstream.scoreboard.alien.ui.audio.core.Playable;
import leapstream.scoreboard.alien.ui.audio.wav.Streama;
import au.net.netstorm.boost.bullet.scalpel.core.Edges;
import au.net.netstorm.boost.spider.api.runtime.Nu;

public class WavPlayable implements Playable {
    private URL wav;
    AudioSystemStatic system;
    Streama streama;
    Edges edges;
    Nu nu;

    public WavPlayable(URL wav) {
        this.wav = wav;
    }

    public void play() {
        AudioInputStream in = system.getAudioInputStream(wav);
        AudioFormat format = in.getFormat();
        SourceDataLine line = line(format);
        streama.stream(in, line);
    }

    private SourceDataLine line(AudioFormat format) {
        DataLine.Info info = nu.nu(DataLine.Info.class, javax.sound.sampled.SourceDataLine.class, format);
        Line line = system.getLine(info);
        return edges.cast(SourceDataLine.class, line);
    }
}
