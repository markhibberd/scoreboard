package leapstream.scoreboard.legacy.edge.javax.sound.sampled;

import leapstream.scoreboard.legacy.edge.java.io.InputStream;

public interface AudioInputStream extends InputStream {
    AudioFormat getFormat();
}
