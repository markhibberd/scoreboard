package leapstream.scoreboard.edge.java.net;

import au.net.netstorm.boost.bullet.scalpel.core.Edge;
import au.net.netstorm.boost.bullet.scalpel.core.Unedgable;
import leapstream.scoreboard.edge.java.io.InputStream;
import leapstream.scoreboard.edge.java.io.OutputStream;

public interface URLConnection extends Edge, Unedgable {
    OutputStream getOutputStream();
    InputStream getInputStream();
    void setRequestProperty(String key, String value);
    void setConnectTimeout(int timeout);
}
