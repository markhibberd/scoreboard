package leapstream.scoreboard.core.ui.fail;

import au.net.netstorm.boost.bullet.incredibles.core.Weaken;
import au.net.netstorm.boost.spider.api.lifecycle.Constructable;
import au.net.netstorm.boost.spider.api.runtime.Impl;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import leapstream.scoreboard.alien.ui.core.Widget;
import leapstream.scoreboard.alien.ui.gunge.border.Borders;
import leapstream.scoreboard.alien.ui.gunge.image.Image;
import leapstream.scoreboard.alien.ui.gunge.image.ImageData;
import leapstream.scoreboard.alien.ui.gunge.layout.OneSixthLayoutManager;
import leapstream.scoreboard.alien.ui.swing.pear.Label;
import leapstream.scoreboard.alien.ui.swing.pear.Panel;
import leapstream.scoreboard.core.bits.Bits;
import leapstream.scoreboard.core.images.ImageGrabber;
import leapstream.scoreboard.legacy.model.ImageLocation;
import leapstream.scoreboard.legacy.model.Name;
import leapstream.scoreboard.edge.java.net.URL;

import javax.swing.JComponent;
import javax.swing.border.Border;
import static java.awt.Color.BLACK;
import static java.awt.Color.WHITE;
import java.awt.Component;
import java.awt.LayoutManager;

public class DefaultJollyRoger implements JollyRoger, Constructable {
    ImageGrabber images;
    Borders borders;
    Weaken weaken;
    Panel panel;
    Panel crossbones;
    Label label;
    Image image;
    Bits bits;
    Impl impl;
    Nu nu;

    public void constructor() {
        borders();
        name();
        crossbones();
        layout();
        panel.add(crossbones);
        panel.add(label.ui());

    }

    public JComponent ui() {
        return panel;
    }

    public void set(Name name) {
        String s = weaken.w(name);
        label.text(s);
    }

    private void borders() {
        Border border = borders.border(2, 1);
        panel.setBorder(border);
    }

    private void name() {
        label.fg(WHITE);
        label.bg(BLACK);
    }

    private void crossbones() {
        URL url = bits.url("Jolly-roger.png");
        ImageLocation location = nu.nu(ImageLocation.class, url);
        ImageData data = images.grab(location);
        image.set(data);
        // FIX LIFECYCLE Sort out this widget crap. It is totally smashed.
        Component comp = ((Widget<Image>) image).ui();
        comp.setBackground(BLACK);
        crossbones.add(comp);
    }

    private void layout() {
        LayoutManager layout = impl.impl(OneSixthLayoutManager.class, crossbones, label.ui());
        panel.setLayout(layout);
    }
}
