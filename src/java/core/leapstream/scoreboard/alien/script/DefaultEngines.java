package leapstream.scoreboard.alien.script;

import bsh.engine.BshScriptEngineFactory;
import com.sun.phobos.script.javascript.RhinoScriptEngineFactory;
import leapstream.scoreboard.alien.io.file.Paths;
import leapstream.scoreboard.edge.java.net.URL;
import leapstream.scoreboard.edge.javax.script.ScriptEngine;
import leapstream.scoreboard.edge.javax.script.ScriptEngineManager;

public final class DefaultEngines implements Engines {
    ScriptEngineManager manager;
    Paths paths;

    public ScriptEngine byName(String name) {
        manager.registerEngineName("scoreboard.js", new RhinoScriptEngineFactory());
        manager.registerEngineName("scoreboard.bsh", new BshScriptEngineFactory());
        return manager.getEngineByName(name);
    }

    // this is intentionally reimplemented to ensure we do not pick up the embedded sub engine, which is riddled with bugs.
    public ScriptEngine byExt(URL url) {
        String path = url.getPath();
        String ext = paths.extension(path);
        if (ext.equals("js"))
            return byName("scoreboard.js");
        else if (ext.equals("bsh"))
            return byName("scoreboard.bsh");
        throw new IllegalStateException("Unsupported file format: " + url);
    }
}
