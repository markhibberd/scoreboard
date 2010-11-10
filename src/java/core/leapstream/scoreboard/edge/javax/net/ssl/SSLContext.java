package leapstream.scoreboard.edge.javax.net.ssl;

import au.net.netstorm.boost.bullet.scalpel.core.Edge;

import javax.net.ssl.KeyManager;
import javax.net.ssl.TrustManager;
import java.security.SecureRandom;

public interface SSLContext extends Edge {
    SSLSocketFactory getSocketFactory();
    void init(KeyManager[] managers, TrustManager[] tm, SecureRandom random);
}
