package leapstream.scoreboard.core.ui.key;

import leapstream.scoreboard.alien.ui.dialog.InputDialog;
import leapstream.scoreboard.core.config.Configurator;
import leapstream.scoreboard.core.ui.config.Config;

public class CHandler implements Handler {
    Config config;

    public void u() {
        config.get();
    }
}
