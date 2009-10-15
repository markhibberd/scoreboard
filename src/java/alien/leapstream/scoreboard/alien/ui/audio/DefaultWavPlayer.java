package leapstream.scoreboard.alien.ui.audio;

import au.net.netstorm.boost.bullet.primordial.Primordial;
import au.net.netstorm.boost.bullet.scalpel.core.Edges;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import leapstream.scoreboard.edge.java.net.URL;
import leapstream.scoreboard.edge.javax.sound.sampled.AudioFormat;
import leapstream.scoreboard.edge.javax.sound.sampled.AudioInputStream;
import leapstream.scoreboard.edge.javax.sound.sampled.AudioSystemStatic;
import leapstream.scoreboard.edge.javax.sound.sampled.DataLine;
import leapstream.scoreboard.edge.javax.sound.sampled.Line;
import leapstream.scoreboard.edge.javax.sound.sampled.SourceDataLine;

public class DefaultWavPlayer extends Primordial implements WavPlayer {
    AudioSystemStatic system;
    Streama streama;
    Edges edges;
    Nu nu;

    public void play(URL wav) {
        // FIX 826 Get rid of in favour of lock layer.
        synchronized (AudioLock.class) {
            locked(wav);
        }
    }

    private void locked(URL wav) {
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
