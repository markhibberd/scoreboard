package leapstream.scoreboard.core.ui.config;

import leapstream.scoreboard.core.config.Configurator;
import leapstream.scoreboard.alien.ui.dialog.InputDialog;
import au.net.netstorm.boost.gunge.optional.Optional;

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
