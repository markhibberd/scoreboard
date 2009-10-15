package leapstream.scoreboard.pylons.image.push;

import leapstream.scoreboard.alien.ui.gunge.image.ImageData;

public final class HubImagePusher implements ImagePusher {
    ImagePusher ui;

    public void starting() {
        ui.starting();
    }

    public void push(ImageData image) {
        ui.push(image);
    }

    public void fail(Throwable t) {
        ui.fail(t);
    }
}
