package leapstream.scoreboard.legacy.toport.net.ssl;

import javax.net.ssl.X509TrustManager;
import java.security.cert.X509Certificate;
/*

Technique for accepting self-signed SSL certificate found here ...

"Accepting Self-Signed SSL Certificates in Java"

http://www.howardism.org/Technical/Java/SelfSignedCerts.html
http://java.sun.com/j2se/1.4.2/docs/guide/security/jsse/JSSERefGuide.html#TrustManager

*/

public class NaiveTrustManager implements X509TrustManager {
    public void checkClientTrusted(X509Certificate[] certs, String authType) {
    }

    public void checkServerTrusted(X509Certificate[] certs, String authType) {
    }

    public X509Certificate[] getAcceptedIssuers() {
        return null;
    }
}