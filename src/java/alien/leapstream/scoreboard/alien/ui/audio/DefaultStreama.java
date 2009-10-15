package leapstream.scoreboard.alien.ui.audio;

import leapstream.scoreboard.edge.javax.sound.sampled.AudioInputStream;
import leapstream.scoreboard.edge.javax.sound.sampled.SourceDataLine;

public final class DefaultStreama implements Streama {
    private static final int EXTERNAL_BUFFER_SIZE = 524288; // 128Kb

    public void stream(AudioInputStream in, SourceDataLine line) {
        int read = 0;
        byte[] bytes = new byte[EXTERNAL_BUFFER_SIZE];
        while (read != -1) {
            read = in.read(bytes, 0, bytes.length);
            if (read >= 0) line.write(bytes, 0, read);
        }
    }
}
