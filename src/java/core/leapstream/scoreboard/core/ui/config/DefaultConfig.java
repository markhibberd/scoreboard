package leapstream.scoreboard.core.ui.config;

import au.net.netstorm.boost.gunge.optional.Optional;
import leapstream.scoreboard.alien.ui.dialog.InputDialog;
import leapstream.scoreboard.core.config.Configurator;

public final class DefaultConfig implements Config {
    Configurator configurator;
    InputDialog dialog;

    public void get() {
        Optional<String> optional = dialog.dialog("config url: ");
        if (!optional.isSet()) return;
        String url = optional.get();
        configurator.config(url);
    }
}
