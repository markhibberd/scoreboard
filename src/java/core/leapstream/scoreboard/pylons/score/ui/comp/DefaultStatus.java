package leapstream.scoreboard.pylons.score.ui.comp;

import au.net.netstorm.boost.gunge.collection.StrictMap;
import au.net.netstorm.boost.spider.api.lifecycle.Constructable;
import leapstream.scoreboard.alien.ui.core.Widget;
import leapstream.scoreboard.alien.ui.swing.pear.Label;
import leapstream.scoreboard.core.model.Stati;
import static leapstream.scoreboard.core.model.Stati.BUILDING;
import static leapstream.scoreboard.core.model.Stati.DISABLED;
import static leapstream.scoreboard.core.model.Stati.ERRORED;
import static leapstream.scoreboard.core.model.Stati.QUEUED;
import static leapstream.scoreboard.core.model.Stati.WAITING;
import leapstream.scoreboard.pylons.score.ui.lf.Colors;

import javax.swing.JComponent;
import java.awt.Color;

public final class DefaultStatus implements Widget<Status>, Status, Constructable {
    // FIX 1915 Dec 24, 2008 Move this lovely map out.
    // FIX 1915 Dec 24, 2008 Add queued color to "Status Tile".
    StrictMap<Stati, Color> fg;
    StrictMap<Stati, Color> bg;
    Label label;
    Colors colors;

    public void constructor() {
        color(WAITING, "waiting");
        color(QUEUED, "queued");
        color(BUILDING, "building");
        color(DISABLED, "disabled");
        color(ERRORED, "error");
    }

    // FIX 244 Tidy this.
    public void status(leapstream.scoreboard.core.model.Status status) {
        Stati stati = status.is();
        foreground(stati);
        background(stati);
        label.text("" + stati);
    }

    public Status control() {
        return this;
    }

    public JComponent ui() {
        return label.ui();
    }

    private void foreground(Stati stati) {
        Color color = fg.get(stati);
        label.fg(color);
    }

    private void background(Stati stati) {
        Color color = bg.get(stati);
        label.bg(color);
    }

    private void color(Stati stati, String attribute) {
        color(fg, stati, attribute, "fg");
        color(bg, stati, attribute, "bg");
    }

    private void color(StrictMap<Stati, Color> colorage, Stati stati, String attribute, String type) {
        Color color = colors.get("status.active." + attribute + "." + type);
        colorage.put(stati, color);
    }
}
