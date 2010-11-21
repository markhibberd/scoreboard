package leapstream.scoreboard.legacy.edge.java.awt;

import au.net.netstorm.boost.bullet.scalpel.core.Edge;
import leapstream.scoreboard.legacy.edge.java.io.InputStream;

import java.awt.Font;

public interface FontStatic extends Edge {
    Font createFont(int font, InputStream is);
}
