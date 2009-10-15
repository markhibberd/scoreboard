package leapstream.scoreboard.dead.spinner;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import leapstream.scoreboard.alien.ui.core.Widget;

public final class DefaultSpinnerWidgets implements SpinnerWidgets {
    private final Long interval = 77L;
    Nu nu;

    public Widget<Spinner> nu() {
        SpinPanel panel = new SpinPanel();
        Spinner spinner = nu.nu(Spinner.class, interval, panel);
        SpinnerRunnable runnable = new SpinnerRunnable(spinner);
        new Thread(runnable).start();
        return nu.nu(Widget.class, spinner, panel);
    }
}
