package leapstream.scoreboard.pylons.image.core;

import au.net.netstorm.boost.spider.api.config.web.Web;
import au.net.netstorm.boost.spider.api.config.wire.Wire;
import leapstream.scoreboard.pylons.image.push.HubImagePusher;
import leapstream.scoreboard.pylons.image.push.ImagePusher;
import leapstream.scoreboard.pylons.image.push.UiImagePusher;

public final class ImageWeb implements Web {
    Wire wire;

    public void web() {
        wire.cls(HubImagePusher.class).to(ImagePusher.class);
        wire.cls(UiImagePusher.class).to(ImagePusher.class, "ui");
    }
}
