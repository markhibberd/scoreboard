package leapstream.scoreboard.edge.java.awt;

import au.net.netstorm.boost.bullet.scalpel.core.Edge;
import leapstream.scoreboard.edge.java.io.InputStream;

import java.awt.Font;

public interface FontStatic extends Edge {
    Font createFont(int font, InputStream is);
}
