package leapstream.scoreboard.pylons.image.ui.core;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import leapstream.scoreboard.alien.ui.core.Widget;
import leapstream.scoreboard.alien.ui.gunge.border.Borders;
import leapstream.scoreboard.alien.ui.gunge.image.Image;
import leapstream.scoreboard.alien.ui.swing.pear.Panel;

import javax.swing.JComponent;
import javax.swing.border.Border;
import java.awt.Component;
import java.awt.Container;

// FIX 244 This needs to be tidied up. A lot of generic functionality required by all tiles.
public final class DefaultImageTileWidgets implements ImageTileWidgets {
    Borders borders;
    Nu nu;

    // FIX 244 Dupe with DefaultWirer, pull out the panel and border stuff.
    public Widget<ImageTile> nu() {
        Image image = nu.nu(Image.class);
        ImageTile tile = nu.nu(ImageTile.class, image);
        Widget<Image> widget = tile.image();
        Component component = widget.ui();
        Panel panel = new Panel();
        borders(panel);
        panel.add(component);
        return nu.nu(Widget.class, tile, panel);
    }

    // FIX 1915 Dec 23, 2008 Remove dupe for borders.  See DefaultLayout.  No border exists for Status tiles but should be free.
    // FIX 244 This makes it consistent with the score tiles. Do we want a consistent look and feel across tiles, if so, pull this out, otherwise toast this.
    private void borders(Container c) {
        Border border = borders.border(2, 1);
        ((JComponent) c).setBorder(border);
    }
}
