package leapstream.scoreboard.pylons.score.ui.comp;

import au.net.netstorm.boost.spider.api.lifecycle.Constructable;
import leapstream.scoreboard.pylons.score.ui.lf.Colors;

import java.awt.Color;

public final class DefaultDialColors implements DialColors, Constructable {
    private Color buildingfg;
    private Color quietfg;
    private Color goodbg;
    private Color badbg;
    private Color flashbg;
    Colors colors;

    public void constructor() {
        buildingfg = colors.get("dial.active.building.fg");
        quietfg = colors.get("dial.active.quiet.fg");
        goodbg = colors.get("dial.active.good.bg");
        badbg = colors.get("dial.active.bad.bg");
        flashbg = colors.get("dial.active.flash.bg");
    }

    public Color buildingfg() {
        return buildingfg;
    }

    public Color quietfg() {
        return quietfg;
    }

    public Color goodbg() {
        return goodbg;
    }

    public Color badbg() {
        return badbg;
    }

    public Color flashbg() {
        return flashbg;
    }
}
