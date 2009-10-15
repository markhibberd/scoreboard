package leapstream.scoreboard.alien.ui.gunge.image;

import au.net.netstorm.boost.bullet.incredibles.core.Weaken;
import leapstream.scoreboard.alien.ui.core.Widget;
import leapstream.scoreboard.alien.ui.swing.pear.Label;

import javax.swing.ImageIcon;
import javax.swing.JComponent;

// FIX 244 Getting access to Widget<Image> is difficult, rethink.
public final class DefaultImage implements Image, Widget<Image> {
    Weaken weaken;
    Label label;

    public void set(ImageData data) {
        byte[] bytes = weaken.w(data);
        ImageIcon image = new ScalableImageIcon(bytes);
        label.icon(image);
    }

    public Image control() {
        return this;
    }

    public JComponent ui() {
        return label.ui();
    }
}
