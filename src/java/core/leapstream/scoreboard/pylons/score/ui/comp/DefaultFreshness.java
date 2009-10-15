package leapstream.scoreboard.pylons.score.ui.comp;

import au.net.netstorm.boost.bullet.roughly.Roughly;
import au.net.netstorm.boost.bullet.time.core.Duration;
import au.net.netstorm.boost.bullet.time.core.TimeFactory;
import au.net.netstorm.boost.bullet.time.core.TimePoint;
import au.net.netstorm.boost.bullet.time.core.TimeRange;
import au.net.netstorm.boost.spider.api.lifecycle.Constructable;
import leapstream.scoreboard.alien.ui.core.Widget;
import leapstream.scoreboard.alien.ui.swing.pear.Label;
import leapstream.scoreboard.core.model.Score;
import leapstream.scoreboard.core.model.Status;
import leapstream.scoreboard.pylons.score.ui.lf.Colors;

import javax.swing.JComponent;
import java.awt.Color;

public final class DefaultFreshness implements Widget<Freshness>, Freshness, Constructable {
    private Color fg;
    private Color bg;
    TimeFactory times;
    Roughly roughly;
    Colors colors;
    Label label;

    public void constructor() {
        fg = colors.get("freshness.active.fg");
        bg = colors.get("freshness.active.bg");
        colors();
    }

    public Freshness control() {
        return this;
    }

    public JComponent ui() {
        return label.ui();
    }

    public void freshness(Score score) {
        Duration duration = calculate(score);
        String freshness = roughly.is(duration);
        label.text(freshness);
    }

    private Duration calculate(Score score) {
        TimePoint reference = score.timestamp();
        Status status = score.status();
        TimePoint since = status.since();
        TimeRange range = times.range(since, reference);
        return range.duration();
    }

    private void colors() {
        label.fg(fg);
        label.bg(bg);
    }
}
