package leapstream.scoreboard.legacy.edge.javax.sound.sampled;

import au.net.netstorm.boost.bullet.scalpel.core.Edge;
import leapstream.scoreboard.legacy.edge.java.net.URL;

public interface AudioSystemStatic extends Edge {
    AudioInputStream getAudioInputStream(URL url);
    Line getLine(Line.Info info);
}
