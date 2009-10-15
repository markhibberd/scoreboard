package leapstream.scoreboard.alien.ui.audio;

import leapstream.scoreboard.edge.javax.sound.sampled.AudioFormat;
import leapstream.scoreboard.edge.javax.sound.sampled.AudioInputStream;
import leapstream.scoreboard.edge.javax.sound.sampled.SourceDataLine;

public final class SafeStreama implements Streama {
    Streama delegate;

    public void stream(AudioInputStream in, SourceDataLine line) {
        try {
            open(in, line);
            delegate.stream(in, line);
        } finally {
            close(line);
        }
    }

    private void open(AudioInputStream in, SourceDataLine line) {
        AudioFormat format = in.getFormat();
        line.open(format);
        line.start();
    }

    private void close(SourceDataLine line) {
        line.drain();
        line.close();
    }
}
