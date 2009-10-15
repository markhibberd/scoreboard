package leapstream.scoreboard.edge.javax.sound.sampled;

import leapstream.scoreboard.edge.java.io.InputStream;

public interface AudioInputStream extends InputStream {
    AudioFormat getFormat();
}
