package leapstream.scoreboard.edge.javax.sound.sampled;

import au.net.netstorm.boost.bullet.scalpel.core.Edge;
import leapstream.scoreboard.edge.java.net.URL;

public interface AudioSystemStatic extends Edge {
    AudioInputStream getAudioInputStream(URL url);
    Line getLine(Line.Info info);
}
