package leapstream.scoreboard.alien.ioc;

import au.net.netstorm.boost.spider.api.config.web.Web;
import au.net.netstorm.boost.spider.api.config.wire.Wire;
import leapstream.scoreboard.alien.net.core.SocketMaster;
import leapstream.scoreboard.alien.net.protocol.http.HttpSocketMaster;
import leapstream.scoreboard.alien.net.protocol.https.HttpsSocketMaster;
import leapstream.scoreboard.alien.net.ssl.NaiveTrustManager;
import leapstream.scoreboard.alien.net.url.DefaultUrlGetter;
import leapstream.scoreboard.alien.net.url.StringUrlSlurper;
import leapstream.scoreboard.alien.net.url.UrlSlurper;

import javax.net.ssl.TrustManager;

public final class AlienWeb implements Web {
    Wire wire;

    public void web() {
        net();
    }

    private void net() {
        wire.cls(NaiveTrustManager.class).to(TrustManager.class);
        wire.cls(HttpSocketMaster.class).to(SocketMaster.class, DefaultUrlGetter.class, "http");
        wire.cls(HttpsSocketMaster.class).to(SocketMaster.class, DefaultUrlGetter.class, "https");
        wire.cls(StringUrlSlurper.class).to(UrlSlurper.class);
    }
}
