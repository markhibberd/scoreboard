package leapstream.scoreboard.legacy.config.script;

import leapstream.scoreboard.legacy.operations.Urler;
import leapstream.scoreboard.legacy.edge.java.net.URL;

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
