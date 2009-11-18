package leapstream.scoreboard.core.pylon;

import leapstream.scoreboard.alien.ui.core.Ui;
import leapstream.scoreboard.core.model.Name;

public class DefaultPylon implements Pylon {
    private boolean mandatory;
    private Ui view;
    private Name name;

    public DefaultPylon(Name name, Ui view, boolean mandatory) {
        this.name = name;
        this.view = view;
        this.mandatory = mandatory;
    }

    public Name name() {
        return name;
    }

    public boolean mandatory() {
        return mandatory;
    }

    public Ui view() {
        return view;
    }
}
