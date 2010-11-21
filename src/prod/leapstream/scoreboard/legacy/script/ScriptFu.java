package leapstream.scoreboard.legacy.script;

import leapstream.scoreboard.legacy.edge.javax.script.ScriptEngine;

public interface ScriptFu {
    void bind(ScriptEngine engine, Args args);
}
