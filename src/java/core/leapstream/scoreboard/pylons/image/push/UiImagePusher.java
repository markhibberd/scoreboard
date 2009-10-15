package leapstream.scoreboard.pylons.image.push;

import leapstream.scoreboard.alien.ui.core.Widget;
import leapstream.scoreboard.alien.ui.gunge.image.Image;
import leapstream.scoreboard.alien.ui.gunge.image.ImageData;
import leapstream.scoreboard.pylons.image.ui.core.ImageTile;

public final class UiImagePusher implements ImagePusher {
    ImageTile tile;

    public void starting() {
    }

    public void push(ImageData image) {
        Widget<Image> widget = tile.image();
        Image i = widget.control();
        i.set(image);
    }

    public void fail(Throwable t) {
        // FIX 244 Complete.
    }
}
