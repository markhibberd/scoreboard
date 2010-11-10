package leapstream.scoreboard.core.entry;

import au.net.netstorm.boost.gunge.array.ArrayMaestro;
import leapstream.scoreboard.core.config.script.Configurator;
import leapstream.scoreboard.core.config.script.ConfiguratorLibraries;
import leapstream.scoreboard.core.config.script.ExtensionMaster;
import leapstream.scoreboard.core.gunge.Urler;
import leapstream.scoreboard.edge.java.net.URL;

import java.util.ArrayList;
import java.util.List;

public class DefaultScoreboardArguments implements ScoreboardArguments {
    ConfiguratorLibraries libraries;
    ExtensionMaster extensions;
    Configurator configurator;
    ArrayMaestro arrays;
    Urler urls;

    public void process(String[] args) {
        List<String> configs = new ArrayList<String>();
        for (int i = 0; i < args.length; i++)
            if (isLib(args[i]) && i + 1 < args.length)
                library(args[++i]);
            else
                configs.add(args[i]);
        configs(configs);
    }

    private void configs(List<String> configs) {
        String[] c = arrays.array(configs, String.class);
        configurator.config(c);
    }

    private boolean isLib(String arg) {
        return arg.equals("--lib") || arg.equals("-l");
    }

    private void library(String lib) {
        String ext = extensions.extension(lib);
        URL url = urls.get(lib);
        libraries.add(ext, url);
    }
}
