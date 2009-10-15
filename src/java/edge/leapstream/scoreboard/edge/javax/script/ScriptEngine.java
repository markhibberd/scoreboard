package leapstream.scoreboard.edge.javax.script;

import au.net.netstorm.boost.bullet.scalpel.core.Edge;

import javax.script.Bindings;

public interface ScriptEngine extends Edge {
    void put(String key, Object value);

    Object eval(String code);

    Bindings createBindings();

    void setBindings(Bindings bindings, int scope);
}
