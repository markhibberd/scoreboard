package leapstream.scoreboard.edge.javax.net.ssl;

import leapstream.scoreboard.edge.java.net.URLConnection;

public interface HttpsURLConnection extends URLConnection {
    void setSSLSocketFactory(SSLSocketFactory factory);
}
