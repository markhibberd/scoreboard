package leapstream.scoreboard.alien.script;

import leapstream.scoreboard.edge.java.net.URL;
import leapstream.scoreboard.edge.javax.script.ScriptEngine;

import java.util.List;

public interface Engines {
    ScriptEngine byName(String name);
    ScriptEngine byExt(URL url);
}
