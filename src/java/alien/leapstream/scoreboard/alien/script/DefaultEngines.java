package leapstream.scoreboard.alien.script;

import leapstream.scoreboard.alien.io.file.Paths;
import leapstream.scoreboard.edge.java.net.URL;
import leapstream.scoreboard.edge.javax.script.ScriptEngine;
import leapstream.scoreboard.edge.javax.script.ScriptEngineManager;

public final class DefaultEngines implements Engines {
    ScriptEngineManager manager;
    Paths paths;

    public ScriptEngine byName(String name) {
        return manager.getEngineByName(name);
    }

    public ScriptEngine byExt(URL url) {
        String path = url.getPath();
        String ext = paths.extension(path);
        return manager.getEngineByExtension(ext);
    }
}
