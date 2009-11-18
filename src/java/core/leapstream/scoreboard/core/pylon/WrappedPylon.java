package leapstream.scoreboard.core.pylon;

import leapstream.scoreboard.core.model.Name;
import leapstream.scoreboard.alien.ui.core.Ui;

public class WrappedPylon implements Pylon {
    private Pylon delegate;
    private Ui ui;

    public WrappedPylon(Pylon delegate, Ui ui) {
        this.delegate = delegate;
        this.ui = ui;
    }

    public Name name() {
        return delegate.name();
    }

    public boolean mandatory() {
        return delegate.mandatory();
    }

    public Ui view() {
        return ui;
    }
}
