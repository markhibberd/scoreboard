package leapstream.scoreboard.core.ui.widgets;

import au.net.netstorm.boost.spider.api.runtime.Impl;
import leapstream.scoreboard.alien.ui.gunge.border.Borders;
import leapstream.scoreboard.alien.ui.swing.pear.Panel;

import javax.swing.JComponent;
import javax.swing.border.Border;
import java.util.List;

public final class DefaultNavigableTiles implements NavigableTiles {
    List<JComponent> components;
    Borders borders;
    Impl impl;

    public JComponent wrap(JComponent c) {
        Panel result = impl.impl(Panel.class);
        result.add(c);
        components.add(result);
        return result;
    }

    public void select(int x) {
        for (JComponent c : cs()) borderise(c, 40);
        JComponent selected = components.get(x);
        borderise(selected, 0);
    }

    public void reset() {
        for (JComponent c : cs()) borderise(c, 0);
    }

    // FIX 1531 Dec 4, 2008 Hook in these methods ... or lose.
    public void activate() {
    }

    public void deactivate() {
    }

    public int num() {
        return components.size();
    }

    private void borderise(JComponent c, int i) {
        // FIX 1531 Dec 4, 2008 Remove.
        Border border = borders.border(i, 0);
        c.setBorder(border);
    }

    private JComponent[] cs() {
        return components.toArray(new JComponent[]{});
    }
}
