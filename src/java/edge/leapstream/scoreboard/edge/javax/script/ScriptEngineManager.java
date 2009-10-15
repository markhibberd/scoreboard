package leapstream.scoreboard.edge.javax.script;

import au.net.netstorm.boost.bullet.scalpel.core.Edge;

public interface ScriptEngineManager extends Edge {
    ScriptEngine getEngineByName(String name);
    ScriptEngine getEngineByExtension(String ext);
}
