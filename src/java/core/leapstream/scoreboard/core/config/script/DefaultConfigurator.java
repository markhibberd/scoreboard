package leapstream.scoreboard.core.config.script;

import leapstream.scoreboard.core.gunge.Urler;
import leapstream.scoreboard.edge.java.net.URL;

public final class DefaultConfigurator implements Configurator {
    ConfiguratorFu fu;
    ConfiguratorLibraries libraries;
    ExtensionMaster extensions;
    Urler urler;

    public void config(String... strings) {
        if (strings.length == 0)
            return;
        String ext = extensions.extension(strings);
        URL[] libs = libraries.get(ext);
        URL[] configs = urler.get(strings);
        fu.config(libs, configs);
    }

}
