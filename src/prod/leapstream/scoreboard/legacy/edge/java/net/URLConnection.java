package leapstream.scoreboard.legacy.edge.java.net;

import au.net.netstorm.boost.bullet.scalpel.core.Edge;
import au.net.netstorm.boost.bullet.scalpel.core.Unedgable;
import leapstream.scoreboard.legacy.edge.java.io.InputStream;
import leapstream.scoreboard.legacy.edge.java.io.OutputStream;

public interface URLConnection extends Edge, Unedgable {
    OutputStream getOutputStream();
    InputStream getInputStream();
    void setRequestProperty(String key, String value);
    void setConnectTimeout(int timeout);
}
