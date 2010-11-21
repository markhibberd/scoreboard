package leapstream.scoreboard.legacy.edge.javax.script;

import au.net.netstorm.boost.bullet.scalpel.core.Edge;

import javax.script.ScriptEngineFactory;

public interface ScriptEngineManager extends Edge {
    ScriptEngine getEngineByName(String name);
    ScriptEngine getEngineByExtension(String ext);
    void registerEngineName(String name, ScriptEngineFactory sef);
}
