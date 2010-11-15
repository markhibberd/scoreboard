package leapstream.scoreboard.core.pylon;

import leapstream.scoreboard.legacy.model.Name;
import leapstream.scoreboard.alien.ui.core.Ui;

public class WrappedPylonX implements PylonX {
    private PylonX delegate;
    private Ui ui;

    public WrappedPylonX(PylonX delegate, Ui ui) {
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
