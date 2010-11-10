package leapstream.scoreboard.core.config.script;

import au.net.netstorm.boost.gunge.array.ArrayMaestro;
import au.net.netstorm.boost.gunge.collection.StrictMap;
import leapstream.scoreboard.edge.java.net.URL;

import java.util.ArrayList;
import java.util.List;

public class DefaultConfiguratorLibraries implements ConfiguratorLibraries {
    StrictMap<String, List<URL>> libs;
    ArrayMaestro arrays;

    public synchronized void add(String ext, URL url) {
        if (!libs.exists(ext))
            libs.put(ext, new ArrayList<URL>());
        List<URL> extlibs = libs.get(ext);
        extlibs.add(url);
    }

    public synchronized URL[] get(String ext) {
        if (!libs.exists(ext))
            return new URL[0];
        List<URL> extlibs = libs.get(ext);
        return arrays.array(extlibs, URL.class);
    }
}
