package leapstream.scoreboard.alien.io.stream;

import leapstream.scoreboard.edge.java.io.InputStream;

public interface FromInputStream<T> {
    T run(InputStream in);
}
