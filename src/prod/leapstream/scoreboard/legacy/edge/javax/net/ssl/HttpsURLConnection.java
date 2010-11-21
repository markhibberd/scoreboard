package leapstream.scoreboard.legacy.edge.javax.net.ssl;

import leapstream.scoreboard.legacy.edge.java.net.URLConnection;

public interface HttpsURLConnection extends URLConnection {
    void setSSLSocketFactory(SSLSocketFactory factory);
}
