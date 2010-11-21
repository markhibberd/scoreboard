package leapstream.scoreboard.legacy.ui.config;

import au.net.netstorm.boost.gunge.optional.Optional;
import leapstream.scoreboard.legacy.ui.dialog.InputDialog;
import leapstream.scoreboard.legacy.config.script.Configurator;

public final class DefaultConfigPrompt implements ConfigPrompt {
    Configurator configurator;
    InputDialog dialog;

    public void get() {
        Optional<String> optional = dialog.dialog("config url: ");
        if (!optional.isSet()) return;
        String url = optional.get();
        configurator.config(url);
    }
}
