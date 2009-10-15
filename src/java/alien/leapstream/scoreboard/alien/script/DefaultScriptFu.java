package leapstream.scoreboard.alien.script;

import leapstream.scoreboard.edge.javax.script.ScriptEngine;

import javax.script.Bindings;
import static javax.script.ScriptContext.ENGINE_SCOPE;

public final class DefaultScriptFu implements ScriptFu {
    public void bind(ScriptEngine engine, Args args) {
        Bindings bindings = engine.createBindings();
        for (Arg arg : args) bind(bindings, arg);
        engine.setBindings(bindings, ENGINE_SCOPE);
    }

    private void bind(Bindings bindings, Arg arg) {
        String name = arg.name();
        Object value = arg.value();
        bindings.put(name, value);
    }
}
