package leapstream.scoreboard.pylons.score.ui.lf;

import java.awt.Color;

public final class DefaultColors implements Colors {
    PropDefs props;

    public Color get(String key) {
        String s = props.get(key);
        // FIX 1596 Dec 30, 2008 Sort transparency. This is dodge.
        boolean hasalpha = s.length() > 6;
        int v = Integer.parseInt(s, 16);
        return new Color(v, hasalpha);
    }
}
