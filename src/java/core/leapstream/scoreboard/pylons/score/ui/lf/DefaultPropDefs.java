package leapstream.scoreboard.pylons.score.ui.lf;

import au.net.netstorm.boost.gunge.collection.DefaultStrictMap;
import au.net.netstorm.boost.gunge.collection.StrictMap;

// FIX CONFIG Replace this with js. 
public final class DefaultPropDefs implements PropDefs {
    StrictMap<String, String> map = new DefaultStrictMap();

    {
        // FIX 1596 Dec 30, 2008 Sort transparent colours.
        add("board.bg", "40000000");
        add("title.active.fg", "FFFFFF");
        add("title.active.bg", "000000");
        add("pegs.active.bg", "000000");
        add("peg.active.good", "00AA00");
        add("peg.active.bad", "FF0000");
        add("peg.active.initial", "000000");
        add("dial.active.good.bg", "00FF00");
        add("dial.active.bad.bg", "FF0000");
        add("dial.active.flash.bg", "F3A600");
        add("dial.active.building.fg", "FFFFFF");
        add("dial.active.quiet.fg", "000000");
        add("status.active.waiting.fg", "FFFFFF");
        add("status.active.building.fg", "FFFFFF");
        add("status.active.queued.fg", "000000");
        add("status.active.disabled.fg", "000000");
        add("status.active.error.fg", "000000");
        add("status.active.waiting.bg", "000000");
        add("status.active.building.bg", "00AA00");
        add("status.active.queued.bg", "FFFF00");
        add("status.active.disabled.bg", "808080");
        add("status.active.error.bg", "FF0000");
        add("freshness.active.fg", "000000");
        add("freshness.active.bg", "FFFFFF");
    }

    public String get(String key) {
        return map.get(key);
    }

    private void add(String k, String v) {
        map.put(k, v);
    }
}
