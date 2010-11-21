package leapstream.scoreboard.legacy.script;

import leapstream.scoreboard.legacy.edge.java.net.URL;
import leapstream.scoreboard.legacy.edge.javax.script.ScriptEngine;

public interface Engines {
    ScriptEngine byName(String name);
    ScriptEngine byExt(URL url);
}
